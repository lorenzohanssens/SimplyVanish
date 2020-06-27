package com.github.therealbeaver.simplyvanish.functions;

import org.bukkit.entity.Player;

//check if person has perms to bypass food and health removal
public class checkPerms {



    public static boolean hasPerm(Player player, String permission) {

        if (player.hasPermission(permission)) {
            return true;
        }
        else {
            return false;
        }

    }


}
