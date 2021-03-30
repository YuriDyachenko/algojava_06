package kurs;

public class HeapSortString {
    private static int heapSize;

    public static void sort(String[] a) {
        buildHeap(a);
        while (heapSize > 1) {
            swap(a, 0, heapSize - 1);
            heapSize--;
            heapify(a, 0);
        }
    }

    private static void buildHeap(String[] a) {
        heapSize = a.length;
        for (int i = a.length / 2; i >= 0; i--) {
            heapify(a, i);
        }
    }

    private static void heapify(String[] a, int i) {
        int l = left(i);
        int r = right(i);
        int largest = i;
        if (l < heapSize && a[i].compareTo(a[l]) < 0) {
            largest = l;
        }
        if (r < heapSize && a[largest].compareTo(a[r]) < 0) {
            largest = r;
        }
        if (i != largest) {
            swap(a, i, largest);
            heapify(a, largest);
        }
    }

    private static int right(int i) {
        return 2 * i + 2;
    }

    private static int left(int i) {
        return 2 * i + 1;
    }

    private static void swap(String[] a, int i, int j) {
        String temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
