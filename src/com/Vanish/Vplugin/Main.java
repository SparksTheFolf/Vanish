package com.Vanish.Vplugin;

import java.util.List;
import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
	
	@Override
	public void onEnable() {
		System.out.println("Vanish ENABLED");
	}
	
	List<Player> vanished = new ArrayList<>();

	
	@Override
	public void onDisable() {
		System.out.println("Vanish DISABLED");
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(sender instanceof Player) {
			Player player = (Player) sender;
			
			if (cmd.getName().equalsIgnoreCase("vanish")) {
				if(vanished.contains(player)) {
				   vanished.remove(player);
				   for(Player target : Bukkit.getOnlinePlayers()) {
						target.showPlayer(player);
					}
				   
				   player.sendMessage("Un-Vanished");
				}else {					
					vanished.add(player);	
					for(Player target : Bukkit.getOnlinePlayers()) {
						target.hidePlayer(player);
					}
					   player.sendMessage("Vanished");
				}
			}
		}
		
		return false;
	}
}
