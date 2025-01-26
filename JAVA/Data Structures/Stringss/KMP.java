package Stringss;

import java.util.List;
import java.util.ArrayList;

public class KMP {

    public static List<Integer> kmp(String txt, String pat) {

        List<Integer> matches = new ArrayList<>();
        if (txt == null || pat == null)
            return matches;

        int m = pat.length();
        int n = txt.length();
        int i = 0, j = 0;
        int[] arr = kmpHelper(pat, m);

        while (i < n) {
            if (txt.charAt(i) == pat.charAt(j)) { // Corrected condition
                i++;
                j++;
            }

            if (j == m) {
                matches.add(i - j);
                j = arr[j - 1];
            } else if (i < n && txt.charAt(i) != pat.charAt(j)) { // Corrected condition
                if (j != 0)
                    j = arr[j - 1];
                else
                    i++;
            }
        }
        return matches;
    }

    private static int[] kmpHelper(String pat, int m) {
        int[] arr = new int[m];
        int len = 0;
        int i = 1;

        while (i < m) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                arr[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = arr[len - 1];
                } else {
                    arr[i] = 0;
                    i++;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        List<Integer> matches = kmp("ababaabba", "aba");
        System.out.println(matches); // Output: [0, 3]
    }
}
// https://chat.deepseek.com/a/chat/s/26ce1066-e120-48d3-a243-68422825110e