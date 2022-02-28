package cm.wise.sky.integration.payments;

public class Queue {
    int front, rear, size;
    int capacity;
    int array[];

    public Queue(int capacity) {
        this.capacity = capacity;
        front = 0;
        size = 0;
        rear = capacity - 1;
        array = new int[this.capacity];
    }

    public boolean isFull() {
        return size == capacity;

    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void enqueue(int item) {
        if (isFull()) return;

        rear = (rear + 1) % this.capacity;
        array[rear] = item;
        size++;
    }

    public int dequeue() {
        if (isEmpty()) return Integer.MIN_VALUE;

        int item = array[front];
        this.front = (front + 1) % capacity;
        this.size--;
        return item;
    }

    public int front() {
        if (isEmpty()) return Integer.MIN_VALUE;

        return array[front];
    }

    // Method to get rear of queue
    public int rear() {
        if (isEmpty()) return Integer.MIN_VALUE;

        return array[rear];
    }

    public static void main(String[] args) {
        Queue queue = new Queue(3);

        queue.enqueue(10);
        System.out.println("Front item is "
            + queue.front());
        queue.enqueue(20);
        System.out.println("Front item is "
            + queue.front());
        queue.enqueue(30);
        System.out.println("Front item is "
            + queue.front());
        queue.enqueue(40);
        System.out.println("Front item is "
            + queue.front());

        System.out.println(queue.dequeue()
            + " dequeued from queue\n");

        System.out.println("Front item is "
            + queue.front());

        System.out.println(queue.dequeue()
            + " dequeued from queue\n");

        System.out.println("Rear item is "
            + queue.rear());
    }
}
