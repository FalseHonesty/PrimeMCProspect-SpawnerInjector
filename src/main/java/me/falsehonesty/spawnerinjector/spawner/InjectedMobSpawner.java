package me.falsehonesty.spawnerinjector.spawner;

import me.falsehonesty.spawnerinjector.utils.ReflectionHelper;
import net.minecraft.server.v1_8_R3.BlockPosition;
import net.minecraft.server.v1_8_R3.MobSpawnerAbstract;
import net.minecraft.server.v1_8_R3.TileEntityMobSpawner;
import net.minecraft.server.v1_8_R3.World;

/**
 * Copyright 2017 (c) FalseHonesty
 */

public class InjectedMobSpawner extends MobSpawnerAbstract {

    private TileEntityMobSpawner tileEntity;

    public InjectedMobSpawner(TileEntityMobSpawner tileEntity) throws NoSuchFieldException {
        super();

        this.tileEntity = tileEntity;

        ReflectionHelper.setPrivateValue(MobSpawnerAbstract.class.getDeclaredField("requiredPlayerRange"),
                this, 32);
    }

    @Override
    public void a(int i) {
        // On spawner place?
    }

    @Override
    public World a() {
        // Get world?
        return tileEntity.getWorld();
    }

    @Override
    public BlockPosition b() {
        // Get position?
        return tileEntity.getPosition();
    }
}
