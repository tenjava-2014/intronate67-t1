package com.tenjava.entries.intronate67.t1;

import com.tenjava.entries.intronate67.t1.combat.JustAnotherListener;
import com.tenjava.entries.intronate67.t1.economy.EconManager;
import com.tenjava.entries.intronate67.t1.economy.JoinListener;
import com.tenjava.entries.intronate67.t1.combat.CombatListener;
import com.tenjava.entries.intronate67.t1.economy.util;
import com.tenjava.entries.intronate67.t1.inventorygui.InventoryListener;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class TenJava extends JavaPlugin {

    private static TenJava instance;

    public static TenJava getInstance(){
        return instance;
    }

    FileConfiguration config = getConfig();

    @Override
    public void onEnable(){

        instance = this;

        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new CombatListener(), this);
        pm.registerEvents(new JoinListener(), this);
        pm.registerEvents(new InventoryListener(), this);
        pm.registerEvents(new JustAnotherListener(), this);

        if(!getDataFolder().exists()){
            getDataFolder().mkdir();
        }
        getCommand("bal").setExecutor(new CommandHandler(this));
        getCommand("abil").setExecutor(new CommandHandler(this));

        new EconManager(this);
        util.loadBalance();
        saveConfig();
    }
    @Override
    public void onDisable(){
        util.saveBalances();
    }

}
