package sort;

public class HeapVisualizer {

    public static void printHeapTree(int[] heap) {
        printHeapTree(heap, 0, 0);
    }

    private static void printHeapTree(int[] heap, int index, int level) {
        if (index >= heap.length) {
            return;
        }

        // Print right child
        printHeapTree(heap, 2 * index + 2, level + 1);

        // Print current node
        for (int i = 0; i < level; i++) {
            System.out.print("   ");
        }
        System.out.println(heap[index]);

        // Print left child
        printHeapTree(heap, 2 * index + 1, level + 1);
    }

    public static void main(String[] args) {
        int[] heap = {0, 2, 1, 3, 4, 6, 15, 9, 5};
        printHeapTree(heap);
    }
}
