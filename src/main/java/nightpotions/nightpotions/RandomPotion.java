package nightpotions.nightpotions;

import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PotionSplashEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.List;
import java.util.Objects;
import java.util.Random;

public class RandomPotion implements Listener {
    @EventHandler
    public boolean onPotionExplode(PotionSplashEvent event) {

        if (event.getEntity().getShooter() instanceof Player) {
            ThrownPotion potion = (ThrownPotion) event.getEntity();
            String name = String.valueOf(potion.getEffects());
            String realEffects = "[GLOWING:(0t-x3)]";
            Random rand = new Random();
            int randPotionId = rand.nextInt(32) + 1;
            int randDuration = rand.nextInt(300) + 60;
            int randAmplifier = rand.nextInt(3) + 1;

            if (Objects.equals(name, realEffects)) {
                List<Entity> near = potion.getNearbyEntities(2.0D, 2.0D, 2.0D);
                for (Entity entity : near) {
                    if (entity instanceof Player) {
                        Player nearPlayer = (Player) entity;
                        nearPlayer.addPotionEffect(new PotionEffect(PotionEffectType.getById(randPotionId), randDuration, randAmplifier), true);
                    }
                }
            }
        }
        return true;
    }
}