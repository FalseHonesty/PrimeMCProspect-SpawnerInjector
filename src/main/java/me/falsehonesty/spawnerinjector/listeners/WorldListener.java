package me.falsehonesty.spawnerinjector.listeners;

import me.falsehonesty.spawnerinjector.SpawnerInjector;
import org.bukkit.block.BlockState;
import org.bukkit.craftbukkit.v1_8_R3.block.CraftCreatureSpawner;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.world.ChunkLoadEvent;

/**
 * Copyright 2017 (c) FalseHonesty
 */

public class WorldListener implements Listener {
    @EventHandler
    public void onChunkLoad(ChunkLoadEvent e) {
        BlockState[] tileEntities = e.getChunk().getTileEntities();

        for (BlockState tileEntity : tileEntities) {
            injectCreatureSpawner(tileEntity);
        }
    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent e) {
        injectCreatureSpawner(e.getBlock().getState());
    }

    private void injectCreatureSpawner(BlockState blockState) {
        if (blockState instanceof CraftCreatureSpawner) {
            SpawnerInjector.instance.injectSpawner((CraftCreatureSpawner) blockState);
        }
    }
}
