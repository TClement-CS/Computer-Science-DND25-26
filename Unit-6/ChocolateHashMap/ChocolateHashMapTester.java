public class ChocolateHashMapTester {
    public static void main(String[] args) {
        ChocolateHashMap<String, String> chocolateMap = new ChocolateHashMap<>();

        // Test put() and toString()
        System.out.println("Adding entries to the map...");
        chocolateMap.put("CHOC-1", "DARK");
        chocolateMap.put("CHOC-12", "MILK");
        chocolateMap.put("CHOC-123", "WHITE");
        System.out.println("Map after adding entries: ");
        System.out.println(chocolateMap); // Test toString()

        // Test containsKey()
        System.out.println("Test containsKey():");
        System.out.println(chocolateMap.containsKey("CHOC-1")); // true
        System.out.println(chocolateMap.containsKey("CHOC-50")); // false

        // Test get()
        System.out.println("Test get():");
        System.out.println(chocolateMap.get("CHOC-1")); // DARK
        System.out.println(chocolateMap.get("CHOC-50")); // null

        // Test remove()
        System.out.println("Test remove():");
        chocolateMap.remove("CHOC-12");
        System.out.println("Map after removing CHOC-12: ");
        System.out.println(chocolateMap); // Test toString()
        System.out.println(chocolateMap.size()); // Test size after removal

        // Test isEmpty() and size()
        System.out.println("Test isEmpty() and size():");
        System.out.println(chocolateMap.isEmpty()); // false
        System.out.println(chocolateMap.size()); // 2

        // Adding more entries to check rehashing (if needed)
        System.out.println("Adding more entries...");
        chocolateMap.put("CHOC-100", "WHITE");
        chocolateMap.put("CHOC-200", "DARK");
        System.out.println("Map after adding more entries: ");
        System.out.println(chocolateMap); // Test toString()
        System.out.println(chocolateMap.size()); // Checking size after adding more entries

        // Test currentLoadFactor()
        System.out.println("Test currentLoadFactor():");
        System.out.println(chocolateMap.currentLoadFactor()); // Load factor, e.g., 0.4 (depends on the number of
                                                              // entries and buckets)

        // Test containsValue()
        System.out.println("Test containsValue():");
        System.out.println(chocolateMap.containsValue("DARK")); // true
        System.out.println(chocolateMap.containsValue("MILK")); // false (after removal)

        System.out.println("Explicitly triggering rehash by adding more entries...");
        chocolateMap.put("CHOC-300", "MILK");
        chocolateMap.put("CHOC-400", "DARK");
        chocolateMap.put("CHOC-500", "WHITE");
        System.out.println("Map after adding entries to trigger rehash: ");
        System.out.println(chocolateMap); // Test toString() after rehashing

        // Verifying the data and checking if rehash worked properly
        System.out.println("Test containsKey() after rehash:");
        System.out.println(chocolateMap.containsKey("CHOC-1")); // true
        System.out.println(chocolateMap.containsKey("CHOC-300")); // true

        // Test get() after rehash
        System.out.println("Test get() after rehash:");
        System.out.println(chocolateMap.get("CHOC-400")); // DARK
        System.out.println(chocolateMap.get("CHOC-500")); // WHITE

        // Test toString() after rehashing
        System.out.println("Map after rehashing: ");
        System.out.println(chocolateMap.toString());

        // Additional tests (like emptying the map)
        System.out.println("Removing all items...");
        chocolateMap.remove("CHOC-1");
        chocolateMap.remove("CHOC-123");
        chocolateMap.remove("CHOC-100");
        chocolateMap.remove("CHOC-200");
        chocolateMap.remove("CHOC-300");
        chocolateMap.remove("CHOC-400");
        chocolateMap.remove("CHOC-500");

        System.out.println("Map after removing all entries: ");
        System.out.println(chocolateMap); // Empty map
        System.out.println(chocolateMap.size()); // 0
        System.out.println(chocolateMap.isEmpty()); // true
    }
}
