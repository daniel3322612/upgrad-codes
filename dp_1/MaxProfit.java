package cm.wise.sky.integration.payments.upgrad;

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
public class MaxProfit {
    public static void main(String[] args) {

        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(solutionBF(prices));
        System.out.println(solutionDP(prices));
    }

    // Brut force solution with O(n2) time complexity
    public static int solutionBF(int[] prices) {
        int globalMax = 0;
        for (int buy = 0; buy < prices.length; buy++) {
            int currentMax = 0;
            for (int sell = buy + 1; sell < prices.length; sell++) {
                currentMax = Math.max(currentMax, prices[sell] - prices[buy]);
            }
            globalMax = Math.max(globalMax, currentMax);
        }
        return globalMax;
    }

    // Optimal DP solution with O(n) time complexity
    public static int solutionDP(int[] prices) {
        int globalMax = 0;
        int buy = 0;
        int sell = 1;
        while (sell < prices.length) {
            if (prices[buy] < prices[sell]) {
                globalMax = Math.max(globalMax, prices[sell] - prices[buy]);
            } else {
                buy = sell;
            }
            sell++;
        }
        return globalMax;
    }
}
