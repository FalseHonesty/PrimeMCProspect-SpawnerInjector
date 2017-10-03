package me.falsehonesty.spawnerinjector;

import me.falsehonesty.spawnerinjector.spawner.InjectedMobSpawner;
import me.falsehonesty.spawnerinjector.utils.ReflectionHelper;
import net.minecraft.server.v1_8_R3.TileEntityMobSpawner;
import org.bukkit.craftbukkit.v1_8_R3.block.CraftCreatureSpawner;
import org.bukkit.plugin.java.JavaPlugin;

import java.lang.reflect.Field;

public final class SpawnerInjector extends JavaPlugin {

    public static SpawnerInjector instance;

    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public void injectSpawner(CraftCreatureSpawner ccs) {
        if (ccs.getTileEntity().getSpawner() instanceof InjectedMobSpawner) {
            return;
        }

        try {
            Field spawnerField = TileEntityMobSpawner.class.getDeclaredField("a");

            TileEntityMobSpawner tileEntityMobSpawner = ccs.getTileEntity();
            ReflectionHelper.setPrivateValue(spawnerField, tileEntityMobSpawner, new InjectedMobSpawner(tileEntityMobSpawner));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}
