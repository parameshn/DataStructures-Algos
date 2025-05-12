package Stringss;

/*Is Unique: Implement an algorithm to determine if a string has all unique characters. What if you 
cannot use additional data structures?  */

public class Q1 {

    public static boolean uniqueString(String s) {
        if (s == null || s.isEmpty()) {
            System.out.println("String is empty");
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    return false;
                }
            }
        }

        return true;
    }
    
    public static boolean USDataStructure(String s) {
        if (s == null || s.isEmpty()) {
            System.out.println("String is empty");
            return false;
        }
        if(s.length() > 128)
            return false;

        boolean[] charSet = new boolean[128];
        for (int i = 0; i < s.length(); i++) {
            int val = s.charAt(i);
            if (charSet[val])
                return false;
            charSet[val] = true;
        }
        return true;
    }
    public static void main(String[] args) {
        String s = null;

       
        System.out.println("The string is unique :" + uniqueString(s));
        System.out.println("The string is unique (using data structure) :" + USDataStructure(s));
        

        
    }
}
