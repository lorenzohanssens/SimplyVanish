package com.github.therealbeaver.simplyvanish.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.UUID;

import static java.util.UUID.fromString;

public class Vanish implements CommandExecutor {
    //use UUIDs not GETNAMES.
    //TODO: onPlayerJoin event or something
    public static ArrayList<String> vanished = new ArrayList<>();
    public static ArrayList<String> peopleHiddenFrom = new ArrayList<>();
    public static ArrayList<String> peopleWhoSeeVanished = new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {


        if (cmd.getName().equalsIgnoreCase("vanish")) {
            if (!(sender instanceof Player)) {
                Bukkit.getServer().getLogger().info(ChatColor.RED + "Only players can execute this command.");
                System.out.println(vanished.toString());
                return true;

            }
            else {

                if (sender.hasPermission("SimplyVanish.vanish")) {

                    if (vanished.contains(((Player) sender).getUniqueId().toString())) {

                        vanished.remove(((Player) sender).getUniqueId().toString());

                        //for every person the player is hidden from
                        for (String playersHiddenFrom : peopleHiddenFrom) {

                            //GET UUIDS from all the players in the arraylist and show the player again.
                            //TODO: MAKE THIS A FUNCTION!!
                            UUID players = fromString(playersHiddenFrom);
                            //check if players != null

                            if (Bukkit.getPlayer(players) == null) {

                                //do nothing
                            }
                            else {
                                Bukkit.getPlayer(players).showPlayer((Player) sender);
                                //removes them from the arrayList
                                peopleHiddenFrom.remove(players);
                            }
                        }
                        sender.sendMessage(ChatColor.YELLOW + "The world can once again see your beauty!");

                    }
                    //Player otherPlayers;
                    else if (!(vanished.contains(((Player) sender).getUniqueId()))) {
                        for (Player otherPlayers : Bukkit.getOnlinePlayers()) {
                            if (otherPlayers.hasPermission("SimplyVanish.seevanished")) {
                                peopleWhoSeeVanished.add(otherPlayers.getUniqueId().toString());

                            } else {
                                otherPlayers.hidePlayer((Player) sender);
                                //DEBUGGING PURPOSES otherPlayers.sendMessage(otherPlayers.getName() + " you notice someone just disappeared.");
                                peopleHiddenFrom.add(otherPlayers.getUniqueId().toString());
                            }

                        }
                        vanished.add(((Player) sender).getUniqueId().toString());
                        sender.sendMessage(ChatColor.YELLOW + "You are now hidden from everyone else.");
                        return true;
                    }

                }


            }
        }
        return true;
    }

}

