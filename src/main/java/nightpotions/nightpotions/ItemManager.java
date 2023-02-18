package nightpotions.nightpotions;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class ItemManager {
    public static ItemStack tntPotion;
    public static ItemStack randomPotion;
    public static ItemStack wickPotion;
    public static ItemStack backPotion;
    public static void inti(){
        createTntPotion();
        createRandomPotion();
        createWickPotion();
        createBackPotion();
    }
    private static void createBackPotion() {
        ItemStack potion = new ItemStack(Material.SPLASH_POTION, 1);
        PotionMeta meta = (PotionMeta) potion.getItemMeta();
        meta.setDisplayName("§9§lОткат");
        meta.setLore(java.util.Arrays.asList("§7При попадании зелье телепортирует противника на место использования зелья через §62 §7минуты."));
        meta.setColor(Color.YELLOW);
        meta.addCustomEffect(new PotionEffect(PotionEffectType.GLOWING, 0, 5), true);
        meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        potion.setItemMeta(meta);
        backPotion = potion;
    }
    private static void createWickPotion() {
        ItemStack potion = new ItemStack(Material.SPLASH_POTION, 1);
        PotionMeta meta = (PotionMeta) potion.getItemMeta();
        meta.setDisplayName("§4§lФитиль");
        meta.setLore(java.util.Arrays.asList("§7При попадании зелье взрывает противника через §62 §7минуты."));
        meta.setColor(Color.ORANGE);
        meta.addCustomEffect(new PotionEffect(PotionEffectType.GLOWING, 0, 4), true);
        meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        potion.setItemMeta(meta);
        wickPotion = potion;
    }

    private static void createRandomPotion() {
        ItemStack potion = new ItemStack(Material.SPLASH_POTION, 1);
        PotionMeta meta = (PotionMeta) potion.getItemMeta();
        meta.setDisplayName("§2§lМагическое зелье");
        meta.setLore(java.util.Arrays.asList("§7Накладывает случайный эффект." , "§6Действует моментально!"));
        meta.setColor(Color.GREEN);
        meta.addCustomEffect(new PotionEffect(PotionEffectType.GLOWING, 0, 3), true);
        meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        potion.setItemMeta(meta);
        randomPotion = potion;
    }


    private static void createTntPotion() {
        ItemStack potion = new ItemStack(Material.SPLASH_POTION, 1);
        PotionMeta meta = (PotionMeta) potion.getItemMeta();
        meta.setDisplayName("§c§lВзрывное зелье");
        meta.setLore(java.util.Arrays.asList("§7При попадании зелье взрывается нанося большой урон." , "§6Действует моментально!"));
        meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        meta.setColor(Color.RED);
        meta.addCustomEffect(new PotionEffect(PotionEffectType.GLOWING, 0, 2), true);
        potion.setItemMeta(meta);
        tntPotion = potion;
    }

}
