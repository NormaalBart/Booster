package me.BrutalNetwork.Balkan.Listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import me.BrutalNetwork.Balkan.Utils.Main;

public class PlayerDeath implements Listener {
	
	private Main m;
	public PlayerDeath(Main m){
		this.m = m;
	}
	
	@EventHandler
	public void on(PlayerDeathEvent e){
		if (e.getEntity() instanceof Player && e.getEntity().getKiller() instanceof Player){
			Player p = (Player)e.getEntity();
			Player k = (Player)p.getKiller();
			if (Main.Booster.isEnabled()){
				if (m.messages.KillMessageEnabled){
					k.sendMessage(m.messages.KitPvPMessage.replace("{TARGET}", p.getName())
							.replace("{MONEY}", "" + m.messages.moneyEarned*m.messages.multiply));
				}
				m.economy.depositPlayer(k, m.messages.moneyEarned*2);
			}else{
				if (m.messages.KillMessageEnabled){
					k.sendMessage(m.messages.KitPvPMessage.replace("{TARGET}", p.getName())
							.replace("{MONEY}", "" + m.messages.moneyEarned));
				}
				m.economy.depositPlayer(k, m.messages.moneyEarned);
				
			}
		}
	}

}
