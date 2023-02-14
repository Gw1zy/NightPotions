package nightpotions.nightpotions;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class Plugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        this.getLogger().info(ChatColor.GREEN + "Запускаю HomingArrow");
        Bukkit.getPluginManager().registerEvents(new TntPotion(), this);
        ItemManager.inti();
        getCommand("nightpotion").setExecutor(new TntPotionCMD());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        this.getLogger().info(ChatColor.RED + "Выключаю HomingArrow");
    }
}
