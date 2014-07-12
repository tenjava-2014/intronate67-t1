package com.tenjava.entries.intronate67.t1.InventoryGui;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

/**
 * Created by Server on 7/12/2014.
 */
public class InventoryListener implements Listener{

    private boolean fireball;
    private boolean op;
    private boolean push;
    private boolean drop;
    Inventory inv = null;

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e){

        if(!e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) return;

        if(!e.getPlayer().getItemInHand().equals(Material.COMPASS)) return;

        Player p = e.getPlayer();

        if(!p.hasPermission("abilities.gui")) return;

        inv = Bukkit.createInventory(p, 9, "Abilities");

        if(p.hasPermission("abilities.fireball")) fireball = true;

        if(p.hasPermission("abilities.op")) op = true;

        if(p.hasPermission("abilities.push")) push = true;

        if(p.hasPermission("abilities.push")) drop = true;

        ItemStack fireballItem = new ItemStack(Material.FIREBALL, 1);
        ItemMeta fireMeta = fireballItem.getItemMeta();
        fireMeta.setDisplayName("Fire Ball");
        fireMeta.setLore(Arrays.asList("Shoot people with fireballs."));
        fireballItem.setItemMeta(fireMeta);

        ItemStack tnt = new ItemStack(Material.TNT, 1);
        ItemMeta tntMeta = tnt.getItemMeta();
        tntMeta.setDisplayName("Eyes of Explosion");
        tntMeta.setLore(Arrays.asList("Blow everything up with your eyes!", "Warning Very Destructive"));
        tnt.setItemMeta(tntMeta);

        ItemStack pushItem = new ItemStack(Material.CACTUS, 1);
        ItemMeta pushMeta = pushItem.getItemMeta();
        pushMeta.setDisplayName("Push");
        pushMeta.setLore(Arrays.asList("Push people away from you to escape."));
        pushItem.setItemMeta(pushMeta);

        ItemStack dropItem = new ItemStack(Material.ANVIL, 1);
        ItemMeta dropMeta = dropItem.getItemMeta();
        dropMeta.setDisplayName("Drop");
        dropMeta.setLore(Arrays.asList("Drop people to lower their health!"));
        dropItem.setItemMeta(dropMeta);

        if(fireball){
            inv.addItem(fireballItem);
        }
        if(op){
            inv.addItem(tnt);
        }
        if(push){
            inv.addItem(pushItem);
        }
        if(drop){
            inv.addItem(dropItem);
        }
        p.openInventory(inv);


    }



}
