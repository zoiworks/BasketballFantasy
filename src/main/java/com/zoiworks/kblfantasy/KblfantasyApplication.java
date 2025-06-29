package com.zoiworks.kblfantasy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.github.cdimascio.dotenv.Dotenv;

@SpringBootApplication
public class KblfantasyApplication {

	public static void main(String[] args) {
		// Φόρτωσε το .env αρχείο
		Dotenv dotenv = Dotenv.configure()
				.directory("env/") // δείχνει στον φάκελο env στη ρίζα
				.ignoreIfMissing()
				.load();

		System.out.println("🚀 DB_URL from .env: " + dotenv.get("DB_URL"));
		// Βάλε τις μεταβλητές στο System properties
		System.setProperty("DB_URL", dotenv.get("DB_URL"));
		System.setProperty("DB_USER", dotenv.get("DB_USER"));
		System.setProperty("DB_PASS", dotenv.get("DB_PASS"));

		SpringApplication.run(KblfantasyApplication.class, args);
	}
}
