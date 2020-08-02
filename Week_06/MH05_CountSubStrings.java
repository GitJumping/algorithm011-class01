package Week_06;

public class MH05_CountSubStrings {
    public static void main(String[] args) {
        String[] s = {"abc", "aaa"};
        for (String st : s) {
            System.out.println(countSubstrings(st));
        }
    }
    public static int countSubstrings(String s) {
        if (s == null || s.equals("")) {
            return 0;
        }

        boolean[][] dp = new boolean[s.length()][s.length()];

        for (int i = 0; i < s.length(); i++) dp[i][i] = true;

        int result = s.length();

        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i == 1) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                } else {
                    dp[i][j] = false;
                }
                if (dp[i][j]) {
                    result++;
                }
            }
        }

        return result;
    }
}
