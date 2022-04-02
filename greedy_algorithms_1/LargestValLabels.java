package cm.wise.sky.integration.payments.upgrad;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/largest-values-from-labels/
public class LargestValLabels {
    public static int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        int n = values.length;
        int[][] tuple = new int[n][2];
        for (int i = 0; i < n; i++) {
            tuple[i][0] = values[i];
            tuple[i][1] = labels[i];
        }

        Arrays.sort(tuple, (a, b) -> b[0] - a[0]);

        Map<Integer, Integer> map = new HashMap<>();

        int numbers = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int val = tuple[i][0];
            int usedTimes = map.getOrDefault(tuple[i][1], 0);
            if (usedTimes < useLimit) {
                sum += val;
                map.put(tuple[i][1], usedTimes + 1);
                numbers++;
            }
            if (numbers >= numWanted) {
                break;
            }
        }
        return sum;
    }

    // Using a priority queue
    public static int largestValsFromLabels2(int[] values, int[] labels, int numWanted, int useLimit) {
        PriorityQueue queue = new PriorityQueue(values.length);
        int n = values.length;
        for (int i = 0; i < n; i++) {
            queue.enqueue(labels[i], values[i]);
        }
        int numbers = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        while (!queue.isEmpty() && numbers < numWanted) {
            PriorityQueue.Node max = queue.top();
            queue.dequeue();
            int usedTimes = map.getOrDefault(max.value, 0);
            if (usedTimes < useLimit) {
                sum += max.priority;
                map.put(max.value, usedTimes + 1);
                numbers++;
            }
        }
        return sum;

    }
        public static void main (String[]args){
            int[] values = {9,8,8,7,6};
            int[] labels = {0,0,0,1,1};
            int numWanted = 3;
            int useLimit = 1;
            System.out.println(largestValsFromLabels(values, labels, numWanted, useLimit));
            System.out.println(largestValsFromLabels2(values, labels, numWanted, useLimit));
        }
    }
