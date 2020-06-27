package com.github.therealbeaver.simplyvanish.events;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityTargetLivingEntityEvent;

import static com.github.therealbeaver.simplyvanish.commands.Vanish.vanished;

public class NoMobAttackEvent implements Listener{

    @EventHandler
    public void onMobAttack(EntityTargetLivingEntityEvent e) {

        Entity attackedEntity = e.getTarget();
        if (attackedEntity instanceof Player) {
            Player attackedPlayer = (Player) e.getTarget();
            if (vanished.contains(attackedPlayer.getUniqueId().toString())) {
                e.setCancelled(true);
                e.setTarget(null);
            }

        }

    }
}
