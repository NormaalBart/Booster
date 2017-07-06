package me.BrutalNetwork.Balkan.Listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import me.BrutalNetwork.Balkan.Utils.Main;

public class onLeave implements Listener{
	
	private Main m;
	public onLeave(Main m){
		this.m = m;
	}
	
	@EventHandler
	public void on(PlayerQuitEvent e){
		Player p = (Player)e.getPlayer();
		m.DataHandler.saveData(p);
	}

}
