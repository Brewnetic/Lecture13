// ============================================
// LECTURE 13: Collections Framework & HashMap
// Gaming Leaderboard System
// ============================================

// TODO: Import HashMap from java.util package
// HINT: HashMap is part of the Collections Framework
// SYNTAX: import java.util.HashMap;
// This allows us to store player names with their scores
import _________________;

// TODO: Import Map from java.util package
// HINT: Map is used for Map.Entry when iterating
// SYNTAX: import java.util.Map;
// This allows us to use Map.Entry<K,V> for key-value iteration
import _________________;

// TODO: Import Scanner from java.util package
// HINT: Scanner is used for reading user input
// SYNTAX: import java.util.Scanner;
// This allows us to simulate leaderboard interactions
import _________________;

public class Lecture13 {
    
    public static void main(String[] args) {
        // Create a Scanner object to read user input from the console
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("========================================");
        System.out.println("   GAMING LEADERBOARD SYSTEM");
        System.out.println("========================================\n");
        
        // ============================================
        // PART 1: Creating Player Leaderboard with HashMap
        // ============================================
        
        // HashMap is perfect for storing player scores in a leaderboard system
        // We map each player's name (key) to their score (value)
        // If a player plays again and gets a higher score, we just update their entry
        // HashMap automatically prevents duplicate player names - each player appears only once!
        // Think of it like a scoreboard where each player has exactly one entry with their best score
        
        // TODO: Create a HashMap<String, Integer> called playerScores
        // HINT: Use the 'new' keyword to instantiate the collection
        // SYNTAX: HashMap<String, Integer> name = new HashMap<>();
        // <String, Integer> means keys are player names, values are scores
        // HashMap<>() creates an empty map ready to track player scores
        HashMap<String, Integer> playerScores = _________________;
        
        System.out.println("--- Starting Leaderboard ---\n");
        
        // The .put() method adds player-score pairs to the HashMap
        // If a player already exists, .put() updates their score with the new value
        // .put() returns the old value if the key existed, or null if it's a new player
        // This is more powerful than HashSet because we can track associated data!
        
        // TODO: Add "Alex" with score 1500 using .put()
        // HINT: Use the .put() method
        // SYNTAX: collectionName.put(key, value);
        // This adds "Alex" with score 1500 to the leaderboard
        playerScores._________________("Alex", 1500);
        
        // TODO: Add "Jordan" with score 2000
        // HINT: Same method as above, different player and score
        // This adds "Jordan" with score 2000 to the leaderboard
        playerScores._________________("Jordan", 2000);
        
        // TODO: Add "Sam" with score 1800
        // HINT: Same method as above, third player
        // This adds "Sam" with score 1800 to the leaderboard
        playerScores._________________("Sam", 1800);
        
        // TODO: Add "Casey" with score 1700
        // HINT: Same method as above, fourth player
        // This adds "Casey" with score 1700 to the leaderboard
        playerScores._________________("Casey", 1700);
        
        System.out.println("✓ Leaderboard initialized with 4 players.\n");
        
        // Display current leaderboard status
        System.out.println("--- Current Leaderboard ---");
        
        // TODO: Print total players on leaderboard using .size()
        // HINT: .size() returns an integer count of players in the HashMap
        // SYNTAX: collectionName.size();
        // This tells us how many players are on the leaderboard
        System.out.println("Total players: " + playerScores._________________());
        
        System.out.println("\nPlayer Scores:");
        
        // Enhanced for-each loop to display each player and their score
        // HashMap iteration order is unpredictable (not in insertion order like ArrayList)
        // But we can still loop through all entries using .entrySet()
        
        // TODO: Fill in the for-each loop to iterate through all players
        // HINT: The loop uses Map.Entry<String, Integer> for key-value pairs
        // HINT: We need entry.getKey() for player name and entry.getValue() for score
        // SYNTAX: for (Map.Entry<String, Integer> entry : playerScores.entrySet())
        // The variable 'entry' represents each player-score pair as we loop through
        int playerNum = 1;
        for (_________________ entry : playerScores._________________()) {
            // Get player name from entry
            String playerName = entry._________________();
            // Get player score from entry
            Integer score = entry._________________();
            // Print the current player
            System.out.println("  " + playerNum + ". " + playerName + ": " + score + " pts");
            playerNum++;
        }
        
        System.out.println();
        
        // ============================================
        // PART 2: Looking Up a Player's Score
        // ============================================
        
        // HashMap lets us instantly find a player's score by name
        // This is much faster than ArrayList where we'd have to loop through all players
        // Think of it like looking up someone's phone number in a contact list by name
        
        System.out.println("--- Player Score Lookup ---");
        
        System.out.print("Enter player name to look up: ");
        String lookupPlayer = scanner.nextLine();
        
        // TODO: Check if player exists using .containsKey()
        // HINT: .containsKey() returns true if player exists, false otherwise
        // SYNTAX: collectionName.containsKey(key);
        // This safely checks before we try to get the score
        if (playerScores.___________________(lookupPlayer)) {
            // TODO: Get the player's score using .get()
            // HINT: .get() retrieves the value associated with the key
            // SYNTAX: collectionName.get(key);
            // This returns the score for the player
            Integer playerScore = playerScores.___________________(lookupPlayer);
            System.out.println("✓ " + lookupPlayer + "'s score: " + playerScore + " pts");
        } else {
            System.out.println("✗ Player '" + lookupPlayer + "' not found on leaderboard!");
        }
        
        System.out.println();
        
        // ============================================
        // PART 3: Updating a Player's Score
        // ============================================
        
        // When a player plays again and gets a new score, we update it using .put()
        // .put() automatically updates the value if the key already exists
        // We can save the old score if we want to display the update
        
        System.out.println("--- Score Update ---");
        
        System.out.print("Which player's score to update? ");
        String updatePlayer = scanner.nextLine();
        
        // TODO: Check if player exists using .containsKey()
        // HINT: Same method as before to verify player exists
        // SYNTAX: collectionName.containsKey(key);
        if (playerScores.___________________(updatePlayer)) {
            // TODO: Get the old score using .get()
            // HINT: Capture this so we can display before/after
            // SYNTAX: collectionName.get(key);
            Integer oldScore = playerScores.___________________(updatePlayer);
            
            System.out.print("New score: ");
            Integer newScore = Integer.parseInt(scanner.nextLine());
            
            // TODO: Update the score using .put()
            // HINT: .put() with existing key overwrites the old value
            // SYNTAX: collectionName.put(key, newValue);
            // This updates the player's score in the HashMap
            playerScores.___________________(updatePlayer, newScore);
            
            System.out.println("✓ Updated " + updatePlayer + ": " + oldScore + " → " + newScore + " pts");
        } else {
            System.out.println("✗ Player '" + updatePlayer + "' not found!");
        }
        
        System.out.println();
        
        // ============================================
        // PART 4: Finding Highest Score
        // ============================================
        
        System.out.println("--- Leaderboard Statistics ---");
        
        // To find the highest score, we need to loop through all players
        // Track the maximum as we go through each score
        String topPlayer = "";
        Integer topScore = 0;
        
        // TODO: Fill in the for-each loop to find the player with highest score
        // HINT: Iterate through all players using .entrySet()
        // HINT: Compare each score with current topScore and update if higher
        // SYNTAX: for (Map.Entry<String, Integer> entry : playerScores.entrySet())
        for (_________________ entry : playerScores._________________()) {
            String currentPlayer = entry._________________();
            Integer currentScore = entry._________________();
            
            // Update top player if current score is higher
            if (currentScore > topScore) {
                topScore = currentScore;
                topPlayer = currentPlayer;
            }
        }
        
        System.out.println("🏆 Top Player: " + topPlayer + " with " + topScore + " pts");
        
        System.out.println();
        
        // ============================================
        // PART 5: Remove Player from Leaderboard
        // ============================================
        
        System.out.println("--- Remove Player ---");
        
        System.out.print("Remove which player? ");
        String removePlayer = scanner.nextLine();
        
        // TODO: Check if player exists using .containsKey()
        // HINT: Same method to verify player exists first
        // SYNTAX: collectionName.containsKey(key);
        if (playerScores.___________________(removePlayer)) {
            // TODO: Remove the player using .remove()
            // HINT: .remove() returns the value that was removed
            // SYNTAX: collectionName.remove(key);
            // This removes the player and returns their score
            Integer removedScore = playerScores.___________________(removePlayer);
            System.out.println("✓ Removed " + removePlayer + " (had " + removedScore + " pts)");
        } else {
            System.out.println("✗ Player '" + removePlayer + "' not found!");
        }
        
        System.out.println();
        
        // ============================================
        // PART 6: Final Leaderboard State
        // ============================================
        
        System.out.println("--- Final Leaderboard ---");
        
        // TODO: Print total players remaining using .size()
        // HINT: .size() returns updated count after removal
        // SYNTAX: collectionName.size();
        System.out.println("Total players: " + playerScores._________________());
        
        // TODO: Display all remaining players
        // HINT: Use same for-each loop pattern as before
        // HINT: Iterate through .entrySet() to get key-value pairs
        if (playerScores._________________() > 0) {
            int finalNum = 1;
            for (_________________ entry : playerScores._________________()) {
                String playerName = entry._________________();
                Integer score = entry._________________();
                System.out.println("  " + finalNum + ". " + playerName + ": " + score + " pts");
                finalNum++;
            }
        } else {
            System.out.println("  (empty leaderboard)");
        }
        
        System.out.println("\n========================================");
        System.out.println("    Leaderboard System Complete!");
        System.out.println("========================================");
        
        // Close the Scanner when done (good practice for resource management)
        scanner.close();
    }
}

// ============================================
// KEY HASHMAP METHODS REFERENCE
// ============================================
/*
 * HashMap Methods Used in This Example:
 * 
 * .put(K key, V value)      - Add new entry or update existing
 *                             Returns: old value if key existed, null if new
 *                             Time: Very fast - O(1) average
 *                             Note: Automatically overwrites if key exists!
 * 
 * .get(K key)               - Get value by key
 *                             Returns: value if found, null if not found
 *                             Time: Very fast - O(1) average
 *                             WARNING: Always check .containsKey() first or check for null!
 * 
 * .containsKey(K key)       - Check if key exists in map
 *                             Returns: boolean (true if found, false if not)
 *                             Time: Very fast - O(1) average
 *                             NOTE: Use this before calling .get() to avoid null!
 * 
 * .remove(K key)            - Remove entry by key
 *                             Returns: value that was removed, null if key didn't exist
 *                             Time: Very fast - O(1) average
 *                             NOTE: Useful to display old value in confirmation message
 * 
 * .size()                   - Get number of entries
 *                             Returns: int (count of key-value pairs)
 *                             Time: Very fast - O(1)
 * 
 * .isEmpty()                - Check if map is empty
 *                             Returns: boolean (true if size is 0)
 *                             Time: Very fast - O(1)
 * 
 * .entrySet()               - Get all key-value pairs for iteration
 *                             Returns: Set of Map.Entry objects
 *                             Usage: for (Map.Entry<K,V> entry : map.entrySet())
 * 
 * .keySet()                 - Get all keys for iteration
 *                             Returns: Set of all keys
 *                             Usage: for (K key : map.keySet())
 * 
 * .values()                 - Get all values for iteration
 *                             Returns: Collection of all values
 *                             Usage: for (V value : map.values())
 * 
 * Why HashMap for Gaming Leaderboard?
 * ✓ Instantly finds a player's score by name (O(1) vs O(n) for ArrayList)
 * ✓ Automatically prevents duplicate player entries
 * ✓ Easy to update scores when players play again
 * ✓ Easy to add/remove players dynamically
 * ✓ Efficient for large leaderboards with thousands of players
 * ✓ Each operation (add/get/remove) runs in constant time
 * 
 * HashMap Key Concept:
 * - KEY-VALUE MAPPING - Each unique key maps to a value
 * - UNIQUE KEYS - Can't have two entries with same player name
 * - DUPLICATE VALUES - Multiple players can have same score
 * - FAST OPERATIONS - Add/remove/lookup all run in O(1) average
 * - UNORDERED - Iteration order is unpredictable (random)
 * 
 * Real-World Uses of HashMap:
 * - Gaming leaderboards (this example!)
 * - Caching/memoization (key -> cached result)
 * - Phone books (name -> phone number)
 * - Dictionary lookups (word -> definition)
 * - Database indexes (ID -> record)
 * - Configuration maps (setting name -> value)
 * - Frequency counters (element -> count)
 * - Session management (session ID -> user data)
 */


// ============================================
// ENTRY OBJECT REFERENCE
// ============================================
/*
 * Map.Entry<K, V> represents a single key-value pair in a HashMap
 * 
 * When you iterate using .entrySet():
 * for (Map.Entry<String, Integer> entry : playerScores.entrySet()) {
 *     String key = entry.getKey();        // Gets the key
 *     Integer value = entry.getValue();   // Gets the value
 * }
 * 
 * Why use Map.Entry?
 * - Efficiency: Get both key and value in one iteration
 * - Better than iterating .keySet() then calling .get() each time
 * - Map.Entry provides convenient methods: .getKey() and .getValue()
 * 
 * Alternative iteration methods:
 * 
 * For keys only:
 * for (String playerName : playerScores.keySet()) {
 *     System.out.println(playerName);
 * }
 * 
 * For values only:
 * for (Integer score : playerScores.values()) {
 *     System.out.println(score);
 * }
 * 
 * For both (recommended):
 * for (Map.Entry<String, Integer> entry : playerScores.entrySet()) {
 *     System.out.println(entry.getKey() + ": " + entry.getValue());
 * }
 */


// ============================================
// HASHMAP vs ARRAYLIST COMPARISON
// ============================================
/*
 * Both are commonly used collections but serve different purposes:
 * 
 * HashMap:                          ArrayList:
 * - Purpose: Key-value mapping      - Purpose: Ordered list
 * - Lookup: O(1) by key             - Lookup: O(n) by value
 * - Keys: Unique (no duplicates)    - All values: Can repeat
 * - Values: Can repeat              - Order: Maintains insertion order
 * - Order: Unpredictable            - Index access: Can access by position
 * - Best for: Name -> Value lookup  - Best for: Ordered sequences
 * - Thread-safe: No (single-thread) - Thread-safe: No (single-thread)
 * 
 * Example: Leaderboard
 * HashMap: player.name -> score     Instant lookup by name!
 * ArrayList: List of all players    Must loop to find "Alex"
 * 
 * When to use HashMap:
 * - Need to find value by key name
 * - Order of entries doesn't matter
 * - Want fast O(1) lookups
 * - Working with key-value relationships
 * - Examples: Dictionary, Contact list, Settings, Scores
 * 
 * When to use ArrayList:
 * - Need ordered list of items
 * - Need to access by position (index)
 * - Order of insertion matters
 * - Need to maintain sequence
 * - Examples: Shopping list, To-do list, Results in order
 * 
 * Leaderboard Example:
 * HashMap: Find "Alex"'s score instantly: playerScores.get("Alex") -> 1500
 * ArrayList: Loop through all players to find Alex (slow!)
 */
