package com.tenjava.entries.intronate67.t1.InventoryGui;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

/**
 * Created by Server on 7/12/2014.
 */
public class inventory {

    private boolean fireball;
    private boolean op;
    private boolean water;
    private boolean push;
    private boolean drop;

    private Inventory gui;

    public void openInventoryGui(Player p, int rows, ItemStack item){

        ItemStack i = item;
        ItemMeta m = i.getItemMeta();
        gui = Bukkit.createInventory(p, rows * 9, "Abilities");
        if(p.hasPermission("abilities.fireball")) fireball = true;

        if(p.hasPermission("abilities.op")) op = true;

        if(p.hasPermission("abilities.water")) water = true;

        if(p.hasPermission("abilities.push")) push = true;

        if(p.hasPermission("abilities.drop")) drop = true;


    }

}
