package com.tenjava.entries.intronate67.t1;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.scheduler.BukkitRunnable;

/**
 * Created by Server on 7/11/2014.
 */
public class MainCommand implements SubCommand{

    private boolean opAbilityRunnning = false;
    private int n;
    public boolean onCommand(final Player p, String[] args){

        if(args[0].equalsIgnoreCase("op")){
            if(!p.hasPermission("abilities.op")){
                return true;
            }
            if(args[1].equalsIgnoreCase("start")){
                if(opAbilityRunnning){
                    p.sendMessage("Already running!");
                    return true;
                }
                n = Bukkit.getScheduler().scheduleSyncRepeatingTask(TenJava.getInstance(), new BukkitRunnable() {
                    @Override
                    public void run() {
                       Block block = p.getTargetBlock(null, 100);
                       Location loc = block.getLocation();
                       Entity tnt = loc.getWorld().spawn(loc, TNTPrimed.class);
                    }
                }, 0L, 40L);
            }
            if(args[1].equalsIgnoreCase("stop")){
                if(!opAbilityRunnning){
                    p.sendMessage("Is not running");
                    return true;
                }
                Bukkit.getScheduler().cancelTask(n);
                p.sendMessage("stopped");
            }

        }
        return true;
    }
    public String help(Player p){
        return "";
    }
    public String permission(){
        return "";
    }
}
