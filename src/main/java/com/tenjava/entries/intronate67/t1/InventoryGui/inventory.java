package com.tenjava.entries.intronate67.t1.InventoryGui;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

import java.util.Arrays;

/**
 * Created by Server on 7/12/2014.
 */
public class inventory {

    private String name;
    private int size;
    private Plugin plugin;
    private String[] optionName;
    private ItemStack[] optionIcons;

    public inventory(String name, int size, Plugin plugin, String[] optionName, ItemStack[] optionIcons){
        this.name = name;
        this.size = size;
        this.plugin = plugin;
        this.optionName = optionName;
        this.optionIcons = optionIcons;
    }

    public inventory setOption(int position, ItemStack icon, String name, String... info){
        optionName[position] = name;
        optionIcons[position] = setItemNameAndLore(icon, name, info);
        return this;
    }
    public void open(Player p){
        Inventory inv = Bukkit.createInventory(p, size, name);
        for(int i = 0; i < optionIcons.length; i++){
            if(optionIcons[i] != null){
                inv.setItem(i, optionIcons[i]);
            }

        }
        p.openInventory(inv);
    }
    public void destroy(){
        HandlerList.unregisterAll();
        plugin = null;
        optionName = null;
        optionIcons = null;
    }
    private ItemStack setItemNameAndLore(ItemStack item, String name, String[] lore){
        ItemMeta im = item.getItemMeta();
            im.setDisplayName(name);
            im.setLore(Arrays.asList(lore));
        item.setItemMeta(im);
        return item;
    }

}
