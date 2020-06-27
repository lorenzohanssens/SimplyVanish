package com.lorenzo.simplyvanish.events;

import com.lorenzo.simplyvanish.commands.Vanish;
import com.lorenzo.simplyvanish.functions.checkPerms;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;

import static com.lorenzo.simplyvanish.commands.Vanish.vanished;

public class FoodAndHealthLossCancelEvent implements Listener {

    @EventHandler
    public void onFoodLoss(FoodLevelChangeEvent e) {
        Player checkVanishedPlayers = (Player) e.getEntity();
        if(vanished.contains(checkVanishedPlayers.getUniqueId().toString()) && checkPerms.hasPerm(checkVanishedPlayers, "SimplyVanish.bypassfood")) {
            e.setFoodLevel(20);
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onHealthLoss(EntityDamageEvent e) {
        Entity entityGotHurt = e.getEntity();
        if(entityGotHurt instanceof Player) {
            if(vanished.contains(entityGotHurt.getUniqueId().toString()) && checkPerms.hasPerm((Player) entityGotHurt, "SimplyVanish.bypasshealth")) {
                e.setCancelled(true);

            }

        }
    }

}
