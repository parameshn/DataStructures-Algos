package Stringss;
//LongestCommonSubstring
public class LCS {

    private static String LongestCommonSubstring(String s, String s1) {
        int m = s.length();
        int n = s1.length();

        int[][] dp = new int[m + 1][n + 1]; // Extra row and column for base cases
        int maxLen = 0;
        int endIndex = 0; // To track the end index of the longest common substring in `s`

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == s1.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;

                    if (dp[i][j] > maxLen) {
                        maxLen = dp[i][j];
                        endIndex = i; // endIndex is exclusive
                    }
                }
            }
        }

        if (maxLen == 0) {
            return ""; // No common substring
        }

        return s.substring(endIndex - maxLen, endIndex);
    }

    public static void main(String[] args) {
        String s = "absbs";
        String s1 = "absds";
        System.out.println(LongestCommonSubstring(s,s1));

    }
}
