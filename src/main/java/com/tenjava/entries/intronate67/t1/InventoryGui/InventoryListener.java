package com.tenjava.entries.intronate67.t1.InventoryGui;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

/**
 * Created by Server on 7/12/2014.
 */
public class InventoryListener implements Listener{

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e){

        if(!e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) return;

        if(e.getPlayer().getItemInHand().equals(Material.COMPASS)) return;

        Player p = e.getPlayer();

        if(!p.hasPermission("abilities.gui")) return;

    }



}
