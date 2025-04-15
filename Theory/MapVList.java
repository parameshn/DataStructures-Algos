/*
 * Map vs Collection — Big Picture
 * 
 * 
 * Feature                Map<K, V>                           Collection<E> (e.g., List, Set, Queue)
 * Stores                 Key-Value pairs                     Single values
 * Structure             Think: Dictionary / Phonebook       Think: List of names or a Set of cards
 * Allows duplicate keys ❌ (One value per key)             ✅ (List), ❌ (Set)
 * Access type           .get(key)                           Iterate or index-based access (like .get(i))
 * Examples              HashMap, TreeMap, LinkedHashMap     ArrayList, HashSet, PriorityQueue
 */

/*
 * Memory Visualization
 *  Map<K, V>
 * Visualize this like a Filing Cabinet:
 * 
 * Map<String, Integer> map = new HashMap<>();
 * map.put("apple", 10);
 * map.put("banana", 20);
 * 
 * Map Memory Representation:
 * 
 * ┌────────────┬─────────┐
 * │ "apple"    │ 10      │
 * ├────────────┼─────────┤
 * │ "banana"   │ 20      │
 * └────────────┴─────────┘
 * 
 * 
 */
/*
 * Each row = one Map.Entry
 * 
 * You can’t loop over this directly.
 * 
 * You ask the map:
 * 
 * keySet() to get all keys (like opening all drawers)
 * 
 * values() to get all values (like dumping contents)
 * 
 * entrySet() to get both (key and value together)
 */

/*
 * Collection<E>
 * Visualize this like a Shopping Basket:
 * 
 * List<String> list = new ArrayList<>();
 * list.add("apple");
 * list.add("banana");
 * 
 * Collection Memory Representation:
 * [ "apple", "banana" ]
 * 
 * One sequence of values
 * 
 * Easy to iterate directly:
 * for (String fruit : list)
 * 
 */

/*
 * Iteration Differences
 * 
 * Collection (easy)
 * for (String item : list) {
 * System.out.println(item);
 * }
 * 
 * 
 * Map (you need a view)
 * 
 * for (Map.Entry<String, Integer> entry : map.entrySet()) {
 * System.out.println(entry.getKey() + ": " + entry.getValue());
 * }
 * 
 * 
 * 
 */

 /*
  * Concept Map Collection
  * Like a... 📂 Filing Cabinet 🧺 Basket / Line of items
  * Holds Pairs (key → value) Single items
  * Direct loop ❌ Need to convert to Set ✅ Directly iterable
  * Use case Indexing, lookup by name Lists, sets, sequences
  */


  

/*
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
 * 
 * 
 * Under the hood:
 * Map itself is not a simple list or sequence.
 * 
 * It’s a data structure that holds associations (key → value).
 * 
 * But it doesn’t expose itself like a list of these pairs.
 * 
 * Instead, it offers "views" (like entrySet()), which are iterable.
 * 
 * 
 * Why it's important:
 * Because of this "container of associations" design, Java doesn't allow you to
 * do:
 * 
 * 
 * for (var something : map) // ❌ Map is not directly iterable
 * You must ask it to give you a view into its contents.
 */