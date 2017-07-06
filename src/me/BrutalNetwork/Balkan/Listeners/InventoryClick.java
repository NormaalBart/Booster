package me.BrutalNetwork.Balkan.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import me.BrutalNetwork.Balkan.Utils.Main;

public class InventoryClick implements Listener{
	
	private Main m;
	
	public InventoryClick(Main m) {
		this.m = m;
	}
	
	@EventHandler
	public void on(InventoryClickEvent e){
		if (e.getWhoClicked() instanceof Player){
			final Player p = (Player)e.getWhoClicked();
			Inventory inv = e.getClickedInventory();
			if(inv == null) return;
			try{
				if (inv.getName() == "                  §7Boosters" && inv.getSize() == 9){
					if (e.getCurrentItem() != null){
						e.setCancelled(true);
						ItemStack is = e.getCurrentItem();
						if (is == null){ return; }
						
						else if (is.getItemMeta().getDisplayName() == m.gui.BoosterName){
							e.setCancelled(true);
							if (m.DataHandler.getData(p).getBooster() <= 0){
								p.sendMessage(m.messages.nobooster);
								p.closeInventory();
								return;
							}else{
								if (!Main.Booster.isEnabled()){
									Main.Booster.setBooster(m.messages.boostertime, p);
									m.DataHandler.getData(p).setBooster(m.DataHandler.getData(p).getBooster() - 1);
									Main.Booster.startBooster();
									Bukkit.getScheduler().scheduleSyncDelayedTask(m, new Runnable(){
										public void run(){
											p.sendMessage(m.messages.boosteractivated
													.replace("{BOOSTER}", "" + m.DataHandler.getData(p).getBooster()));
										}
									}, 1);
									p.closeInventory();
									return;
								}else{
									p.sendMessage(m.messages.activebooster);
									p.closeInventory();
									return;
								}						
							}
						}else if (e.getCurrentItem().getItemMeta().getDisplayName() == m.gui.CharityName){
							e.setCancelled(true);
							if (m.DataHandler.getData(p).getMoneyBooster() <= 0){
								p.sendMessage(m.messages.nobooster
										.replace("booster", "moneybooster"));
								p.closeInventory();
								return;
							}else{
								if (!m.MoneyBooster.isEnabled()){
									m.MoneyBooster.setBooster(m.messages.time, m.messages.times, m.messages.money, p);
									m.DataHandler.getData(p).setMoneyBooster(m.DataHandler.getData(p).getMoneyBooster() - 1);
									m.MoneyBooster.startBooster();
									Bukkit.getScheduler().scheduleSyncDelayedTask(m, new Runnable(){
										public void run(){
											p.sendMessage(m.messages.boosteractivated
													.replace("{BOOSTER}", "" + m.DataHandler.getData(p).getMoneyBooster()));
										}
									}, 1);
									p.closeInventory();
									return;
								}else{
									p.sendMessage(m.messages.activebooster);
									p.closeInventory();
									return;
								}						
							}

						}else{
							e.setCancelled(true);
						}
					}
					else{
						e.setCancelled(true);
						return;
					}
					
				}
			}catch(NullPointerException npe){} 
			
		}
	}

}
