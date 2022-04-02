package cm.wise.sky.integration.payments.upgrad;

import java.util.Stack;

//https://leetcode.com/problems/minimum-cost-tree-from-leaf-values/
public class MinCostTreeFromLeaves {
    static class Result {
        int maxMul;
        int sum;

        Result(int maxMul, int sum) {
            this.maxMul = maxMul;
            this.sum = sum;
        }
    }

    // Solution using a stack
    public int mctFromLeafValues2(int[] arr) {
        Stack<Integer> st = new Stack<>();
        st.push(Integer.MAX_VALUE);
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            while (st.peek() < arr[i]) {
                int t = st.peek();
                st.pop();
                ans += t * Math.min(st.peek(), arr[i]);
            }
            st.push(arr[i]);
        }
        while (st.size() > 2) {
            int t = st.peek();
            st.pop();
            ans += t * st.peek();
        }
        return ans;
    }

    // solution using dynamic programming
    public int mctFromLeafValues(int[] arr) {
        return solve(arr, 0, arr.length - 1, new Result[arr.length][arr.length]).sum;
    }

    public Result solve(int[] arr, int start, int end, Result[][] dp) {
        if (dp[start][end] != null) {
            return dp[start][end];
        }

        if (start > end) {
            return new Result(1, 0);
        }
        if (start == end) {
            return new Result(arr[start], 0);
        }

        Result min = null;
        for (int i = start; i < end; i++) {
            Result s1 = solve(arr, start, i, dp);
            Result s2 = solve(arr, i + 1, end, dp);

            Result tmp = new Result(Math.max(s1.maxMul, s2.maxMul), s1.sum + s2.sum + s1.maxMul * s2.maxMul);
            if (min == null || min.sum > tmp.sum) {
                min = tmp;
            }
        }
        dp[start][end] = min;
        return min;
    }

}
