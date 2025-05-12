package Stringss;

//import java.lang.reflect.Array;
import java.util.*;

/*Check Permutation: Given two strings, write a method to decide if one is a permutation of the 
other. */
public class Q2 {
    
    public static boolean Premutation(String s, String s2) {

        // if (s.isEmpty() || s2.isEmpty() || s == null || s2 == null || s2.length() != s.length()) {
        // Because if s or s2 is null, calling .isEmpty() will throw a
        // NullPointerException.
        if (s == null || s2 == null || s.isEmpty() || s2.isEmpty() || s.length() != s2.length()) {

            System.out.println("error in string input");
            return false;
        }

        if (s.equals(s2)) {
            return true;
        }

        // using character frequency arrays to compare the two strings
        int[] Sone = new int[128];
        int[] Stwo = new int[128];

        for (int i = 0; i < s.length(); i++) {
            int val = s.charAt(i);
            Sone[val] = Sone[val] + 1;
        }
        for (int i = 0; i < s.length(); i++) {
            int val = s2.charAt(i); // implicit casting
            // A char in Java is 16 bits (0 to 65535), and an int is 32 bits.
            // smaller to larger data type
            Stwo[val] = Stwo[val] + 1;
        }

        //if(Sone.equals(Stwo)) 
        if (Arrays.equals(Sone, Stwo))
            return true;
        return false;
    }
    
    public static boolean Premutation2(String s, String s2) {

        if (s == null || s2 == null || s.isEmpty() || s2.isEmpty() || s.length() != s2.length()) {

            System.out.println("error in string input");
            return false;
        }

        if (s.equals(s2)) {
            return true;
        }

        char[] a = s.toCharArray();
        char[] b = s2.toCharArray();

        Arrays.sort(a);
        Arrays.sort(b);

        return Arrays.equals(a, b);


    }

    public static void main(String[] args) {
        String s = "abd";
        String s2 = "bda";

        System.out.println("Premutation count array:" + Premutation(s, s2));
        System.out.println("Premutation sort method:" + Premutation2(s, s2));


    }
}

/*
 * Why s.equals(s2) works for Strings:
 * In Java, String is a class that overrides the .equals() method to compare
 * contents — not just references.
 * 
 * java
 * Copy
 * Edit
 * String s1 = "abc";
 * String s2 = "abc";
 * 
 * System.out.println(s1.equals(s2)); // ✅ true
 * ✅ s.equals(s2) returns true if both strings contain the same characters in
 * the same order — it checks contents, not memory addresses.
 * 
 * ❌ Why array1.equals(array2) does NOT work for arrays:
 * Arrays in Java do not override the .equals() method from Object.
 * 
 * So when you write:
 * 
 * java
 * Copy
 * Edit
 * int[] a = {1, 2, 3};
 * int[] b = {1, 2, 3};
 * 
 * System.out.println(a.equals(b)); // ❌ false
 * That returns false because:
 * 
 * It checks whether a and b are the same object in memory (reference equality),
 * not whether their contents are the same.
 * 
 * ✅ Correct way to compare arrays:
 * Use Arrays.equals() from java.util.Arrays:
 * 
 * java
 * Copy
 * Edit
 * import java.util.Arrays;
 * 
 * System.out.println(Arrays.equals(a, b)); // ✅ true
 * This checks element-by-element and returns true if the arrays have the same
 * contents.
 * 
 * 🧠 Summary
 * 
 * Type .equals() behavior Proper comparison
 * String Compares contents s1.equals(s2) ✅
 * Array Compares references Arrays.equals(a, b) ✅
 */

 /*byte → short → int → long → float → double
          ↑       ↑       ↑
        char ———————→
 */