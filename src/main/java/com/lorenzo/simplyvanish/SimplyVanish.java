package com.lorenzo.simplyvanish;


import com.lorenzo.simplyvanish.commands.Vanish;
import com.lorenzo.simplyvanish.events.*;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class SimplyVanish extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getServer().getLogger().info("SimplyVanish has started.");
        Bukkit.getPluginCommand("vanish").setExecutor(new Vanish());
        Bukkit.getPluginManager().registerEvents(new JoinLeaveEvent(), this);
        Bukkit.getPluginManager().registerEvents(new NoMobAttackEvent(), this);
        Bukkit.getPluginManager().registerEvents(new FoodAndHealthLossCancelEvent(), this);
        Bukkit.getPluginManager().registerEvents(new itemPickup(), this);
        Bukkit.getPluginManager().registerEvents(new ContainerInteraction(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Bukkit.getServer().getLogger().info("SimplyVanish has stopped.");
    }


}
