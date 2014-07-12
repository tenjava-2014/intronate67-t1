package com.tenjava.entries.intronate67.t1.Economy;

import com.tenjava.entries.intronate67.t1.TenJava;
import com.tenjava.entries.intronate67.t1.UUIDGetter;
import org.bukkit.Bukkit;

import java.io.IOException;
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
            plugin.accountsConfig.set("balance." + name, EconManager.getBalanceMap().get(playerId));
        }
        try{
            plugin.accountsConfig.save(plugin.accounts);
        }catch(IOException e){
            e.printStackTrace();
        }

    }
    public static void loadBalance(){
        //Load balances.
        if(!plugin.accountsConfig.contains("balance")) return;
        for(String s : plugin.accountsConfig.getConfigurationSection("balance").getKeys(false)){
            Map<String, UUID> response = null;
            try{
                response = getter.call();
            }catch(Exception e){
                e.printStackTrace();
            }

            EconManager.setBalance(response.get(s), plugin.accountsConfig.getDouble("balance." + s));
        }
    }


}
