package me.BrutalNetwork.Balkan.Utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import me.BrutalNetwork.Balkan.Commands.AdminCMD;
import me.BrutalNetwork.Balkan.Commands.BoosterCMD;
import me.BrutalNetwork.Balkan.Commands.TipCMD;
import me.BrutalNetwork.Balkan.Data.DataHandler;
import me.BrutalNetwork.Balkan.Data.Boosters.Booster;
import me.BrutalNetwork.Balkan.Data.Boosters.MoneyBooster;
import me.BrutalNetwork.Balkan.Listeners.InventoryClick;
import me.BrutalNetwork.Balkan.Listeners.InventoryClose;
import me.BrutalNetwork.Balkan.Listeners.PlayerDeath;
import me.BrutalNetwork.Balkan.Listeners.onJoin;
import me.BrutalNetwork.Balkan.Listeners.onLeave;
import net.milkbowl.vault.economy.Economy;

public class Main extends JavaPlugin{

	public DataHandler DataHandler;
	public static Booster Booster;
	public MoneyBooster MoneyBooster;
	public Messages messages;
	public GUI gui;
	public Economy economy = null;
	
	@Override
	public void onEnable(){
		setupEconomy();
		Bukkit.getPluginManager().registerEvents(new onJoin(this), this);
		Bukkit.getPluginManager().registerEvents(new onLeave(this), this);
		Bukkit.getPluginManager().registerEvents(new InventoryClose(), this);
		Bukkit.getPluginManager().registerEvents(new InventoryClick(this), this);
		getCommand("booster").setExecutor(new BoosterCMD(this));
		getCommand("boosteradmin").setExecutor(new AdminCMD(this));
		getCommand("tip").setExecutor(new TipCMD(this));
		Config c = new Config(this);
		if (c.getMessages().getBoolean("KitPvP.isKitPvP") == true){
			Bukkit.getPluginManager().registerEvents(new PlayerDeath(this), this);
		}
		gui = new GUI();
		messages = new Messages();
		DataHandler = new DataHandler(this);
		Booster = new Booster(this);
		MoneyBooster = new MoneyBooster(this);
		c.makeGUI();
		c.makeData();
		c.makeMessages();
		c.loadGUI();
		c.loadMessage();
		for (Player p : Bukkit.getOnlinePlayers()){
			DataHandler.loadData(p);
		}
	}
	
	public void onDisable(){
		Bukkit.getScheduler().cancelTasks(this);
		try{
			DataHandler.saveData();
		}catch(Exception e){
        	getLogger().info(ChatColor.RED + "0 Players where in the server.... Just disabling...");
		}
	}
	
    private boolean setupEconomy()
    {
        RegisteredServiceProvider<Economy> economyProvider = getServer()
        		.getServicesManager().getRegistration(net.milkbowl.vault.economy.Economy.class);
        if (economyProvider != null) {
            economy = economyProvider.getProvider();
        }

        return (economy != null);
    }
}