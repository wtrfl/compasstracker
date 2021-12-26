package com.themonomew.compasstracker.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class TrackCommand implements CommandExecutor {

    Plugin plugin;

    public TrackCommand(Plugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(args.length != 1) {
            sender.sendMessage(ChatColor.RED + "Usage: /track <player>");
            return true;
        }

        Player toTrack;

        try {
            toTrack = sender.getServer().getPlayer(args[0]);
        } catch (IllegalArgumentException e) {
            sender.sendMessage(ChatColor.RED + args[0] + " is not a player!");
            return true;
        }

        String message = "All compasses are now set to track " + ChatColor.GREEN + args[0] + "\n";
        message += ChatColor.YELLOW + "Remember to right click the compass to update it!";
        sender.sendMessage(message);

        return true;
    }
}
