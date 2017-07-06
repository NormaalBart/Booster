package me.BrutalNetwork.Balkan.Listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import me.BrutalNetwork.Balkan.Utils.Main;

public class onJoin implements Listener{
	
	private Main m;
	
	public onJoin(Main m){
		this.m = m;
	}
	
	@EventHandler
	public void on(PlayerJoinEvent e){
		Player p = (Player)e.getPlayer();
		m.DataHandler.loadData(p);
	}

}
