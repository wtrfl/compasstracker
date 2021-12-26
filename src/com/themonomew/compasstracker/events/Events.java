package com.themonomew.compasstracker.events;

import com.themonomew.compasstracker.Config;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerPortalEvent;

public class Events implements Listener {

    Player tracked;
    Config config;

    private Location lastPlayerLocation;

    public Events(Player tracked, Config config) {
        this.tracked = tracked;
        this.config = config;
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e) {
        Player player = e.getPlayer();
        Action action = e.getAction();
        Material held = e.getItem().getType();

        if(player == tracked) return;
        if(held != Material.COMPASS) return;
        if(action != Action.RIGHT_CLICK_AIR && action != Action.RIGHT_CLICK_BLOCK) return;

        if(tracked.getWorld().equals(player.getWorld())) {
            player.setCompassTarget(tracked.getLocation());
        } else if (lastPlayerLocation != null) {
            player.setCompassTarget(lastPlayerLocation);
        } else {
            player.sendMessage(ChatColor.RED + "Could not find that player!");
        }

        String message = ChatColor.GREEN + "Now tracking " + tracked.getDisplayName();
        if(config.showY()) { message += " y = " + tracked.getLocation().getY(); };
        player.sendMessage(message);
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onPlayerPortal(PlayerPortalEvent event) {
        if (event.getCause().toString().equals("NETHER_PORTAL") || event.getCause().toString().equals("END_PORTAL")){
            if (event.getFrom().getWorld().getEnvironment().equals(World.Environment.NORMAL)
                    && event.getPlayer() == tracked){
                lastPlayerLocation = event.getFrom();
            }
        }
    }

}
