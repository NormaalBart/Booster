package me.BrutalNetwork.Balkan.Data.Boosters;

import org.bukkit.entity.Player;

public class Data {
	
	private Integer booster = 0;
	private Integer moneybooster = 0;
	private Player p = null;
	
	public Data(Player p){
		this.p = p;
	}
	
	public Integer getBooster(){
		return booster;
	}
	
	public Integer getMoneyBooster(){
		return moneybooster;
	}
	
	public void setBooster(Integer i){
		booster = i;
	}
	
	public void setMoneyBooster(Integer i){
		moneybooster = i;
	}
	
	public Player getPlayer(){
		return p;
	}

}
