package com.mori.aegis;


import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.sharding.DefaultShardManagerBuilder;
import net.dv8tion.jda.api.sharding.ShardManager;

import javax.security.auth.login.LoginException;

public class AegisBot {

    private final ShardManager shardManager;
    private final Dotenv config;

    public AegisBot() throws LoginException {
        config = Dotenv.configure().load();
        final String token = config.get("AUTH_TOKEN");
        DefaultShardManagerBuilder builder = DefaultShardManagerBuilder.createDefault(token);
        builder.setStatus(OnlineStatus.ONLINE);
        builder.setActivity(Activity.watching("devstream 0212"));
        shardManager = builder.build();
    }

    // custom activity generator

    public ShardManager getShardManager() {
        return shardManager;
    }

    public Dotenv getConfig() {
        return config;
    }

    public static void main(String[] args) {
        try {
            AegisBot aegis = new AegisBot();

        } catch (LoginException e) {
            System.out.println("Error: Provided bot token is invalid!" + e.getMessage());
            e.printStackTrace();
        }
    }

}
