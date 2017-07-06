package me.BrutalNetwork.Balkan.Commands;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;

import me.BrutalNetwork.Balkan.Utils.Main;

public class AdminCMD implements CommandExecutor, TabExecutor{

	private Main m;
	public AdminCMD(Main m){
		this.m = m;
	}
	
	@Override
	public boolean onCommand(CommandSender p, Command cmd, String cmdLabel, String[] args) {
		
		if (cmd.getName().equalsIgnoreCase("boosteradmin")){
			if (p.hasPermission("Booster.admin")){
				if (args.length != 4){
					p.sendMessage(m.messages.formatexception); 
					return true;
				}else{
					if (args[0].equalsIgnoreCase("Booster")){
						if (args[1].equalsIgnoreCase("add")){
							Player t = Bukkit.getPlayer(args[2]);
							if (t == null){
								p.sendMessage(m.messages.playernotonline.replace("{ARG}", args[2]));
								return true;
							}
							try{
								Integer.parseInt(args[3]);
							}catch(NumberFormatException nfe){
								p.sendMessage(m.messages.numberformat.replace("{ARG}", args[3]));
								return true;
							}
							Integer amount = Integer.parseInt(args[3]);
							m.DataHandler.getData(t).setBooster(m.DataHandler.getData(t).getBooster() + amount);
							p.sendMessage(m.messages.adminboosteradded
									.replace("{AMOUNT}", "" + amount)
									.replace("{TARGET}", t.getName()));
							t.sendMessage(m.messages.boosteradded
									.replace("{AMOUNT}", "" + amount));
							return true;
						}else if (args[1].equalsIgnoreCase("rem") || args[1].equalsIgnoreCase("remove")){
							Player t = Bukkit.getPlayer(args[2]);
							if (t == null){
								p.sendMessage(m.messages.playernotonline.replace("{ARG}", args[2]));
								return true;
							}
							try{
								Integer.parseInt(args[3]);
							}catch(NumberFormatException nfe){
								p.sendMessage(m.messages.numberformat.replace("{ARG}", args[3]));
								return true;
							}
							Integer amount = Integer.parseInt(args[3]);
							if (m.DataHandler.getData(t).getBooster() - amount < 0){
								m.DataHandler.getData(t).setBooster(0);
								p.sendMessage(m.messages.adminboosterremove
										.replace("{AMOUNT}", "" + amount)
										.replace("{TARGET}", t.getName()));
								t.sendMessage(m.messages.boosterremove
										.replace("{AMOUNT}", "" + amount));
								return true;
							}else{
								m.DataHandler.getData(t).setBooster(amount);
								p.sendMessage(m.messages.adminboosterremove
										.replace("{AMOUNT}", "" + amount)
										.replace("{TARGET}", t.getName()));
								t.sendMessage(m.messages.boosterremove
										.replace("{AMOUNT}", "" + amount));
								return true;	
							}
						}else if (args[1].equalsIgnoreCase("set")){
							Player t = Bukkit.getPlayer(args[2]);
							if (t == null){
								p.sendMessage(m.messages.playernotonline.replace("{ARG}", args[2]));
								return true;
							}
							try{
								Integer.parseInt(args[3]);
							}catch(NumberFormatException nfe){
								p.sendMessage(m.messages.numberformat.replace("{ARG}", args[3]));
								return true;
							}
							Integer amount = Integer.parseInt(args[3]);
							if (amount < 0){
								amount = 0;
							}
							m.DataHandler.getData(t).setBooster(amount);
							p.sendMessage(m.messages.adminboostersetted
									.replace("{AMOUNT}", "" + amount)
									.replace("{TARGET}", t.getName()));
							t.sendMessage(m.messages.boostersetted
									.replace("{AMOUNT}", "" + amount));
							return true;	
						}else{
							p.sendMessage(m.messages.formatexception);
							return true;
						}
					}
					else if (args[0].equalsIgnoreCase("MoneyBooster")){
						if (args[1].equalsIgnoreCase("add")){
							Player t = Bukkit.getPlayer(args[2]);
							if (t == null){
								p.sendMessage(m.messages.playernotonline.replace("{ARG}", args[2]));
								return true;
							}
							try{
								Integer.parseInt(args[3]);
							}catch(NumberFormatException nfe){
								p.sendMessage(m.messages.numberformat.replace("{ARG}", args[3]));
								return true;
							}
							Integer amount = Integer.parseInt(args[3]);
							m.DataHandler.getData(t).setMoneyBooster(m.DataHandler.getData(t).getMoneyBooster() + amount);
							p.sendMessage(m.messages.adminmoneyboosteradded
									.replace("{AMOUNT}", "" + amount)
									.replace("{TARGET}", t.getName()));
							t.sendMessage(m.messages.moneyboosteradded
									.replace("{AMOUNT}", "" + amount));
							return true;
						}else if (args[1].equalsIgnoreCase("rem") || args[1].equalsIgnoreCase("remove")){
							Player t = Bukkit.getPlayer(args[2]);
							if (t == null){
								p.sendMessage(m.messages.playernotonline.replace("{ARG}", args[2]));
								return true;
							}
							try{
								Integer.parseInt(args[3]);
							}catch(NumberFormatException nfe){
								p.sendMessage(m.messages.numberformat.replace("{ARG}", args[3]));
								return true;
							}
							Integer amount = Integer.parseInt(args[3]);
							if (m.DataHandler.getData(t).getMoneyBooster() - amount < 0){
								m.DataHandler.getData(t).setMoneyBooster(0);
								p.sendMessage(m.messages.adminmoneyboosterremove
										.replace("{AMOUNT}", "" + amount)
										.replace("{TARGET}", t.getName()));
								t.sendMessage(m.messages.moneyboosterremove
										.replace("{AMOUNT}", "" + amount));
								return true;
							}else{
								m.DataHandler.getData(t).setMoneyBooster(amount);
								p.sendMessage(m.messages.adminmoneyboosterremove
										.replace("{AMOUNT}", "" + amount)
										.replace("{TARGET}", t.getName()));
								t.sendMessage(m.messages.moneyboosterremove
										.replace("{AMOUNT}", "" + amount));
								return true;	
							}
						}else if (args[1].equalsIgnoreCase("set")){
							Player t = Bukkit.getPlayer(args[2]);
							if (t == null){
								p.sendMessage(m.messages.playernotonline.replace("{ARG}", args[2]));
								return true;
							}
							try{
								Integer.parseInt(args[3]);
							}catch(NumberFormatException nfe){
								p.sendMessage(m.messages.numberformat.replace("{ARG}", args[3]));
								return true;
							}
							Integer amount = Integer.parseInt(args[3]);
							if (amount < 0){
								amount = 0;
							}
							m.DataHandler.getData(t).setMoneyBooster(amount);
							p.sendMessage(m.messages.adminmoneyboostersetted
									.replace("{AMOUNT}", "" + amount)
									.replace("{TARGET}", t.getName()));
							t.sendMessage(m.messages.moneyboostersetted
									.replace("{AMOUNT}", "" + amount));
							return true;	
						}else{
							p.sendMessage(m.messages.formatexception);
							for(String i : args){
								p.sendMessage(i);
							}
							return true;
						}
					}
				}
			}else{
				p.sendMessage(m.messages.nopermission);
				return true;
			}
		}
		return false;
	}

	@Override
	public List<String> onTabComplete(CommandSender p, Command cmd, String cmdLabel, String[] args) {
		List<String> returns = new ArrayList<>();
		if (args.length == 1){
			String booster = "booster";
			String moneybooster = "moneybooster";
			String message = args[0].toLowerCase();
			if (message.startsWith(booster)){
				returns.add(booster);
			}else if (message.startsWith(moneybooster)){
				returns.add(moneybooster);
			}else{
				returns.add(booster);
				returns.add(moneybooster);	
			}
			return returns;
		}else if (args.length == 2){
			returns.add("add");
			returns.add("rem");
			returns.add("remove");
			returns.add("set");
			return returns;
		}else if (args.length == 3){
			String str = args[2].toLowerCase();
			for (Player all : Bukkit.getOnlinePlayers()){
				String name = all.getName().toLowerCase();
				if (name.startsWith(str)){
					returns.add(all.getName());
				}
				return returns;
			}
		}else if (args.length == 4){
			return returns;
		}else{
			return returns;
		}
		return null;
	}
	
	
}
