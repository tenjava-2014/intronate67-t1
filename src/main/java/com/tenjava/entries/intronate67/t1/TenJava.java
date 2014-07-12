package com.tenjava.entries.intronate67.t1;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class TenJava extends JavaPlugin {

    FileConfiguration config = getConfig();

    @Override
    public void onEnable(){
        if(!getDataFolder().exists()){
            getDataFolder().mkdir();
        }
        saveConfig();
    }
    @Override
    public void onDisable(){

    }

}
