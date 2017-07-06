package me.BrutalNetwork.Balkan.Utils;

import java.util.ArrayList;
import java.util.List;

public class Messages {

	public Messages(){ }
	
	public String nopermission = "§cYou don't have the right permissions to do this!";
	public String nobooster = "§3Booster» §6You don't have any boosters right now!";
	public String activebooster = "§3Booster» §6There is already a booster active!";
	public String boosteractivated = "§3Booster» §6The booster is activated! You have right now §e{BOOSTER} §6booster(s)!";
	public String error = "§3Booster» §cThere is an error, Please contact the developer/server owner to fix this!";
	public String boosteradded = "§3Booster» §e{AMOUNT}§6 boosters are added to §e{TARGET}§6 account!";
	public String adminboosteradded = "§3» §a{AMOUNT} §7boosters are added to §a{TARGET}'s §7account!";
	public String boosterremove = "§3Booster» §e{AMOUNT}§6 boosters are removed from §e{TARGET}§6 account!";
	public String adminboosterremove = "§3» §a{AMOUNT} §7boosters are removed from §a{TARGET}'s §7account!";
	public String boostersetted = "§3» §7You're boosters are setted to {AMOUNT}";
	public String adminboostersetted = "§3» §7You set the §a{AMOUNT} §7boosters for §a{TARGET}§7 account!";
	public String moneyboosteradded = "§3moneybooster» §e{AMOUNT}§6 moneyboosters are added to §e{TARGET}§6 account!";
	public String adminmoneyboosteradded = "§3» §a{AMOUNT} §7moneyboosters are added to §a{TARGET}'s §7account!";
	public String moneyboosterremove = "§3moneybooster» §e{AMOUNT}§6 moneyboosters are removed from §e{TARGET}§6 account!";
	public String adminmoneyboosterremove = "§3» §a{AMOUNT} §7moneyboosters are removed from §a{TARGET}'s §7account!";
	public String moneyboostersetted = "§3» §7You're moneyboosters are setted to {AMOUNT}";
	public String adminmoneyboostersetted = "§3» §7You set the §a{AMOUNT} §7moneyboosters for §a{TARGET}§7 account!";
	public String numberformat = "§c{ARG} needs to be a number!";
	public String formatexception = "§cUsage: /BoosterAdmin (Booster/MoneyBooster) (Player) (Amount)";
	public String playernotonline = "§c{ARG} isn't online...";
	
	public String TipYouself = "§3» §cYou can't tip yourself!";
	public String TipMessage = "§3» §7You tipped §a{PLAYER}§7!";
	public String TipTargetMessage = "§3» §7You got a tip from §a{PLAYER}§7! You received §a{MONEY}§7!";
	public String TipAlreadyTipped = "§3» §cYou have already tipped these boosters!";
	public String TipNoBoosters = "§3» §cThere aren't any boosters running!";
	public Double TipMoney = 10000.0;
			
	public Double moneyEarned = 1.0;
	public Double multiply = 3.5;
	public Boolean KillMessageEnabled = true;
	public String KitPvPMessage = "§3» §7You killed §a{TARGET}§7 and received §a${MONEY}";
	
	public List<String> message = new ArrayList<String>();
	public List<String> endmessage = new ArrayList<>();
	public List<String> moneymessage = new ArrayList<String>();
	public List<String> moneybroadcastmessage = new ArrayList<>();
	public List<String> endmoneybroadcastmessage = new ArrayList<>();

	public List<String> boosterlore = new ArrayList<>();
	public List<String> activeboosterlore = new ArrayList<>();
	public List<String> moneylore = new ArrayList<>();
	public List<String> activemoneylore = new ArrayList<>();

	public Integer boostertime = 600;
	
	public Integer times = 5;
	public Double money = 15000.0;
	public Integer time = 300;
	
}
