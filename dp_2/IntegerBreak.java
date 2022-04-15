package cm.wise.sky.integration.payments.upgrad;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/integer-break/
public class IntegerBreak {
    public static void main(String[] args) {

        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(1, 1);
        System.out.println(integerBreak(12, 12, dp));

        System.out.println(integerBreak(12));
        System.out.println(integerBreak(12, 12));
    }
    //https://www.youtube.com/watch?v=m0OFK5LeEyw
    public static int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                int a = (i - j) * j;
                int b = dp[i - j] * j;
                int c = dp[i];
                dp[i] = Math.max(Math.max(a, b), c);
            }
        }
        return dp[n];
    }


    public static int integerBreak(int n, int num) {
        if (n == 1) {
            return 1;
        }
        int result = num == n ? 0 : num;

        for (int i = 1; i < num; i++) {
            int val = integerBreak(n, i) * integerBreak(n, num - i);
            result =  Math.max(result, val);
        }
        return result;
    }

    //https://www.youtube.com/watch?v=in6QbUPMJ3I
    public static int integerBreak(int n, int num, Map<Integer, Integer> dp) {
        if (dp.containsKey(num)) {
            return dp.get(num);
        }

        dp.put(num, num == n ? 0 : num);

        for (int i = 1; i < num; i++) {
            int val = integerBreak(n, i, dp) * integerBreak(n, num - i, dp);
            dp.put(num, Math.max(dp.get(num), val));
        }
        return dp.get(num);
    }
}
