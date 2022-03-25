package cm.wise.sky.integration.payments.upgrad;

public class LastStoneWeight {

    static int maxStoneWeightMH(int[] stones) {
        if (stones.length == 1) {
            return stones[0];
        }
        MaxHeap maxHeap = new MaxHeap(stones.length);
        for (int i = 0; i < stones.length; i++) {
            maxHeap.insert(stones[i]);
        }
        while (maxHeap.size > 1) {
            int x = maxHeap.extractMax();
            int y = maxHeap.extractMax();
            if (x != y) {
                maxHeap.insert(x - y);
            }
        }
        return maxHeap.size == 1 ? maxHeap.extractMax() : 0;
    }

    static int maxStoneWeightPQ(int[] stones) {
        PriorityQueue priorityQueue = new PriorityQueue(stones.length);
        for (int i = 0; i < stones.length; i++) {
            priorityQueue.enqueue(stones[i], stones[i]);
        }
        while (priorityQueue.size > 1) {
            int x = priorityQueue.top().value;
            priorityQueue.dequeue();
            int y = priorityQueue.top().value;
            priorityQueue.dequeue();
            if (x != y) {
                priorityQueue.enqueue(x - y, x - y);
            }
        }
        return priorityQueue.size == 1 ? priorityQueue.top().value : 0;
    }

    public static void main(String[] args) {
        int[] stones = {2, 7, 4, 1, 8, 1};
        System.out.println(maxStoneWeightPQ(stones));
        System.out.println(maxStoneWeightMH(stones));
    }
}
