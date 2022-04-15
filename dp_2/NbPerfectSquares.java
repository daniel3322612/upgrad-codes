package cm.wise.sky.integration.payments.upgrad;

import java.util.Arrays;

// https://leetcode.com/problems/perfect-squares/
public class NbPerfectSquares {
    public static void main(String[] args) {
        System.out.println(solution1(12));
        System.out.println(solution2(12, 1));
    }

    // https://www.youtube.com/watch?v=HLZLwjzIVGo
    // https://lenchen.medium.com/leetcode-279-perfect-squares-d83cac919604
    public static int solution1(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, n);
        dp[0] = 0;

        for (int target = 1; target <= n; target++) {
            for (int s = 1; s * s <= target; s++) {
                int square = s * s;
                dp[target] = Math.min(dp[target], 1 + dp[target - square]);
            }
        }
        return dp[n];
    }

    //https://www.youtube.com/watch?v=-1sPGuS1WRg
    public static int solution2(int n, int sq) {
        if (n == 0) {
            return 0;
        }
        if (sq * sq > n) {
            return n;
        }
        int min = n;
        for (int i = sq; i * i <= n; i++) {
            int ans = solution2(n - (i * i), 1);
            min = Math.min(min, ans);
        }

        if (min == n) {
            return min;
        }
        return 1 + min;
    }
}
