package com.lorenzo.simplyvanish.events;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPickupItemEvent;

import static com.lorenzo.simplyvanish.commands.Vanish.vanished;

public class itemPickup implements Listener {
    @EventHandler
    public void playerItemPickup(EntityPickupItemEvent e) {
        Entity entityThatPicksUpItem = e.getEntity();
        if(entityThatPicksUpItem instanceof Player) {
            if(vanished.contains(entityThatPicksUpItem.getUniqueId().toString())) {
                e.setCancelled(true);
            }
        }

    }
}
