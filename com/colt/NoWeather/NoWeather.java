package com.colt.noweather;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class NoWeather extends JavaPlugin implements Listener {

	private List<String> worlds = new ArrayList<String>();

	public void onEnable() {
		Bukkit.getPluginManager().registerEvents(this, this);
		saveDefaultConfig();

		for (String world : getConfig().getStringList("worlds")) {
			if (Bukkit.getWorld(world) == null) {
				getLogger().info("Invalid world in config: " + world);
			} else {
				worlds.add(world);
			}
		}
	}

	@EventHandler
	public void WeatherChangeEvent(WeatherChangeEvent event) {
		if (event.toWeatherState()) {
			if (worlds.contains(event.getWorld().getName())) {
				event.setCancelled(true);
			}
		}
	}
}
