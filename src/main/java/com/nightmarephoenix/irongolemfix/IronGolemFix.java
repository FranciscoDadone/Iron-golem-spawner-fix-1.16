package com.nightmarephoenix.irongolemfix;

import com.nightmarephoenix.irongolemfix.listeners.ItemSpawner;
import com.nightmarephoenix.irongolemfix.listeners.SpawnListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class IronGolemFix extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new SpawnListener(), this);     // enabling the listener
        getServer().getPluginManager().registerEvents(new ItemSpawner(), this);       // enabling the listener
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
