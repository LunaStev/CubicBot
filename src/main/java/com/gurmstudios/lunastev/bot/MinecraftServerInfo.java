package com.gurmstudios.lunastev.bot;

import org.bukkit.Bukkit;

public class MinecraftServerInfo {
    public static String getOnlinePlayersInfo() {
        int onlinePlayers = Bukkit.getOnlinePlayers().size();
        int maxPlayers = Bukkit.getMaxPlayers();
        return onlinePlayers + "/" + maxPlayers;
    }
}
