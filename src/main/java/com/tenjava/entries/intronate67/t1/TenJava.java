package com.tenjava.entries.intronate67.t1;

import com.tenjava.entries.intronate67.t1.Economy.EconManager;
import com.tenjava.entries.intronate67.t1.combat.CombatListener;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

public class TenJava extends JavaPlugin {

    private static TenJava instance;

    public static TenJava getInstance(){
        return instance;
    }

    FileConfiguration config = getConfig();

    @Override
    public void onEnable(){
        Bukkit.getPluginManager().registerEvents(new CombatListener(), this);
        if(!getDataFolder().exists()){
            getDataFolder().mkdir();
        }

        new EconManager(this);
        saveConfig();
    }
    @Override
    public void onDisable(){

    }

}
