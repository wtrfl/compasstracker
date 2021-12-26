# Compass Tracker
A lightweight plugin that replicates the tracking compass in Dream's videos.

- The plugin only tracks one player.
- You have to right click the compass for the location to update.

### Installation
1. Use the releases page or [Spigot page](https://www.spigotmc.org/resources/compass-tracker.98687/) to download the .JAR file
   - <!> Your browser may warn that the download is unsafe. This is completely normal and just an extra layer of protection. Stay safe!
2. Place the .JAR file in the /plugins/ folder in your server folder.
   - Make sure you are using a [Spigot](https://getbukkit.org/download/spigot) server, or a fork of it, like [Paper](https://papermc.io/).
3. If your server is already running, use the `/reload confirm` command to reload the server. It will only take a second.
   
### Getting Started
1. Use /track along with the name of the player you want to track. (See Usage Below)
2. Give every hunter/tracker a compass.
3. Done!

## Config
As of now, the plugin only contains one config option, which is to show the Y level of the player you want to track. (`show-player-y`)

The config file should generate at `/plugins/CompassTracker/config.yml`

## Commands
### /track
This command sets the player that you want to track.

Usage: `/track <player>`

### /reloadtracker
This command reloads the config of the plugin. Use this if you have changed the config while the server is running.

Usage: `/reloadtracker`
