package nightpotions.nightpotions;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import static nightpotions.nightpotions.ItemManager.tntPotion;

public class TntPotionCMD implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (sender.hasPermission("nightpotion.give")) {
            if (args[0].equalsIgnoreCase("give"))   {
                Player target = Bukkit.getPlayerExact(args[1]);
                if(!(target == null)) {
                    if (args[2].equalsIgnoreCase("tnt")) {

                    target.getInventory().addItem(tntPotion);
                    return true;
                }
                    else {
                        return false;
                    }

                }
                else {
                    sender.sendMessage("Игрок Оффлайн");
                    return true;
                }

            }
                else {
                    return false;

        }
    }

        else {
            sender.sendMessage(ChatColor.RED + "Недостаточно прав");
            return true;
        }
    }


}
