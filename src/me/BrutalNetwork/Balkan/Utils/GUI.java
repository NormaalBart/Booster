package me.BrutalNetwork.Balkan.Utils;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;

public class GUI {
	
	public GUI() {}
	 
	public Boolean CharityKitPvP = false;
	public Material CharityMatarial = Material.DIAMOND;
	public String CharityName = "&3»&a Charity Time &6($$$)";
	public List<String> CharityEnabled = new ArrayList<>();
	public List<String> CharityDisabled = new ArrayList<>();
	
	public Boolean BoosterKitPvP= true;
	public Material BoosterMatarial = Material.EMERALD;
	public String BoosterName = "§3»§a Market Sell Multiplier §6(2x)";
	public List<String> BoosterEnabled = new ArrayList<>();
	public List<String> BoosterDisabled = new ArrayList<>();
}
