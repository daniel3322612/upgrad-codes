package cm.wise.sky.integration.payments.upgrad;

public class PriorityQueue {
    static class Node {
        int value;
        int priority;

        Node(int value, int priority) {
            this.value = value;
            this.priority = priority;
        }

        @Override
        public String toString() {
            return "Node{" +
                "value=" + value +
                ", priority=" + priority +
                '}';
        }
    }

    Node[] array;
    int size;
    int capacity;

    PriorityQueue(int capacity) {
        this.capacity = capacity;
        array = new Node[capacity];
    }

    public void enqueue(int value, int priority) {
        if (size == capacity) {
            return;
        }
        array[size] = new Node(value, priority);
        size++;
    }

    public Node top() {
        int index = peek();
        if (index != -1) {
            return array[index];
        }
        return null;
    }

    public int peek() {
        if (size == 0) {
            return -1;
        }
        int highest = Integer.MIN_VALUE;
        int index = -1;
        for (int i = 0; i < size; i++) {
            // If priority is same choose,  the element with the highest value
            if (highest == array[i].priority
                && index > -1
                && array[index].value < array[i].value) {
                highest = array[i].priority;
                index = i;
            } else if (highest < array[i].priority) {
                highest = array[i].priority;
                index = i;
            }
        }
        return index;

    }

    public void dequeue() {
        int ind = peek();
        // Shift the element one index before
        // from the position of the element
        // with highest priority is found
        for (int i = ind; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;
    }

    public static void main(String[] args) {
        int[] stones = {2, 7, 4, 1, 8, 1};
        PriorityQueue priorityQueue = new PriorityQueue(4);

        priorityQueue.enqueue(4, 9);
        priorityQueue.enqueue(3, 4);
        priorityQueue.enqueue(2, 7);
        priorityQueue.enqueue(8, 6);

        System.out.println(priorityQueue.top());

        priorityQueue.dequeue();
        System.out.println(priorityQueue.top());

        priorityQueue.dequeue();
        System.out.println(priorityQueue.top());

        priorityQueue.enqueue(90, 12);
        System.out.println(priorityQueue.top());

    }
}
