import java.util.*;

public class SocialMediaChecker {
    private HashMap<String, Integer> users = new HashMap<>();
    private HashMap<String, Integer> attempts = new HashMap<>();
    public SocialMediaChecker() {
        users.put("john_doe", 101);
        users.put("admin", 102);
        users.put("guest", 103);
    }
    public boolean checkAvailability(String username) {
        attempts.put(username, attempts.getOrDefault(username, 0) + 1);
        return !users.containsKey(username);
    }
    public List<String> suggestAlternatives(String username) {
        List<String> suggestions = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            String newName = username + i;

            if (!users.containsKey(newName)) {
                suggestions.add(newName);
            }
        }
        String dotVersion = username.replace("_", ".");
        if (!users.containsKey(dotVersion)) {
            suggestions.add(dotVersion);
        }
        return suggestions;
    }
    public String getMostAttempted() {

        String maxUser = "";
        int maxCount = 0;

        for (Map.Entry<String, Integer> entry : attempts.entrySet()) {

            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                maxUser = entry.getKey();
            }
        }

        return maxUser + " (" + maxCount + " attempts)";
    }
    public void registerUser(String username, int userId) {
        if (checkAvailability(username)) {
            users.put(username, userId);
            System.out.println(username + " registered successfully.");
        } else {
            System.out.println("Username already taken.");
        }
    }
    public static void main(String[] args) {
        SocialMediaChecker checker = new SocialMediaChecker();
        System.out.println("john_doe available? " +
                checker.checkAvailability("john_doe"));
        System.out.println("jane_smith available? " +
                checker.checkAvailability("jane_smith"));
        System.out.println("\nSuggestions for john_doe:");
        System.out.println(checker.suggestAlternatives("john_doe"));
        checker.checkAvailability("admin");
        checker.checkAvailability("admin");
        checker.checkAvailability("admin");
        System.out.println("\nMost attempted username:");
        System.out.println(checker.getMostAttempted());
    }
}