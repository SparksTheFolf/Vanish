package com.Vanish.Vplugin;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
	
	@Override
	public void onEnable() {
		System.out.println("Vanish ENABLED");
	}

	
	@Override
	public void onDisable() {
		System.out.println("Vanish DISABLED");
	}
}
