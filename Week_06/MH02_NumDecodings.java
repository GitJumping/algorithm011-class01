package Week_06;

public class MH02_NumDecodings {
    public static void main(String[] args) {
        String[] str = {"12", "226"};
        for (String s : str) {
            System.out.println(numDecodings(s));
        }
    }
    public static int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n];
        if (n==0 || s.charAt(0)=='0'){ return 0;}
        dp[0] = 1;

        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == '0') {
                if (s.charAt(i - 1) == '0' || s.charAt(i - 1) > '2') {
                    return 0;
                } else {
                    if (i > 1) {
                        dp[i] = dp[i - 2];
                    } else {
                        dp[i] = 1;
                    }
                }
            } else if ((s.charAt(i) <= '6'
                    && s.charAt(i) >= '1'
                    && s.charAt(i - 1) == '2')
                    || s.charAt(i - 1) == '1') {
                if (i > 1) {
                    dp[i] = dp[i - 1] + dp[i - 2];
                } else {
                    dp[i] = dp[i - 1] + 1;
                }
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[n - 1];
    }
}

