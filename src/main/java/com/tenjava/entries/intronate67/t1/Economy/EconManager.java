package com.tenjava.entries.intronate67.t1.Economy;

import com.tenjava.entries.intronate67.t1.TenJava;
import org.bukkit.Bukkit;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by Server on 7/11/2014.
 */
public class EconManager {

    private static TenJava plugin;

    public EconManager(TenJava plugin){
        this.plugin = plugin;
    }

    public static HashMap<UUID, Double> bal = new HashMap<UUID, Double>();

    public static void setBalance(UUID playerId, double amount){
        bal.put(playerId, amount);
    }
    public static double getBalance(UUID playerId){
        return bal.get(playerId);
    }
    public static boolean hasAccount(UUID playerId){
        return bal.containsKey(playerId);
    }
    public static HashMap<UUID, Double> getBalanceMap(){
        return bal;
    }

    public static TenJava getPlugin(){
        return plugin;
    }
    public static void getTopBalance(UUID playerId){
        Map.Entry<UUID, Double> maxEntry = null;
        for(Map.Entry<UUID, Double> entry : bal.entrySet()){
            if(maxEntry == null || entry.getValue() > maxEntry.getValue()){
                maxEntry = entry;
            }
        }
        UUID maxPlayerId = maxEntry.getKey();
        String playerName = Bukkit.getServer().getPlayer(maxPlayerId).getName();
        double maxValue = maxEntry.getValue().doubleValue();
        //TODO: send message.
        return;

    }

}
