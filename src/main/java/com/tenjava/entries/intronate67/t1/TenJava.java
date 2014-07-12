package com.tenjava.entries.intronate67.t1;

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
        if(config.getString("mysql.hostname").equals(null)){
            getLogger().log(Level.WARNING, "Host name not set in config file... disabling plugin.");
            getServer().getPluginManager().disablePlugin(this);
        }
        if(config.getString("mysql.port").equals(null)){
            getLogger().log(Level.WARNING, "Host name not set in config file... disabling plugin.");
            getServer().getPluginManager().disablePlugin(this);
        }
        if(config.getString("mysql.database").equals(null)){
            getLogger().log(Level.WARNING, "Host name not set in config file... disabling plugin.");
            getServer().getPluginManager().disablePlugin(this);
        }
        String hostName = config.getString("mysql.hostname");
        String port = config.getString("mysql.port");
        String dataBase = config.getString("mysql.database");
        String user = config.getString("mysql.username");
        String password = config.getString("mysql.pass");
        //TODO: Put MYSQL CONSTRUCTOR/STUFF
        saveConfig();
    }
    @Override
    public void onDisable(){

    }

}
