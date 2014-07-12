package com.tenjava.entries.intronate67.t1.combat;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;

/**
 * Created by Server on 7/11/2014.
 */
public class CombatListener implements Listener {

    public int expCounter;

    @EventHandler
    public void onPlayerInteract(PlayerInteractEntityEvent e){



    }
    @EventHandler
    public void onBowUse(EntityShootBowEvent e){
        if(!(e.getEntity() instanceof Player)){
            return;
        }
        Player p = ((Player) e.getEntity()).getPlayer();

    }
    @EventHandler
    public void onPlayerCrouch(PlayerToggleSneakEvent e){
        Player p = e.getPlayer();
        if(!p.getItemInHand().equals(Material.BOW)){
            return;
        }

    }

}
