package com.lorenzo.simplyvanish.events;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.type.Chest;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;

public class ContainerInteraction implements Listener {

    @EventHandler
    public void onPlayerInteractsWithContainer(PlayerInteractEvent e) {
//TODO: silent opening
        Block clickedBlock = e.getClickedBlock();
        Action action = e.getAction();
        if(action == action.RIGHT_CLICK_BLOCK && e.getClickedBlock() == ) {}
    }
}
