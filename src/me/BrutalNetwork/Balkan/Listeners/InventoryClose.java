package me.BrutalNetwork.Balkan.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;

import me.BrutalNetwork.Balkan.Commands.BoosterCMD;

public class InventoryClose implements Listener{
	
	@EventHandler(ignoreCancelled = false)
	public void on(InventoryCloseEvent e){
		if (e.getPlayer() instanceof Player){
			Player p = (Player)e.getPlayer();
			Inventory inv = e.getInventory();
			if (inv.getName() == "                  §7Boosters" && inv.getSize() == 9){
				if (BoosterCMD.taskid.containsKey(p)){
					Bukkit.getScheduler().cancelTask(BoosterCMD.taskid.get(p));
					BoosterCMD.taskid.remove(p);	
				}
			}
		}
	}

}
