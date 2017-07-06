package me.BrutalNetwork.Balkan.Commands;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.BrutalNetwork.Balkan.Utils.EnchantmentID;
import me.BrutalNetwork.Balkan.Utils.Main;

public class BoosterCMD implements CommandExecutor{

	private Main m;
	public BoosterCMD(Main m){
		this.m = m;
	}
	
	public static HashMap<Player, Integer> taskid = new HashMap<>();
	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String cmdLabel, String[] args) {
		if (cmd.getName().equalsIgnoreCase("booster")){
			if (cs instanceof Player){
				Player p = (Player)cs;
				openGUI(p);	
			}
		}
		return false;
	}
	
	private void openGUI(Player p){
		Inventory inv = Bukkit.createInventory(null, 9, "                  §7Boosters");
		List<String> booster = new ArrayList<>();
		List<String> charity = new ArrayList<>();
		
		if (m.gui.BoosterKitPvP == false && m.gui.CharityKitPvP == false) return;
		else if (m.gui.BoosterKitPvP == true && m.gui.CharityKitPvP == false){
			if (Main.Booster.isEnabled()){
				for (String s : m.gui.BoosterEnabled){
					booster.add(s.replace("{BOOSTER}", "" + m.DataHandler.getBooster(p))
							.replace("{TIME}", Main.Booster.getFormattedTime())
							.replace("{PLAYER}", Main.Booster.getPlayer().getName()));
				}
				runTask(p, inv);
			}else{
				for (String s : m.gui.BoosterDisabled){
					booster.add(s.replace("{BOOSTER}", "" + m.DataHandler.getBooster(p)));
				}
			}
			setItemStack(inv, m.gui.BoosterMatarial, 1, m.gui.BoosterName, null, false, 4, booster);
		}else if (m.gui.BoosterKitPvP == false && m.gui.CharityKitPvP == true){
			if (m.MoneyBooster.isEnabled()){
				for (String s : m.gui.CharityEnabled){
					charity.add(s.replace("{CHARITYBOOSTER}", "" + m.DataHandler.getMoneyBooster(p))
							.replace("{TIME}", m.MoneyBooster.getFormattedTime())
							.replace("{PLAYER}", m.MoneyBooster.getPlayer().getName()));
				}
				runTask(p, inv);
			}else{
				for (String s : m.gui.CharityDisabled){
					charity.add(s.replace("{BOOSTER}", "" + m.DataHandler.getMoneyBooster(p)));
				}
			}
			setItemStack(inv, m.gui.CharityMatarial, 1, m.gui.CharityName, null, false, 4, charity);
		}else if (m.gui.BoosterKitPvP == true && m.gui.CharityKitPvP == true){
			if (Main.Booster.isEnabled()){
				for (String s : m.gui.BoosterEnabled){
					booster.add(s.replace("{BOOSTER}", "" + m.DataHandler.getBooster(p))
							.replace("{TIME}", Main.Booster.getFormattedTime())
							.replace("{PLAYER}", Main.Booster.getPlayer().getName()));
				}
				runTask(p, inv);
			}else{
				for (String s : m.gui.BoosterDisabled){
					booster.add(s.replace("{BOOSTER}", "" + m.DataHandler.getBooster(p)));
				}
			}
			setItemStack(inv, m.gui.BoosterMatarial, 1, m.gui.BoosterName, null, false, 2, booster);
			
			if (m.MoneyBooster.isEnabled()){
				for (String s : m.gui.CharityEnabled){
					charity.add(s.replace("{CHARITYBOOSTER}", "" + m.DataHandler.getMoneyBooster(p))
							.replace("{TIME}", m.MoneyBooster.getFormattedTime())
							.replace("{PLAYER}", m.MoneyBooster.getPlayer().getName()));
				}
				runTask(p, inv);
			}else{
				for (String s : m.gui.CharityDisabled){
					charity.add(s.replace("{CHARITYBOOSTER}", "" + m.DataHandler.getMoneyBooster(p)));
				}
			}
			setItemStack(inv, m.gui.CharityMatarial, 1, m.gui.CharityName, null, false, 6, charity);
		}else{
			m.getLogger().log(Level.WARNING, "didn't got the inventory... Error!");
		}
		p.openInventory(inv);
	}
	
	@SuppressWarnings("deprecation")
	private void runTask(final Player p, final Inventory inv) {
		taskid.put(p, Bukkit.getScheduler().scheduleAsyncRepeatingTask(m, new Runnable(){
			public void run(){
				if (m.gui.CharityKitPvP == true && m.gui.BoosterKitPvP == true){
					if (Main.Booster.isEnabled()){
						List<String> list = new ArrayList<>();
						for (String s : m.gui.BoosterEnabled){
							list.add(s.replace("{TIME}", Main.Booster.getFormattedTime())
									.replace("{PLAYER}", Main.Booster.getPlayer().getName())
									.replace("{BOOSTER}", "" + m.DataHandler.getBooster(p)));
						}
						setItemStack(inv, m.gui.BoosterMatarial, 1, m.gui.BoosterName, null, false, 2, list);
					}
					
					if (m.MoneyBooster.isEnabled()){
						List<String> list = new ArrayList<>();
						for (String s : m.gui.CharityEnabled){
							list.add(s.replace("{TIME}", m.MoneyBooster.getFormattedTime())
									.replace("{PLAYER}", m.MoneyBooster.getPlayer().getName())
									.replace("{CHARITYBOOSTER}", "" + m.DataHandler.getMoneyBooster(p)));
						}
						setItemStack(inv, m.gui.CharityMatarial, 1, m.gui.CharityName, null, false, 6, list);
					}
					p.updateInventory();
				}else if (m.gui.CharityKitPvP == true && m.gui.BoosterKitPvP == false){
					if (m.MoneyBooster.isEnabled()){
						List<String> list = new ArrayList<>();
						for (String s : m.gui.CharityEnabled){
							list.add(s.replace("{TIME}", m.MoneyBooster.getFormattedTime())
									.replace("{PLAYER}", m.MoneyBooster.getPlayer().getName())
									.replace("{CHARITYBOOSTER}", "" + m.DataHandler.getMoneyBooster(p)));
						}
						setItemStack(inv, m.gui.CharityMatarial, 1, m.gui.CharityName, null, false, 4, list);
					}
					p.updateInventory();
				}else if (m.gui.CharityKitPvP == false && m.gui.BoosterKitPvP == true){
					if (Main.Booster.isEnabled()){
						List<String> list = new ArrayList<>();
						for (String s : m.gui.BoosterEnabled){
							list.add(s.replace("{TIME}", Main.Booster.getFormattedTime())
									.replace("{PLAYER}", Main.Booster.getPlayer().getName())
									.replace("{BOOSTER}", "" + m.DataHandler.getBooster(p)));
						}
						setItemStack(inv, m.gui.BoosterMatarial, 1, m.gui.BoosterName, null, false, 4, list);
					}
					p.updateInventory();
				}else{
					m.getLogger().log(Level.WARNING, "didn't got the inventory... Error!");
				}
			}
		}, 0, 20));
	}

	private void setItemStack(Inventory inv, Material mat, Integer amount, String displayname, EnchantmentID id, 
			Boolean hideEnchants,Integer slot, List<String> lore){
		if (inv == null || mat == null || slot == null) return;
		ItemStack is;
		if (amount != null){
			is = new ItemStack(mat, amount);
		}else{
			is = new ItemStack(mat, 1);
		}
		ItemMeta im = is.getItemMeta();
		if (id != null){
			for (Enchantment ench : id.getIDs().keySet()){
				im.addEnchant(ench, id.getIDs().get(ench), true);
			}
			if (hideEnchants == true){
				im.addItemFlags(ItemFlag.HIDE_ENCHANTS);
			}	
		}
		
		if (lore != null){
			im.setLore(lore);
		}
		
		if (displayname != null){
			im.setDisplayName(displayname);
		}
		is.setItemMeta(im);
		
		inv.setItem(slot, is);
	}
}
