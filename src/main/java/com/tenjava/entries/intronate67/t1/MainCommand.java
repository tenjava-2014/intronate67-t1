package com.tenjava.entries.intronate67.t1;

import org.bukkit.entity.Player;

/**
 * Created by Server on 7/11/2014.
 */
public class MainCommand implements SubCommand{

    public boolean onCommand(Player p, String[] args){

        return true;
    }
    public String help(Player p){
        return "";
    }
    public String permission(){
        return "";
    }

}
