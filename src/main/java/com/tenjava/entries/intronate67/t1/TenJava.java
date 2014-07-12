package com.tenjava.entries.intronate67.t1;

import com.tenjava.entries.intronate67.t1.combat.JustAnotherListener;
import com.tenjava.entries.intronate67.t1.Economy.EconManager;
import com.tenjava.entries.intronate67.t1.Economy.JoinListener;
import com.tenjava.entries.intronate67.t1.combat.CombatListener;
import com.tenjava.entries.intronate67.t1.Economy.util;
import com.tenjava.entries.intronate67.t1.InventoryGui.InventoryListener;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public class TenJava extends JavaPlugin {

    private static TenJava instance;

    public static TenJava getInstance(){
        return instance;
    }

    public FileConfiguration config = getConfig();
    public File accounts = new File(getDataFolder(), "accounts.yml");
    public FileConfiguration accountsConfig = YamlConfiguration.loadConfiguration(accounts);
    @Override
    public void onEnable(){

        instance = this;

        if(!accounts.exists()){
            try{
                accounts.createNewFile();
            }catch(IOException e){
                e.printStackTrace();
            }
        }

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
        getConfig().options().copyDefaults(true);
        saveDefaultConfig();
        try {
            accountsConfig.save(accounts);
        } catch (IOException e) {
            e.printStackTrace();
        }
        saveConfig();
    }
    @Override
    public void onDisable(){
        util.saveBalances();
        try {
            accountsConfig.save(accounts);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
