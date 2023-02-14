package nightpotions.nightpotions;

import org.bukkit.Color;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;

public class ItemManager {
    public static ItemStack tntPotion;

    public static void inti(){
        createTntPotion();

    }

    private static void createTntPotion() {
        ItemStack potion = new ItemStack(Material.SPLASH_POTION, 1);
        PotionMeta meta = (PotionMeta) potion.getItemMeta();
        meta.setDisplayName("§c§lВзрывное зелье");
        meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        meta.setColor(Color.RED);
        meta.addCustomEffect(new PotionEffect(PotionEffectType.GLOWING, 0, 2), true);
        potion.setItemMeta(meta);
        tntPotion = potion;
    }

}
