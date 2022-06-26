package autumnMovesMustWin;

public class test {
    public int countHousePlacements(int n) {
        int mod = (int) 1e9 + 7;
        Long[] dp = new Long[n + 1];
        dp[0] = 1L;
        long sum = 1L;
        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                dp[i] = 4L;
            } else {
                sum += dp[i - 2];
                sum = (sum % mod);
                dp[i] = ((dp[i-1] + dp[i-2] + 2*sum) % mod);
            }
        }
        sum = dp[n];
        return (int) sum;
    }
}

