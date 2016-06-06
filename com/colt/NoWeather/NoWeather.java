package com.colt.noweather;

import java.util.ArrayList;
import java.util.List;

			if (Bukkit.getWorld(world) == null) {ld in config: " + world);
			} else {
				worlds.add(world);
			}
		}
	}

	@EventHandler
	public void WeatherChangeEvent(WeatherChangeEvent event) {
		if (event.toWeathe()) {
			if (worlds.contains(event.getWorld().getName())) {
				event.setC
}
