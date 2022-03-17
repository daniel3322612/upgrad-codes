package cm.wise.sky.integration.payments.upgrad;

import java.lang.reflect.Array;

public class Queue<T> {
    int front, rear, size;
    int capacity;
    T[] array;

    public Queue(Class<T> clazz, int capacity) {
        this.capacity = capacity;
        front = 0;
        size = 0;
        rear = capacity - 1;
        array = (T[]) Array.newInstance(clazz, capacity);
    }

    public boolean isFull() {
        return size == capacity;

    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void enqueue(T item) {
        if (isFull()) return;

        rear = (rear + 1) % this.capacity;
        array[rear] = item;
        size++;
    }

    public T dequeue() {
        if (isEmpty()) return null;

        T item = array[front];
        this.front = (front + 1) % capacity;
        this.size--;
        return item;
    }

    public T front() {
        if (isEmpty()) return null;

        return array[front];
    }

    // Method to get rear of queue
    public T rear() {
        if (isEmpty()) return null;

        return array[rear];
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>(Integer.class, 3);

        queue.enqueue(10);
        System.out.println("Front item is "
            + queue.front());
        queue.enqueue(20);
        System.out.println("Front item is "
            + queue.front());
        queue.enqueue(5);
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
