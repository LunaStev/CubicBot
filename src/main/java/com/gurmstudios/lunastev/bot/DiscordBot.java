package com.gurmstudios.lunastev.bot;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;

import javax.security.auth.login.LoginException;

public class DiscordBot {
    public JDA jda;

    public void startBot(String token) throws LoginException {
        jda = JDABuilder.createDefault(token).build();
    }

    public void updateBotStatus(String serverInfo) {
        jda.getPresence().setActivity(Activity.playing(serverInfo));
    }
}
