package Stringss;

public class SBuilder {

    // Inefficient string concatenation - O(n^2)
    public static String String1(String[] words) {
        String sentence = "";
        for (String w : words) {
            sentence = sentence + w; 
        }
        return sentence;
    }

    // Efficient concatenation using StringBuilder - O(n)
    public static String SBuilder1(String[] words) {
        StringBuilder sentence = new StringBuilder();
        for (String w : words) {
            sentence.append(w);
            // StringBuilder uses an internal char array that resizes intelligently (similar
            // to ArrayList).
        }
        return sentence.toString();
    }

    public static void main(String[] args) {
        String[] s = new String[] { "Hello", " ", "World", "!" };
        String s2 = String1(s);

        System.out.println("Using String: " + s2);
        s2 = SBuilder1(s);
        System.out.println("Using StringBuilder: " + s2 );


    }
}
