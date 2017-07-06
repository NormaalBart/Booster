package me.BrutalNetwork.Balkan.Utils;

import java.io.File;
import java.io.IOException;

import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class Config {
	
	Main m;
	
	public Config(Main m){
		this.m = m;
	}
	
	public FileConfiguration getData(){
        File f = new File(m.getDataFolder(), "data.yml");
        FileConfiguration d = YamlConfiguration.loadConfiguration(f);
		return d;
	}
	
	public FileConfiguration getMessages(){
        File f = new File(m.getDataFolder(), "messages.yml");
        FileConfiguration d = YamlConfiguration.loadConfiguration(f);
		return d;
	}

	public void makeData() {
		//NOTE: 'm' stands for the Main class. This has to be changed most of the time by you.
		File file = null;
        try {
            if (!m.getDataFolder().exists()) { //Check if the directory of the plugin exists...
            	m.getDataFolder().mkdirs(); //If not making one.
            }
            file = new File(m.getDataFolder(), "data.yml"); // Defining file to data.yml NOTE: This file has to be also in your Project, even if it's empty.
            if (!file.exists()) { //Check if it exists
            	m.getLogger().info("data.yml not found, creating!"); //Log that it is creating
            	m.saveResource("data.yml", true); //Saving the resource, This is all by Java done no Spigot noeeded. 
            } else {
            	m.getLogger().info("data.yml found, loading!"); //If it is already there, load it.
            	//TODO: Loading...
            }
        } catch (Exception e) {
            e.printStackTrace();//If something returned a NPE or something it will print a stacktrace...
        }
	}

	public void makeGUI(){
		File file = null;
        try {
            if (!m.getDataFolder().exists()) {
            	m.getDataFolder().mkdirs();
            }
            file = new File(m.getDataFolder(), "GUI.yml");
            if (!file.exists()) {
            	m.getLogger().info("GUI.yml not found, creating!");
            	m.saveResource("GUI.yml", true);
            } else {
            	m.getLogger().info("GUI.yml found, loading!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	public void makeMessages(){
		File file = null;
        try {
            if (!m.getDataFolder().exists()) {
            	m.getDataFolder().mkdirs();
            }
            file = new File(m.getDataFolder(), "messages.yml");
            if (!file.exists()) {
            	m.getLogger().info("messages.yml not found, creating!");
            	m.saveResource("messages.yml", true);
            } else {
            	m.getLogger().info("messages.yml found, loading!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	public void saveData(FileConfiguration data){
        File f = new File(m.getDataFolder(), "data.yml");
		try {
			data.save(f);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void saveGUI(FileConfiguration gui){
		File f = new File(m.getDataFolder().getPath(), "GUI.yml");
		FileConfiguration mes = YamlConfiguration.loadConfiguration(f);
		try {
			mes.save(f);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void saveMessages(){
		File f = new File(m.getDataFolder().getPath(), "messages.yml");
		FileConfiguration mes = YamlConfiguration.loadConfiguration(f);
		try {
			mes.save(f);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void loadGUI(){
        File file = new File(m.getDataFolder(), "GUI.yml");
		FileConfiguration gui = YamlConfiguration.loadConfiguration(file);
		
		m.gui.CharityKitPvP = gui.getBoolean("GUI.Charity-Time.KitPvPMode");
		if(isMaterial(gui.getString("GUI.Charity-Time.Material"))){
			Material mat = Material.matchMaterial(gui.getString("GUI.Charity-Time.Material"));
			m.gui.CharityMatarial = mat;
		}
		m.gui.CharityName = gui.getString("GUI.Charity-Time.Name").replace("&", "§");
		
		for (String s : gui.getStringList("GUI.Charity-Time.Lore.When-Enabled")){
			m.gui.CharityEnabled.add(s.replace("&", "§"));
		}
		
		for (String s : gui.getStringList("GUI.Charity-Time.Lore.When-Disabled")){
			m.gui.CharityDisabled.add(s.replace("&", "§"));
		}
		
		m.gui.BoosterKitPvP = gui.getBoolean("GUI.Booster-Time.KitPvPMode");
		if(isMaterial(gui.getString("GUI.Booster-Time.Material"))){
			Material mat = Material.matchMaterial(gui.getString("GUI.Booster-Time.Material"));
			m.gui.BoosterMatarial = mat;
		}
		m.gui.BoosterName = gui.getString("GUI.Booster-Time.Name").replace("&", "§");
		
		for (String s : gui.getStringList("GUI.Booster-Time.Lore.When-Enabled")){
			m.gui.BoosterEnabled.add(s.replace("&", "§"));
		}
		
		for (String s : gui.getStringList("GUI.Booster-Time.Lore.When-Disabled")){
			m.gui.BoosterDisabled.add(s.replace("&", "§"));
		}
	}

	public void loadMessage() {
        File file = new File(m.getDataFolder(), "messages.yml");
		FileConfiguration messages = YamlConfiguration.loadConfiguration(file);
		m.messages.activebooster = messages.getString("ActiveBooster").replace("&", "§");
		m.messages.boosteractivated = messages.getString("BoosterActivated").replace("&", "§");
		m.messages.boosteradded = messages.getString("BoosterAdded").replace("&", "§");
		m.messages.boosterremove = messages.getString("BoosterRemoved").replace("&", "§");
		m.messages.boostersetted = messages.getString("BoosterSetted").replace("&", "§");
		m.messages.adminboostersetted = messages.getString("AdminBoosterSetted").replace("&", "§");
		m.messages.nobooster = messages.getString("NoBooster").replace("&", "§");
		m.messages.nopermission = messages.getString("NoPermission").replace("&", "§");
		m.messages.numberformat = messages.getString("NumberFormat").replace("&", "§");
		m.messages.formatexception = messages.getString("FormatException").replace("&", "§");
		m.messages.playernotonline = messages.getString("PlayerNotOnline").replace("&", "§");
		m.messages.adminboosteradded = messages.getString("AdminBoosterAdded").replace("&", "§");
		m.messages.adminboosterremove = messages.getString("AdminBoosterRemoved").replace("&", "§");
		
		m.messages.moneyboosteradded = messages.getString("moneyboosterAdded").replace("&", "§");
		m.messages.moneyboosterremove = messages.getString("moneyboosterRemoved").replace("&", "§");
		m.messages.adminmoneyboosteradded = messages.getString("AdminmoneyboosterAdded").replace("&", "§");
		m.messages.adminmoneyboosterremove = messages.getString("AdminmoneyboosterRemoved").replace("&", "§");
		m.messages.moneyboostersetted = messages.getString("MoneyBoosterSetted").replace("&", "§");
		m.messages.adminmoneyboostersetted = messages.getString("AdminMoneyBoosterSetted").replace("&", "§");
		
		m.messages.boostertime = messages.getInt("Booster.Time");
		
		m.messages.TipNoBoosters = messages.getString("Tip.NoBoosters").replace("&", "§");
		m.messages.TipMessage = messages.getString("Tip.Message").replace("&", "§");
		m.messages.TipTargetMessage = messages.getString("Tip.TargetMessage").replace("&", "§");
		m.messages.TipAlreadyTipped = messages.getString("Tip.AlreadyTipped").replace("&", "§");
		m.messages.TipYouself = messages.getString("Tip.TipYourself").replace("&", "§");
		m.messages.TipMoney = messages.getDouble("Tip.Money");
		
		m.messages.multiply = messages.getDouble("KitPvP.multiply");
		m.messages.KillMessageEnabled = messages.getBoolean("KitPvP.KillMessageEnabled");
		m.messages.KitPvPMessage = messages.getString("KitPvP.Message").replace("&", "§");
		if (messages.getBoolean("KitPvP.isKitPvP")){
			m.messages.moneyEarned = messages.getDouble("KitPvP.moneyEarned");
		}
		
		for (String s : messages.getStringList("Booster.endmessage")){
			String m = s.replace("&", "§");
			this.m.messages.endmessage.add(m);
		}
		
		for (String s : messages.getStringList("Booster.message")){
			String m = s.replace("&", "§");
			this.m.messages.message.add(m);
		}
		
		for (String s : messages.getStringList("MoneyBooster.message")){
			String m = s.replace("&", "§");
			this.m.messages.moneymessage.add(m);
		}
		
		for (String s : messages.getStringList("MoneyBooster.broadcastMessage")){
			String m = s.replace("&", "§");
			this.m.messages.moneybroadcastmessage.add(m);
		}
		for (String s : messages.getStringList("MoneyBooster.endbroadcastMessage")){
			String m = s.replace("&", "§");
			this.m.messages.endmoneybroadcastmessage.add(m);
		}
		
		
		m.messages.times = messages.getInt("MoneyBooster.Times");
		m.messages.time = messages.getInt("MoneyBooster.Time");
		m.messages.money = messages.getDouble("MoneyBooster.Money");
		
		m.getLogger().info("§cThe messages are reloaded!");
	}
	
	private boolean isMaterial(String line) {
		String material = line.toUpperCase();
		if (material.contains(" ")){
			material = material.replace(" ", "_");
		}
		Material mat = Material.matchMaterial(material);
		if (mat == null){
			return false;
		}else{
			return true;
		}
	}
}
