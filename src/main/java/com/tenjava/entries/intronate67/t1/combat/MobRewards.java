package com.tenjava.entries.intronate67.t1.combat;

import com.tenjava.entries.intronate67.t1.Economy.EconManager;
import com.tenjava.entries.intronate67.t1.TenJava;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Monster;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

/**
 * Created by Server on 7/12/2014.
 */
public class MobRewards implements Listener{

    @EventHandler
    public void onEnityDeath(EntityDeathEvent e){
        Entity entity = e.getEntity();
        if(!(e.getEntity().getKiller() instanceof Player)) return;
        Player p = e.getEntity().getKiller();

        if(entity instanceof Monster){
            double amount = TenJava.getInstance().getConfig().getDouble("rewards.monster." + e.getEntity().getType());
            EconManager.setBalance(p.getUniqueId(), EconManager.getBalance(p.getUniqueId()) + amount);

        }else{
            double amount = TenJava.getInstance().getConfig().getDouble("rewardss.animals." + e.getEntity().getType());
            EconManager.setBalance(p.getUniqueId(), EconManager.getBalance(p.getUniqueId()) + amount);
        }


    }

}
