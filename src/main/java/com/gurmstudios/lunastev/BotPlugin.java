package com.gurmstudios.lunastev;

import com.gurmstudios.lunastev.bot.DiscordBot;
import com.gurmstudios.lunastev.bot.MinecraftServerInfo;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import javax.security.auth.login.LoginException;

public class BotPlugin extends JavaPlugin {
    private DiscordBot discordBot;

    @Override
    public void onEnable() {
        discordBot = new DiscordBot();
        try {
            discordBot.startBot("Please enter Token");
        } catch (LoginException e) {
            e.printStackTrace();
        }
        new BukkitRunnable() {
            @Override
            public void run() {
                String serverInfo = MinecraftServerInfo.getOnlinePlayersInfo();
                discordBot.updateBotStatus(serverInfo);
            }
        }.runTaskTimer(this, 0L, 20L * 1);
    }

    @Override
    public void onDisable() {
        if (discordBot != null) {
            discordBot.jda.shutdown();
        }
    }
}
