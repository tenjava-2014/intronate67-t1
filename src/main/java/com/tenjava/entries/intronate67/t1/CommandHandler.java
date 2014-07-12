package com.tenjava.entries.intronate67.t1;

import com.tenjava.entries.intronate67.t1.economy.EconCommand;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.util.HashMap;

/**
 * Created by Server on 7/11/2014.
 */
public class CommandHandler implements CommandExecutor{

    private Plugin plugin;
    private HashMap< String, SubCommand > commands;
    private HashMap < String, Integer > helpinfo;
    public CommandHandler(Plugin plugin) {
        this.plugin = plugin;
        commands = new HashMap < String, SubCommand > ();
        helpinfo = new HashMap < String, Integer > ();
        loadCommands();
        loadHelpInfo();
    }
    private void loadCommands(){
        commands.put("abil", new MainCommand());
        commands.put("bal", new EconCommand());
    }
    private void loadHelpInfo(){
        helpinfo.put("abil", 1);
    }
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String lable, String[] args){
        if(!(sender instanceof Player)){
            sender.sendMessage("Nope.");
        }
        Player p = (Player) sender;
        String sub = cmd.getLabel();
        if(!commands.containsKey(sub)){
            p.sendMessage("Nope.");
            return true;
        }
        try{
            commands.get(sub).onCommand(p, args);
        }catch(Exception e){
            e.printStackTrace();
        }
        return true;
    }
}
