package com.tenjava.entries.intronate67.t1.combat;

import com.tenjava.entries.intronate67.t1.TenJava;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.Random;

/**
 * Created by Server on 7/11/2014.
 */
public class CombatListener implements Listener {

    public int n;
    public int expCounter;

    @EventHandler
    public void onPlayerRightClick(PlayerInteractEvent e){
        /*Random rand = new Random();
        int n = rand.nextInt(8);
        if(n == 2){ //Launches fire ball
            Player p = e.getPlayer();
            if(!p.isBlocking()) return;
            if(!p.hasPermission("abilities.fireball")) return;
            Block block = p.getTargetBlock(null, 100);
            Location loc= block.getLocation();
            Entity ent = loc.getWorld().spawn(loc, Fireball.class);
            for(int i = 0; i < 10; i++){
                p.launchProjectile(Fireball.class).setVelocity(new Vector(loc.getX(), loc.getY(), loc.getZ()));
            }
            return;
        }
        if(n == 7){ //Push
            for(Entity entity : e.getPlayer().getWorld().getEntities()){
                if(entity.getLocation() == e.getPlayer().getEyeLocation()){
                    if(e.getPlayer().isBlocking()){
                        for(int i = 0; i < 10; i++) {
                            if (expCounter == 10) {
                                Vector looking = entity.getLocation().getDirection();
                                entity.setVelocity(looking.multiply(-2));
                            }
                        }
                    }
                }
            }
        }
        if(n == 1){ //Drop

        }
        */
        for(Entity entity : e.getPlayer().getWorld().getEntities()){
            if(entity.getLocation() == e.getPlayer().getEyeLocation()){
                if(e.getPlayer().isBlocking()){
                    for(int i = 0; i < 10; i++) {
                        if (expCounter == 10) {
                            Vector looking = entity.getLocation().getDirection();
                            entity.setVelocity(looking.multiply(-2));
                        }
                    }
                }
            }
        }
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEntityEvent e){
        Player p = e.getPlayer();

    }
    @EventHandler
    public void onBowUse(ProjectileLaunchEvent e){
        if(!(e.getEntity().getShooter() instanceof Player)){
            return;
        }
        Player p = ((Player) e.getEntity()).getPlayer();
        if(expCounter <= 0){
            return;
        }
        if(!(e.getEntity() instanceof Arrow)){
            return;
        }
        if(!p.hasPermission("abilities.explosivearrow"));
        Arrow arrow = (Arrow) e.getEntity();
        e.setCancelled(true);
        p.launchProjectile(Arrow.class).setVelocity(arrow.getVelocity().multiply(expCounter));
        Location loc = arrow.getLocation();
        Random rand = new Random(10);
        int n = rand.nextInt();
        if(n == 10){
            return;
        }
        return;
    }
    @EventHandler
    public void onPlayerCrouch(final PlayerToggleSneakEvent e){
        final Player p = e.getPlayer();
        if(!p.getItemInHand().equals(Material.BOW)){
            return;
        }
        n = Bukkit.getScheduler().scheduleSyncRepeatingTask(TenJava.getInstance(), new BukkitRunnable() {
            @Override
            public void run() {
                if(expCounter == 10){
                    Bukkit.getScheduler().cancelTask(n);
                    return;
                }
                p.setLevel(expCounter);
                expCounter++;
            }
        }, 0L, 20L);
    }
}
