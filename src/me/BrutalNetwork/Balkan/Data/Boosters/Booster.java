package me.BrutalNetwork.Balkan.Data.Boosters;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import me.BrutalNetwork.Balkan.Utils.Main;

public class Booster {
	
	Main m;
	public Booster(Main m){
		this.m = m;
	}

	private ArrayList<Player> tips = new ArrayList<>();
	private Boolean isEnabled = false;
	private Integer timeleft = 600;
	private Player player;
	private Integer taskid;
	private Long timestarted;
	
	public void setBooster(Integer timeinseconds, Player p){
		if (isEnabled == true) return;
		timeleft = timeinseconds;
		this.player = p;
	}
	
	public void startBooster(){
		isEnabled = true;
		timestarted = System.currentTimeMillis();
		for (Player p : Bukkit.getOnlinePlayers()){
			for (String s : m.messages.message){
				String x = s.replace("{PLAYER}", player.getName());
				p.sendMessage(x);
				
			}
		}
		startTimer();
	}
	
	public void disableBooster(){
		this.isEnabled = false;
		for (Player p : Bukkit.getOnlinePlayers()){
			for (String s : m.messages.endmessage){
				p.sendMessage(s.replace("{PLAYER}", player.getName()));
			}
		}
		Bukkit.getScheduler().cancelTask(taskid);
		tips.clear();
		timeleft = 600;
		player = null;
		taskid = 0;
		timestarted = new Long(0);
	}
	
	public ArrayList<Player> getTips(){
		return tips;
	}
	
	public void addtoTips(Player p){
		tips.add(p);
	}

	public Boolean isEnabled(){
		return isEnabled;
	}
	
	public Integer TimeLeftinSeconds(){
		return timeleft;
	}
	
	public void setTime(Integer time){
		timeleft = time;
	}
	
	public Player getPlayer(){
		return player;
	}
	
	public String getFormattedTime(){
		Integer ctm = (int) (System.currentTimeMillis()/1000);
		Integer ts = (int) (timestarted/1000);
		Integer time = ctm-ts;
		int x = (timeleft-time);
		int m = (x / 60);
		int s = (x % 60);
		String disMinu = (m < 10 ? "0" : "") + m; 
		String disSec = (s < 10 ? "0" : "") + s;
		String formattedTime = disMinu + ":" + disSec;
		return formattedTime;
	}
	
	private void startTimer(){
		taskid = Bukkit.getScheduler().scheduleSyncDelayedTask(m, new Runnable(){
			public void run(){
				if (isEnabled){
					for (Player p : Bukkit.getOnlinePlayers()){
						for (String s : m.messages.endmessage){
							p.sendMessage(s.replace("{PLAYER}", p.getName()));
						}
					}
					isEnabled = false;
					Bukkit.getScheduler().cancelTask(taskid);
					return;
				}
			}
		}, timeleft*20);
	}
}
