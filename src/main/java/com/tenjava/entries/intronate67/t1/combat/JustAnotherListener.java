package com.tenjava.entries.intronate67.t1.combat;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

/**
 * Created by Server on 7/12/2014.
 */
public class JustAnotherListener implements Listener{

    @EventHandler
    public void onEntityDeath(EntityDeathEvent e){

        Player Killer = e.getEntity().getKiller();

        if(!(e.getEntity() instanceof Player)) return;

        Player Killed = ((Player) e.getEntity()).getPlayer();


    }

}
