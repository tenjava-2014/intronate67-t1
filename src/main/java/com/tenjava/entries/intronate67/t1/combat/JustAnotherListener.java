package com.tenjava.entries.intronate67.t1.combat;

import com.tenjava.entries.intronate67.t1.TenJava;
import com.tenjava.entries.intronate67.t1.economy.EconManager;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

/**
 * Created by Server on 7/12/2014.
 */
public class JustAnotherListener implements Listener{

    FileConfiguration config = TenJava.getInstance().getConfig();

    @EventHandler
    public void onEntityDeath(EntityDeathEvent e){

        Player Killer = e.getEntity().getKiller();

        if(!(e.getEntity() instanceof Player)) return;

        Player Killed = ((Player) e.getEntity()).getPlayer();

        if(!EconManager.hasAccount(Killed.getUniqueId())) return;
        if(EconManager.hasAccount(Killed.getUniqueId())) return;
        double amount = config.getDouble("rewards.pvp");
        EconManager.setBalance(Killer.getUniqueId(), EconManager.getBalance(Killer.getUniqueId()) + amount);
    }

}
