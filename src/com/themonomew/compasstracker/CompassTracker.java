package com.themonomew.compasstracker;

import com.themonomew.compasstracker.commands.ReloadCommand;
import com.themonomew.compasstracker.commands.TrackCommand;
import com.themonomew.compasstracker.events.Events;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class CompassTracker extends JavaPlugin {

    Player tracked;
    Config config = new Config(this);
    Events events = new Events(tracked, config);

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(events, this);
        getCommand("track").setExecutor(new TrackCommand(this));
        getCommand("reloadtracker").setExecutor(new ReloadCommand(config));
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "Compass Tracker v1 was loaded.");
    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "Compass Tracker has turned off!");
    }

}
