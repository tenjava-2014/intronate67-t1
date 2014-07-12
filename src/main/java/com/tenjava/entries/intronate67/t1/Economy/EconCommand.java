package com.tenjava.entries.intronate67.t1.Economy;

import com.tenjava.entries.intronate67.t1.SubCommand;
import org.bukkit.entity.Player;

/**
 * Created by Server on 7/11/2014.
 */
public class EconCommand implements SubCommand{

    public boolean onCommand(Player p, String[] args){
        if(args.length != 1){
            p.sendMessage("Nope");
            return true;
        }
        if(!EconManager.hasAccount(p.getUniqueId())){
            p.sendMessage("You do not have an account!");
            return true;
        }
        double balance = EconManager.getBalance(p.getUniqueId());
        p.sendMessage("Your balance is " + balance);
        return true;
    }
    public String help(Player p){
        return "";
    }
    public String permission(){
        return "";
    }


}
