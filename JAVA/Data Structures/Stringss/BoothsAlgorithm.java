package Stringss;

public class BoothsAlgorithm {
    
    public static int leastCyclicRotation(String S) {
        S += S;
        int[] f = new int[S.length()];
        java.util.Arrays.fill(f, -1);
        int k = 0;
        for (int j = 1; j < S.length(); j++) {
            char sj = S.charAt(j);
            int i = f[j - k - 1];
            while (i != -1 && sj != S.charAt(k + i + 1)) {
                if (sj < S.charAt(k + i + 1))
                    k = j - i - 1;
                i = f[i];
            }
            if (sj != S.charAt(k + i + 1)) {
                if (sj < S.charAt(k))
                    k = j;
                f[j - k] = -1;
            } else
                f[j - k] = i + 1;
        }
        return k;
    }

    public static void main(String[] args) {

        String s = "abcde";
        int index = leastCyclicRotation(s);

        // Outputs 0 since the string is already in its least rotation
        System.out.println(index);

        s = "cdeab";
        index = leastCyclicRotation(s);

        // Outputs 3 since rotating the string 3 times to the left makes
        // the smallest rotation: "cdeab" -> "deabc" -> "eabcd" -> "abcde"
        System.out.println(index);
    }

}
