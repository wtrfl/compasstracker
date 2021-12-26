package com.themonomew.compasstracker.commands;

import com.themonomew.compasstracker.Config;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ReloadCommand implements CommandExecutor {

    private final Config config;

    public ReloadCommand(Config config) {
        this.config = config;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(args.length != 0) {
            sender.sendMessage(ChatColor.RED + "Usage: /reloadtracker");
        }

        config.reload();
        sender.sendMessage(ChatColor.GREEN + "Tracker config file reloaded");
        return true;
    }
}
