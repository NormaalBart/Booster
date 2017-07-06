package me.BrutalNetwork.Balkan.Data.Boosters;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import me.BrutalNetwork.Balkan.Utils.Main;

public class MoneyBooster {
	
	private Main m;
	public MoneyBooster(Main m){
		this.m = m;
	}

	private ArrayList<Player> tips = new ArrayList<>();
	private Boolean isEnabled = false;
	private Integer timeleft = 300;
	private Integer times = 5;
	private Player player;
	private Long timestarted;
	private Double money = 15000.0;
	private Integer taskid;
	
	public void setBooster(Integer timeinseconds, Integer times, Double money, Player p){
		if (isEnabled == true) return;
		this.times = times;
		timeleft = timeinseconds;
		this.money  = money;
		this.player = p;
	}
	
	public void startBooster(){
		isEnabled = true;
		timestarted = System.currentTimeMillis();
		startTimer();
	}
	
	public ArrayList<Player> getTips(){
		return tips;
	}
	
	public void addtoTips(Player p){
		tips.add(p);
	}
	
	private void startTimer() {
		taskid = Bukkit.getScheduler().scheduleSyncRepeatingTask(m, new Runnable(){
			public void run(){
				if (times == m.messages.times){
					for (Player p : Bukkit.getOnlinePlayers()){
						for (String s : m.messages.moneymessage){
							p.sendMessage(s.replace("{PLAYER}", player.getName()));
						}
					}
				}
				for (Player p : Bukkit.getOnlinePlayers()){
					m.economy.depositPlayer(p, money);
					for (String s : m.messages.moneybroadcastmessage){
						p.sendMessage(s.replace("{MONEY}", "" + money)
								.replace("{PLAYER}", player.getName())
								.replace("{TIMES}",  "" + (times-1)));
					}
				}
				times--;
				if (times == 0){
					for (Player p : Bukkit.getOnlinePlayers()){
						for (String s : m.messages.endmoneybroadcastmessage){
							p.sendMessage(s.replace("{PLAYER}", player.getName()));
						}
					}
					disableBooster();
				}
			}
		}, 0, timeleft*20);
	}

	public void disableBooster(){
		Bukkit.getScheduler().cancelTask(taskid);
		this.isEnabled = false;
	}

	public Boolean isEnabled(){
		return isEnabled;
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

}
