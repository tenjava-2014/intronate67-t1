package com.tenjava.entries.intronate67.t1.Economy;

import com.tenjava.entries.intronate67.t1.TenJava;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

/**
 * Created by Server on 7/11/2014.
 */
public class JoinListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){
        Player p = e.getPlayer();
        if(p.hasPlayedBefore()){
            return;
        }
        EconManager.setBalance(p.getUniqueId(), 250);
        double amount = TenJava.getInstance().accountsConfig.getDouble("start-amount");
        TenJava.getInstance().accountsConfig.set("balances." + p.getName(), amount);

    }

}
