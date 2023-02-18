package nightpotions.nightpotions;

import org.bukkit.entity.Player;
import org.bukkit.entity.ThrownPotion;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PotionSplashEvent;

import java.util.Objects;

public class TntPotion implements Listener {
    @EventHandler
    public boolean onPotionExplode(PotionSplashEvent event) {

        if (event.getEntity().getShooter() instanceof Player) {
            ThrownPotion potion = (ThrownPotion) event.getEntity();
            String name = String.valueOf(potion.getEffects());
            String realEffects = "[GLOWING:(0t-x2)]";

            if (Objects.equals(name, realEffects)) {
                potion.getWorld().createExplosion(potion.getLocation().getX(), potion.getLocation().getY(), potion.getLocation().getZ(), 4F, false, false);
            }




            return true;
        }
        return true;
    }
}
