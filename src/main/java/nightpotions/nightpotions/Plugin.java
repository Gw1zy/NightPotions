package nightpotions.nightpotions;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class Plugin extends JavaPlugin {
    public static org.bukkit.plugin.Plugin instance;

    @Override
    public void onEnable() {
        // Plugin startup logic
        this.getLogger().info(ChatColor.GREEN + "Запускаю NightPotions");
        instance = this;
        Bukkit.getPluginManager().registerEvents(new TntPotion(), this);
        Bukkit.getPluginManager().registerEvents(new RandomPotion(), this);
        Bukkit.getPluginManager().registerEvents(new WickPotion(), this);
        Bukkit.getPluginManager().registerEvents(new BackPotion(), this);
        ItemManager.inti();
        getCommand("nightpotion").setExecutor(new PotionGiveCMD());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        this.getLogger().info(ChatColor.RED + "Выключаю NightPotions");
    }
}
