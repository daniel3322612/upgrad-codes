package cm.wise.sky.integration.payments.upgrad;

public class MaxHeap {
    int[] heap;
    int size;
    int maxSize;

    public MaxHeap(int maxSize) {
        this.maxSize = maxSize;
        this.heap = new int[maxSize];
        this.size = 0;
    }

    public void insert(int element) {
        if (size == maxSize) {
            return;
        }
        heap[size] = element;

        // Traverse up and fix violated property
        int current = size;
        while (heap[current] > heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
        size++;
    }

    public int extractMax() {
        if (size == 0) {
            return -1;
        }

        int popped = heap[0];
        heap[0] = heap[--size];
        heapify(0);
        heap[size] = 0;
        return popped;
    }

    public void print() {
        for (int i = 0; i < size / 2; i++) {
            System.out.print("Parent Node : " + heap[i]);
            if (leftChild(i) < size) //if the child is out of the bound of the array
                System.out.print(" Left Child Node: " + heap[leftChild(i)]);

            if (rightChild(i) < size) //if the right child index must not be out of the index of the array
                System.out.print(" Right Child Node: " + heap[rightChild(i)]);

            System.out.println(); //for new line
        }
    }

    private int parent(int pos) {
        return (pos - 1) / 2;
    }

    private int leftChild(int pos) {
        return (2 * pos) + 1;
    }

    private int rightChild(int pos) {
        return (2 * pos) + 2;
    }

    private boolean isLeaf(int pos) {
        return pos > (size / 2) && pos <= size;
    }

    private void swap(int fpos, int spos) {
        int tmp;
        tmp = heap[fpos];
        heap[fpos] = heap[spos];
        heap[spos] = tmp;
    }

    private void heapify(int pos) {
        if (isLeaf(pos))
            return;

        //If any child of the current node is greater, then we should swap
        int leftChild = leftChild(pos);
        int rightChild = rightChild(pos);
        if ((isBound(leftChild) && heap[pos] < heap[leftChild])
            || (isBound(rightChild) && heap[pos] < heap[rightChild])) {
            //Decide which of the two children should be swapped with current node
            if (heap[leftChild] > heap[rightChild]) {
                swap(pos, leftChild(pos));
                heapify(leftChild(pos));
            } else {
                swap(pos, rightChild(pos));
                heapify(rightChild(pos));
            }
        }
    }

    private boolean isBound(int position) {
        return position >= 0 && position < maxSize;
    }



    public static void main(String[] args) {
        int[] stones = {2, 7, 4, 1, 8, 1};

        MaxHeap maxHeap = new MaxHeap(9);

        // Inserting nodes
        // Custom inputs
        maxHeap.insert(5);
        maxHeap.insert(3);
        maxHeap.insert(17);
        maxHeap.insert(10);
        maxHeap.insert(84);
        maxHeap.insert(19);
        maxHeap.insert(6);
        maxHeap.insert(22);
        maxHeap.insert(9);

        // Calling maxHeap() as defined above
        maxHeap.print();

        // Print and display the maximum value in heap
        System.out.println("The max val is "
            + maxHeap.extractMax());

        maxHeap.print();
    }
}
