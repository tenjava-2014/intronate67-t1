package com.tenjava.entries.intronate67.t1.Economy;

import com.tenjava.entries.intronate67.t1.TenJava;
import com.tenjava.entries.intronate67.t1.UUIDGetter;
import org.bukkit.Bukkit;

import java.util.Arrays;
import java.util.Map;
import java.util.UUID;

/**
 * Created by Server on 7/11/2014.
 */
public class util {

    private static TenJava plugin = EconManager.getPlugin();

    private static UUIDGetter getter = new UUIDGetter(Arrays.asList("intronate67"));

    public static void saveBalances(){
        for(UUID playerId : EconManager.getBalanceMap().keySet()){
            String name = Bukkit.getPlayer(playerId).getName();
            plugin.getConfig().set("balance." + name, EconManager.getBalanceMap().get(playerId));
        }
        plugin.saveConfig();
    }
    public static void loadBalance(){
        //Load balances.
        if(!plugin.getConfig().contains("balance")) return;
        for(String s : plugin.getConfig().getConfigurationSection("balance").getKeys(false)){
            Map<String, UUID> response = null;
            try{
                response = getter.call();
            }catch(Exception e){
                e.printStackTrace();
            }

            EconManager.setBalance(response.get(s), plugin.getConfig().getDouble("balance." + s));
        }
    }


}
