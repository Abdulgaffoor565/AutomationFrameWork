package Utilities;

import java.util.Random;

public class EmailGeneration {
    public static String getRandomString(int length) {
        String characters = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < length; i++) {
            result.append(characters.charAt(random.nextInt(characters.length())));
        }
        return result.toString();
    }

    // Main method to generate a random email address
    public static String generateRandomEmail() {
        String[] domains = {"gmail.com", "yahoo.com", "outlook.com", "example.com"};
        Random random = new Random();

        // Generate a random username and pick a random domain
        String username = getRandomString(8);  // Random 8-character username
        String domain = domains[random.nextInt(domains.length)];  // Random domain

        return username + "@" + domain;
    }
}
