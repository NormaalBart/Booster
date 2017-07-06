package me.BrutalNetwork.Balkan.Utils;

import java.util.HashMap;

import org.bukkit.enchantments.Enchantment;

public class EnchantmentID {
	
	Main m;
	public EnchantmentID(Main m){
		this.m = m;
	}
	
	HashMap<Enchantment, Integer> ID = new HashMap<>();
	public void setEnchantmentID(Enchantment ench, Integer level){
		ID.put(ench, level);
	}
	
	public void resetID(){
		ID.clear();
	}
	
	public void clearID(){
		ID.clear();
	}

	public HashMap<Enchantment, Integer> getIDs(){
		return ID;
	}
}
