package com.zoiworks.basketballfantasy.util;

import io.github.cdimascio.dotenv.Dotenv;

public class EnvLoader {

    private static boolean loaded = false;

    public static void load() {
        if (loaded) return;

        Dotenv dotenv = Dotenv.configure()
                .directory("env/")
                .ignoreIfMissing()
                .load();

        System.setProperty("DB_URL", dotenv.get("DB_URL"));
        System.setProperty("DB_USER", dotenv.get("DB_USER"));
        System.setProperty("DB_PASS", dotenv.get("DB_PASS"));

        loaded = true;
    }
}
