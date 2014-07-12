package com.tenjava.entries.intronate67.t1;

import com.tenjava.entries.intronate67.t1.Economy.EconManager;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

public class TenJava extends JavaPlugin {

    FileConfiguration config = getConfig();

    @Override
    public void onEnable(){
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
