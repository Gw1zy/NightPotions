package nightpotions.nightpotions;

import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.ThrownPotion;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PotionSplashEvent;

import java.util.List;
import java.util.Objects;
import java.util.Random;

import static java.lang.Thread.sleep;


public class WickPotion implements Listener {


    @EventHandler
    public boolean onPotionExplode(PotionSplashEvent event) {
        ThrownPotion potion = (ThrownPotion) event.getEntity();

        if (event.getEntity().getShooter() instanceof Player) {
            String name = String.valueOf(potion.getEffects());
            Player player = (Player) event.getEntity().getShooter();
            String realEffects = "[GLOWING:(0t-x4)]";
            Random rand = new Random();
            if (Objects.equals(name, realEffects)) {
                List<Entity> near = potion.getNearbyEntities(2.0D, 2.0D, 2.0D);
                for (Entity entity : near) {
                    if (entity instanceof Player) {
                        Player nearPlayer = (Player) entity;
                        new Thread(new Runnable() {
                            public void run() {
                                int i = 0;
                                int timer = 120;
                                while(i < 120) {
                                    try {
                                        sleep(1000);
                                        i++;
                                        timer -= 1;
                                    } catch (InterruptedException e) {
                                        throw new RuntimeException(e);
                                    }
                                    if ((timer%60) < 10) {
                                        nearPlayer.sendActionBar("§4§lФитиль§6 " + (timer / 60) + ":0" + (timer % 60));
                                        if ((timer%60) == 0){
                                                nearPlayer.sendActionBar("§4§lФитиль§6 " + (timer / 60) + ":00");
                                        }
                                    }
                                    else {
                                        nearPlayer.sendActionBar("§4§lФитиль§6 " + (timer / 60) + ":" + (timer % 60));
                                    }
                                }
                            }
                        }).start();
                        Bukkit.getScheduler().runTaskLater(Plugin.instance, () -> {
                            nearPlayer.getWorld().createExplosion(nearPlayer.getLocation(), 4F, false, false);
                        }, 60 * 20 * 2 + 20);
                    }
                        }
                    }
                }
        return true;
    }
}
