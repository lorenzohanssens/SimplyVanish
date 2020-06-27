package com.github.therealbeaver.simplyvanish.events;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.UUID;

import static com.github.therealbeaver.simplyvanish.commands.Vanish.peopleHiddenFrom;
import static com.github.therealbeaver.simplyvanish.commands.Vanish.vanished;
import static java.util.UUID.fromString;

public class JoinLeaveEvent implements Listener {
@EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {

        Player playerWhoJoined = event.getPlayer();

        if(!(vanished.isEmpty())) {
            for (String vanishedPlayersGetUUID : vanished) {

                UUID vanishedPlayersUUID = fromString(vanishedPlayersGetUUID);
                Player vanishedPlayers = Bukkit.getPlayer(vanishedPlayersUUID);
                playerWhoJoined.hidePlayer(vanishedPlayers);


            }
        }


    }

    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent event) {

        Player playerWhoLeft = event.getPlayer();

        if(!(vanished.isEmpty())) {
            for (String vanishedPlayersGetUUID : vanished) {

                UUID vanishedPlayersUUID = fromString(vanishedPlayersGetUUID);
                Player vanishedPlayers = Bukkit.getPlayer(vanishedPlayersUUID);
                playerWhoLeft.showPlayer(vanishedPlayers);
                peopleHiddenFrom.remove(playerWhoLeft.getUniqueId());


            }

        }


    }

}
