package me.BrutalNetwork.Balkan.Data;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import me.BrutalNetwork.Balkan.Utils.Config;
import me.BrutalNetwork.Balkan.Utils.Main;

public class DataHandler {
	
	private Main m;

	public DataHandler(Main m){
		this.m = m;
	}
	
	private HashMap<Player, Data> data = new HashMap<>();
	
	public void loadData(Player p){
		Config c = new Config(m);
		FileConfiguration data = c.getData();
		Data d = new Data(p);
		if (data.getString("Data." + p.getUniqueId().toString() + ".Booster") == null){
			d.setBooster(0);
		}else{
			d.setBooster(data.getInt("Data." + p.getUniqueId().toString() + ".Booster"));
		}
		if (data.getString("Data." + p.getUniqueId().toString() + ".MoneyBooster") == null){
			d.setMoneyBooster(0);
		}else{
			d.setMoneyBooster(data.getInt("Data." + p.getUniqueId().toString() + ".MoneyBooster"));
		}
		this.data.put(p, d);
	}
	
	public Integer getBooster(Player p){
		if (data.get(p) == null){
			loadData(p);
			return data.get(p).getBooster();
		}else{
			return data.get(p).getBooster();	
		}
	}
	
	public Integer getMoneyBooster(Player p){
		if (data.get(p) == null){
			loadData(p);
			return data.get(p).getMoneyBooster();
		}else{
			return data.get(p).getMoneyBooster();	
		}
	}
	
	public Data getData(Player p){
		if (this.data.containsKey(p)){
			return this.data.get(p);
		}else{
			loadData(p);
			return this.data.get(p);
		}
	}
	
	public void saveData(Player p){
		Config c = new Config(m);
		FileConfiguration d = c.getData();
		Integer booster = this.data.get(p).getBooster();
		Integer moneybooster = this.data.get(p).getMoneyBooster();
		if (booster == null || booster == 0 && moneybooster == 0 || moneybooster == null){
			return;
		}else{
			d.set("Data." + p.getUniqueId().toString() + ".Player", p.getName());
			d.set("Data." + p.getUniqueId().toString() + ".Booster", booster);
			d.set("Data." + p.getUniqueId().toString() + ".MoneyBooster", moneybooster);
	        File f = new File(m.getDataFolder(), "data.yml");
			try {
				d.save(f);
			} catch (IOException e) {
				m.getLogger().info("§cCouldn't save data for player " + p.getName() + "!");
			}	
		}
	}
	
	public void saveData(){
		if (data.isEmpty()) return;
		if (data.size() == 0) return;
		Config c = new Config(m);
		FileConfiguration d = c.getData();
		for (Player p : data.keySet()){
			Integer booster = this.data.get(p).getBooster();
			Integer moneybooster = this.data.get(p).getMoneyBooster();
			if (booster == null && moneybooster == null){
				return;
			}
			d.set("Data." + p.getUniqueId().toString() + ".Player", p.getName());
			d.set("Data." + p.getUniqueId().toString() + ".Booster", booster);
			d.set("Data." + p.getUniqueId().toString() + ".MoneyBooster", moneybooster);
			c.saveData(d);
		}
	}
}
