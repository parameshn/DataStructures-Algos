package Map;

import java.util.*;

public class MapImpl {
    
    public static void main(String[] args) {

        System.out.println("===Hash Map===");

        Map<String, Integer> hashMap = new HashMap<>();

        System.out.println(hashMap.put("apple", 10));
        System.out.println(hashMap.put("banana", 20));
        System.out.println(hashMap.put("orange", 30));
        System.out.println(hashMap.put("grapes", 33));
        System.out.println(hashMap.put("apple", 50));

        /*
         * what happens conceptually with references:
         * 
         * Map (holds reference) → Entry object (key ↔ value pair)
         * └── key: "apple" (reference to String)
         * └── value: 50 (reference to Integer)
         * 
         * 
         * Map stores a reference to an Entry
         * Each key-value pair in the Map is stored as an internal object called a
         * Map.Entry.
         * 
         * Entry holds references to:
         * The key (e.g., "apple")
         * The value (e.g., 50)
         * 
         * Map → references Entry → Entry → references Key and Value
         * 
         */

       
          
        // Keys must be unique — you cannot have duplicate keys.
        // Values can be duplicated — multiple keys can map to the same value.

        //The order is not guaranteed in HashMap — it's based on hash codes, not insertion.

        System.out.println();

        // HashMap-specific: null keys and values
        System.out.println(hashMap.put("kiwi", null));
        System.out.println(hashMap);

        System.out.println(hashMap.put(null, null));
        System.out.println(hashMap);
        System.out.println(hashMap.put(null, null));
        System.out.println(hashMap);
        System.out.println(hashMap.put(null, 10));
        System.out.println(hashMap);
        System.out.println(hashMap.put(null, null));
        System.out.println(hashMap);

        System.out.println("size:" + hashMap.size());
        System.out.println("contains 'apple'=" + hashMap.containsKey("apple"));

        System.out.println("value of banana :" + hashMap.get("banana"));
        //System.out.println("key of 20 :" + hashMap.get(20));
        System.out.println("conatins value of =" + hashMap.containsValue(20));
        /*
         * But the reverse is not directly supported — you cannot get the key from a
         * value using a built-in method. HashMap is optimized for fast key-to-value
         * lookup, not value-to-key
         */

        //removal
        System.out.println("remove 'apple':" + hashMap.remove("apple"));
        System.out.println(hashMap);
        System.out.println("remove 'orange if value is 40:" + hashMap.remove("orange", 40));
        System.out.println("remove 'orange if value is 30:" + hashMap.remove("orange", 30));
        System.out.println("hash map after removal:" + hashMap);

        //bulk operations
        Map<String, Integer> extraItems = new HashMap<>();
        extraItems.put("grapes", 40);
        extraItems.put("banana", 25);
        hashMap.putAll(extraItems);
        System.out.println(hashMap);

        //iteration
        System.out.println("Iterating hashmap:");
        for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
            System.out.println("key:" + entry.getKey() + ",Value:" + entry.getValue());
        }

        /*
         * entrySet() converts the Map into a Set of entries to make it
         * easier (and more efficient) to iterate over the key-value pairs.
         * 
         * internally:
         * Set<Map.Entry<String, Integer>> entries = hashMap.entrySet();
         * 
         * for (Map.Entry<String, Integer> entry : entries) {
         * // entry is ONE pair like: "apple" -> 50
         * }
         * 
         * entrySet() returns a Set<Map.Entry<K,V>>
         * Each Map.Entry holds one key-value pair
         * It's the preferred way to loop through a map when you need both the key and
         * the value.
         * 
         * 
         * Set<Map.Entry<K, V>>
         * This is a Set of Map.Entry objects.
         * 
         * And Map.Entry<K, V> is a special object that holds a key-value pair.
         * 
         * So in this case, the Set is not holding raw values — it’s holding objects
         * that represent the key-value pairs.
         * 
         * A Map is like a dictionary .
         * 
         * entrySet() gives you a Set of "pages" (Map.Entry<K,V>) from that dictionary.
         * 
         * Each page (entry) contains both the word (key) and its definition (value).
         * 
         * You're getting a Set of references to entry objects inside the map.
         * 
         * Set<Map.Entry>
         * ├──→ [Key: "apple", Value: 10] (reference to entry)
         * ├──→ [Key: "banana", Value: 20]
         * 
         * hashMap.entrySet() returns a Set<Map.Entry<K, V>> (a "bundle" of all
         * entries).
         * 
         * The for-each loop (for (Map.Entry<K, V> entry : ...)) just iterates over that
         * Set.
         * 
         * Whether you store it in a variable or not, Java handles it the same way.
         * 
         * the for-each loop is just syntax sugar for what you described: it goes
         * through the "bundle" (entries) and assigns one reference at a time to entry
         * while incrementing the internal iterator.
         * 
         */

        /*
         * the two versions are logically equivalent, and the second one is just a more
         * concise version of the first.
         */
        System.out.println("Second method");
        Set<Map.Entry<String, Integer>> entries = hashMap.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println("key:" + entry.getKey() + ",Value:" + entry.getValue());
        }

        /*
         * The Map interface does not implement Iterable, so you can’t directly iterate
         * over a Map using a for-each loop like this:
         * for (Map.Entry<String, Integer> entry : hashMap) {
         * ...
         * }
         * 
         * That's because Map isn't a collection of entries in itself — it's more like a
         * container for them.
         */


        /*
         * Set<Map.Entry<K, V>> entrySet = map.entrySet();
         * 
         * entrySet: [ Entry1, Entry2, Entry3, ... ]
         *               ↓       ↓       ↓
         *         +---------+ +---------+ +---------+
         *         | "apple" | | "banana"| | "orange"|
         *         | 50      | | 20     |  |  30    |
         *        +---------+ +---------+ +---------+
         * 
         */
        /*
         * To iterate over a map, you must go through one of its views:
         * 
         * entrySet() – lets you iterate over key-value pairs (most common).
         * 
         * keySet() – lets you iterate over keys only.
         * 
         * values() – lets you iterate over values only.
         */

        System.out.println("\nKeys: " + hashMap.keySet());
        System.out.println("\nValues: " + hashMap.values());

        /*
         * Map is more like a container
         * 
         * Think of Map like a filing cabinet:
         * Each drawer (key) has a file inside (value).
         * 
         * You can't iterate over the whole cabinet directly — you need to:
         * 
         * Open each drawer (keySet())
         * 
         * Look inside each file (values())
         * 
         * Or access both drawer and file together (entrySet())
         * 
         * Under the hood:
         * 
         * Map itself is not a simple list or sequence.
         * 
         * It’s a data structure that holds associations (key → value).
         * 
         * But it doesn’t expose itself like a list of these pairs.
         * 
         * Instead, it offers "views" (like entrySet()), which are iterable.
         * 
         * Map<String, Integer> map = new HashMap<>();
         * → This is a container: it stores key-value mappings, not as a list, but
         * internally using hashing and buckets (in case of HashMap).
         * 
         * map.entrySet()
         * → Gives you a Set of Map.Entry<String, Integer> objects, which is iterable.
         */

    }
}
