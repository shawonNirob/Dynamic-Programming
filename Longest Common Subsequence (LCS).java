public class LCS {
    public static void main(String[] args) {
        String X = "ABCBDAB";
        String Y = "BDCAB";

        System.out.println("Longest Common Subsequence: " + findLCS(X, Y));
    }

    private static String findLCS(String X, String Y) {
        int m = X.length();
        int n = Y.length();

        // Create a 2D array to store the lengths of LCS
        int[][] dp = new int[m + 1][n + 1];

        // Build DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // Reconstruct the LCS
        int i = m;
        int j = n;
        StringBuilder lcs = new StringBuilder();

        while (i > 0 && j > 0) {
            if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                // Current characters are part of LCS
                lcs.insert(0, X.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                // Move to the left
                i--;
            } else {
                // Move to the top
                j--;
            }
        }

        return lcs.toString();
    }
}
