package me.nathampa0909.NY;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener{

	public void onEnable(){
		getLogger().info("[NYoutube] Plugin ligado!");
		saveDefaultConfig();
		
		Bukkit.getServer().getPluginManager().registerEvents(this, this);
	}
	
	public void onDisable(){
		getLogger().info("[NYoutube] Plugin desligado!");
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e){
		Player p = e.getPlayer();
		if(p.hasPermission(getConfig().getString("Permissao")) && !(p.isOp())){
			Bukkit.broadcastMessage(getConfig().getString("MensagemEntrada").replace("&", "§").replace("%player", p.getName()));
		}
	}
	
	@EventHandler
	public void onLeft(PlayerQuitEvent e){
		Player p = e.getPlayer();
		if(p.hasPermission(getConfig().getString("Permissao")) && !(p.isOp())){
			Bukkit.broadcastMessage(getConfig().getString("MensagemSaida").replace("&", "§").replace("%player", p.getName()));			
		}
	}
}
