package cm.wise.sky.integration.payments.upgrad;

//https://leetcode.com/problems/maximum-subarray/
public class MaxSubArray {
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(solutionBF(nums));
        System.out.println(solutionDP(nums));
    }

    // Brut force solution with O(n2) time complexity
    public static int solutionBF(int[] nums) {

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int currentSum = 0;
            int j = i;
            while (j < nums.length) {
                currentSum += nums[j];
                j++;
                max = Math.max(currentSum, max);
            }
        }
        return max;
    }

    // Optimal DP solution with O(n) time complexity
    public static int solutionDP(int[] nums) {

        int maxCurrent = nums[0];
        int maxGlobal = maxCurrent;
        for (int i = 1; i < nums.length; i++) {
            maxCurrent = Math.max(nums[i], maxCurrent + nums[i]);
            maxGlobal = Math.max(maxGlobal, maxCurrent);
        }
        return maxGlobal;
    }
}
