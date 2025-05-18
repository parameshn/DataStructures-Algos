package Stringss;
/*URLify: Write a method to replace all spaces in a string with '%20'. You may assume that the string 
has sufficient space at the end to hold the additional characters, and that you are given the "true" 
length of the string. (Note: If implementing in Java, please use a character array so that you can 
perform this operation in place.) 
EXAMPLE 
Input:
 Output:
 "Mr 3ohn Smith
 "Mr%203ohn%20Smith"  */

public class Q3 {

    //not in place
    public static String whiteSpace(String s) {
        if (s == null) {
            return "String empty";
        }

        StringBuilder result = new StringBuilder(); //uses extra datastructure

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                result.append("%20");
            } else {
                result.append(s.charAt(i));
            }
        }

        return result.toString();
    }

    public static String whiteSpace2(String s) {

        int wSpace = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ')
                wSpace++;
        }
        
        char[] chars = new char[wSpace * 2 + s.length()]; // %20 is 3 chars, space is 1 => need 2 extra per space

        int j = 0; 
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                chars[j++] = '%';
                chars[j++] = '2';
                chars[j++] = '0';
            } else {
                chars[j++] = s.charAt(i);
            }
        }
        

        return new String(chars);
    }

    public static void main(String[] args) {
        String s = "man and women";
        System.out.println(whiteSpace(s));
        System.out.println(whiteSpace2(s));

    }
}
