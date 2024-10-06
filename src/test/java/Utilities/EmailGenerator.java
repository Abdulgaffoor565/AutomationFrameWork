package Utilities;

import java.util.Random;

public class EmailGenerator {

	    private static final String CHARACTERS = "abcdefghijklmnopqrstuvwxyz0123456789";
	    private static final String[] DOMAINS = { "gmail.com", "yahoo.com", "outlook.com", "example.com" };

	    public  String generateRandomEmail() {
	        String username = generateRandomString(8); // Username part of the email (before @)
	        String domain = getRandomDomain();         // Domain part of the email (after @)
	        
	        return username + "@" + domain;
	    }

	    // Method to generate a random string of a given length
	    private static String generateRandomString(int length) {
	        Random random = new Random();
	        StringBuilder sb = new StringBuilder();

	        for (int i = 0; i < length; i++) {
	            int index = random.nextInt(CHARACTERS.length());
	            sb.append(CHARACTERS.charAt(index));
	        }

	        return sb.toString();
	    }

	    // Method to get a random domain from the predefined list
	    private static String getRandomDomain() {
	        Random random = new Random();
	        int index = random.nextInt(DOMAINS.length);
	        return DOMAINS[index];
	    }
}
