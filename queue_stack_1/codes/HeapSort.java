package cm.wise.sky.integration.payments;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {4, 10, 5, 3, 7};
        sort(arr);
    }

    public static void sort(int[] arr) {
        int n = arr.length;

        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, i, n);
        }

        // One by one extract an element from heap
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            swap(arr, 0, i);
            // call max heapify on the reduced heap
            heapify(arr, 0, i);
        }
    }

    private static void heapify(int[] arr, int pos, int size) {
        int largest = pos; // Initialize largest as root
        int left = 2 * pos + 1;
        int right = 2 * pos + 2;

        if (left < size && arr[left] > arr[largest]) {
            largest = left;
        }
        // If right child is larger than largest so far
        if (right < size && arr[right] > arr[largest]) {
            largest = right;
        }
        if (largest != pos) {
            swap(arr, pos, largest);
            // Recursively heapify the affected sub-tree
            heapify(arr, largest, size);
        }

    }

    private static void swap(int[] heap, int fpos, int spos) {
        int tmp;
        tmp = heap[fpos];
        heap[fpos] = heap[spos];
        heap[spos] = tmp;
    }
}
