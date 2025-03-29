package set;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;

public class SetImpl {

    enum Day {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
    }
    public static void main(String[] args) {
       

        HashSet<String> hashSet = new HashSet<>();

        // Add elements
        hashSet.add("Apple");
        hashSet.add("Banana");
        hashSet.add("Orange");
        hashSet.add("Apple"); // Duplicate, will be ignored

        System.out.println("HashSet: " + hashSet); // No guaranteed order

        // Check if an element exists
        System.out.println("Contains Apple? " + hashSet.contains("Apple")); // true

        // Remove an element
        hashSet.remove("Banana");
        System.out.println("After removing Banana: " + hashSet);

        // Size of the set
        System.out.println("Size: " + hashSet.size());

        // Iterate through elements
        System.out.println("Elements in HashSet:");
        for (String fruit : hashSet) {
            System.out.println(fruit);
        }

        // Using forEach with lambda
        System.out.println("Using forEach:");
        hashSet.forEach(fruit -> System.out.println(fruit));

        // Check if empty and clear
        System.out.println("Is empty? " + hashSet.isEmpty());
        hashSet.clear();
        System.out.println("After clear, is empty? " + hashSet.isEmpty());


        // Create a LinkedHashSet
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();

        // Add elements
        linkedHashSet.add("Apple");
        linkedHashSet.add("Banana");
        linkedHashSet.add("Orange");
        linkedHashSet.add("Apple"); // Duplicate, will be ignored

        System.out.println("LinkedHashSet: " + linkedHashSet); // Preserves insertion order: [Apple, Banana, Orange]

        // Check if an element exists
        System.out.println("Contains Apple? " + linkedHashSet.contains("Apple")); // true

        // Remove an element
        linkedHashSet.remove("Banana");
        System.out.println("After removing Banana: " + linkedHashSet); // [Apple, Orange]

        // Size of the set
        System.out.println("Size: " + linkedHashSet.size());

        // Iterate through elements (will be in insertion order)
        System.out.println("Elements in LinkedHashSet (in insertion order):");
        for (String fruit : linkedHashSet) {
            System.out.println(fruit);
        }

        // Using forEach with lambda
        System.out.println("Using forEach (in insertion order):");
        linkedHashSet.forEach(fruit -> System.out.println(fruit));

        // Check if empty and clear
        System.out.println("Is empty? " + linkedHashSet.isEmpty());
        linkedHashSet.clear();
        System.out.println("After clear, is empty? " + linkedHashSet.isEmpty());

        // Create a TreeSet
        TreeSet<String> treeSet = new TreeSet<>();
        
        // Add elements
        treeSet.add("Banana");
        treeSet.add("Apple");
        treeSet.add("Orange");
        treeSet.add("Apple"); // Duplicate, will be ignored
        
        System.out.println("TreeSet: " + treeSet); // Sorted order: [Apple, Banana, Orange]
        
        // Check if an element exists
        System.out.println("Contains Apple? " + treeSet.contains("Apple")); // true
        
        // Remove an element
        treeSet.remove("Banana");
        System.out.println("After removing Banana: " + treeSet); // [Apple, Orange]
        
        // Size of the set
        System.out.println("Size: " + treeSet.size());
        
        // First and last elements
        System.out.println("First element: " + treeSet.first()); // Apple
        System.out.println("Last element: " + treeSet.last()); // Orange
        
        // Subset operations
        treeSet.add("Banana");
        treeSet.add("Cherry");
        treeSet.add("Grape");
        System.out.println("Updated TreeSet: " + treeSet); // [Apple, Banana, Cherry, Grape, Orange]
        
        // headSet - elements less than the specified element
        System.out.println("headSet(Cherry): " + treeSet.headSet("Cherry")); // [Apple, Banana]
        
        // tailSet - elements greater than or equal to the specified element
        System.out.println("tailSet(Cherry): " + treeSet.tailSet("Cherry")); // [Cherry, Grape, Orange]
        
        // subSet - elements between fromElement (inclusive) and toElement (exclusive)
        System.out.println("subSet(Banana, Orange): " + treeSet.subSet("Banana", "Orange")); // [Banana, Cherry, Grape]
        
        // Using NavigableSet methods
        NavigableSet<String> navigableSet = treeSet;
        System.out.println("lower(Cherry): " + navigableSet.lower("Cherry")); // Banana
        System.out.println("higher(Cherry): " + navigableSet.higher("Cherry")); // Grape
        System.out.println("ceiling(D): " + navigableSet.ceiling("D")); // Grape
        System.out.println("floor(D): " + navigableSet.floor("D")); // Cherry
        
        // Descending order
        System.out.println("Descending Set: " + navigableSet.descendingSet()); // [Orange, Grape, Cherry, Banana, Apple]
        TreeSet<String> desc = (TreeSet<String>) navigableSet.descendingSet();
        System.out.println(desc);
        // Poll operations
        System.out.println("pollFirst(): " + navigableSet.pollFirst()); // Removes and returns Apple
        System.out.println("pollLast(): " + navigableSet.pollLast()); // Removes and returns Orange
        System.out.println("After polling: " + navigableSet); // [Banana, Cherry, Grape]

        // Create an empty EnumSet
        EnumSet<Day> emptySet = EnumSet.noneOf(Day.class);
        System.out.println("Empty EnumSet: " + emptySet); // []
        
        // Create EnumSet with all enum constants
        EnumSet<Day> allDays = EnumSet.allOf(Day.class);
        System.out.println("All days: " + allDays); // [MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY]
        
        // Create EnumSet with specific elements
        EnumSet<Day> weekdays = EnumSet.of(Day.MONDAY, Day.TUESDAY, Day.WEDNESDAY, Day.THURSDAY, Day.FRIDAY);
        System.out.println("Weekdays: " + weekdays); // [MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY]
        
        // Create EnumSet with a range
        EnumSet<Day> weekend = EnumSet.range(Day.SATURDAY, Day.SUNDAY);
        System.out.println("Weekend: " + weekend); // [SATURDAY, SUNDAY]
        
        // Create EnumSet as a complement of another EnumSet
        EnumSet<Day> notWeekdays = EnumSet.complementOf(weekdays);
        System.out.println("Not weekdays: " + notWeekdays); // [SATURDAY, SUNDAY]
        
        // Basic operations
        // Add element
        emptySet.add(Day.MONDAY);
        System.out.println("After adding MONDAY: " + emptySet); // [MONDAY]
        
        // Check if contains
        System.out.println("Contains MONDAY? " + emptySet.contains(Day.MONDAY)); // true
        emptySet.add(Day.MONDAY);
        System.out.println("After adding MONDAY again: " + emptySet); // [MONDAY]
        
        // Remove element
        emptySet.remove(Day.MONDAY);
        System.out.println("After removing MONDAY: " + emptySet); // []
        
        // Size and isEmpty
        System.out.println("Size of weekdays: " + weekdays.size()); // 5
        System.out.println("Is empty? " + emptySet.isEmpty()); // true
        System.out.println("Is empty? " + emptySet.size()); // 0
        
        // Iteration
        System.out.println("Weekdays:");
        for (Day day : weekdays) {
            System.out.println(day);
        }
        
        // EnumSet with bulk operations
        EnumSet<Day> someDays = EnumSet.of(Day.WEDNESDAY,Day.MONDAY,  Day.FRIDAY);
        System.out.println("Some days: " + someDays); // [MONDAY, WEDNESDAY, FRIDAY]
        /*
         * Iteration: The internal representation ensures that iterators return elements
         * in the natural (declaration) order of the enum, and iterating over a bit
         * vector is extremely fast.
         */
        weekdays.removeAll(someDays);
        System.out.println("Weekdays after removing someDays: " + weekdays); // [TUESDAY, THURSDAY]
        
        // Adding all elements from another collection
        weekdays.addAll(someDays);
        System.out.println("Weekdays after adding back someDays: " + weekdays); // [MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY]
        

        


        
    }
}