package me.BrutalNetwork.Balkan.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.BrutalNetwork.Balkan.Data.Boosters.Booster;
import me.BrutalNetwork.Balkan.Data.Boosters.MoneyBooster;
import me.BrutalNetwork.Balkan.Utils.Main;

public class TipCMD implements CommandExecutor{

	private Main m;
	public TipCMD(Main m){
		this.m = m;
	}
	
	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String cmdLabel, String[] args) {
		if (cmd.getName().equalsIgnoreCase("tip")){
			if (cs instanceof Player){
				Player p = (Player)cs;
				Booster b = Main.Booster;
				MoneyBooster mb = m.MoneyBooster;
				if (!b.isEnabled() && !mb.isEnabled()){
					p.sendMessage(m.messages.TipNoBoosters);
					return true;
				}
				else if (b.isEnabled() && b.getTips().contains(p) && !mb.isEnabled()){
					p.sendMessage(m.messages.TipAlreadyTipped);
					return true;
				}else if (mb.isEnabled() && mb.getTips().contains(p) && !b.isEnabled()){
					p.sendMessage(m.messages.TipAlreadyTipped);
					return true;
				}
				else if (b.getTips().contains(p) && mb.getTips().contains(p)){
					p.sendMessage(m.messages.TipAlreadyTipped);
					return true;
				}else{
					Boolean tipself = false;
					if (!b.getTips().contains(p)){
						if (b.isEnabled()){
							Player t = b.getPlayer();
							if (t == p){ tipself = true;}
							else{
								m.economy.depositPlayer(t, m.messages.TipMoney);
								p.sendMessage(m.messages.TipMessage.replace("{PLAYER}", t.getName()));
								t.sendMessage(m.messages.TipTargetMessage.replace("{PLAYER}", p.getName())
										.replace("{MONEY}", "" + m.messages.TipMoney));	
								b.addtoTips(p);
							}
						}
					}
					if (!mb.getTips().contains(p)){
						if (mb.isEnabled()){
							Player t = mb.getPlayer();
							if (t == p){ 
								tipself = true;
							}
							else{
								m.economy.depositPlayer(t, m.messages.TipMoney);
								p.sendMessage(m.messages.TipMessage.replace("{PLAYER}", t.getName()));
								t.sendMessage(m.messages.TipTargetMessage.replace("{PLAYER}", p.getName())
										.replace("{MONEY}", "" + m.messages.TipMoney));	
								mb.addtoTips(p);
							}
						}
					}
					if (tipself == true){
						p.sendMessage(m.messages.TipYouself);
					}
					return true;
				}
			}
		}
		return false;
	}

	

}
