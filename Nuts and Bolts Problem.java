class Solution {
    private static final char[] order = { '!', '#', '$', '%', '&', '*', '?', '@', '^' };

    void matchPairs(int n, char nuts[], char bolts[]) {
        // Sort nuts and bolts using the given order
        quickSort(nuts, bolts, 0, n - 1);
    }

    private void quickSort(char[] nuts, char[] bolts, int low, int high) {
        if (low < high) {
            // Choose the last character of bolts as pivot to partition nuts
            int pivotIndex = partition(nuts, low, high, bolts[high]);

            // Use the partitioned nuts to partition bolts
            partition(bolts, low, high, nuts[pivotIndex]);

            // Recursively sort the partitions
            quickSort(nuts, bolts, low, pivotIndex - 1);
            quickSort(nuts, bolts, pivotIndex + 1, high);
        }
    }

    private int partition(char[] array, int low, int high, char pivot) {
        int i = low;
        for (int j = low; j < high; j++) {
            if (array[j] == pivot) {
                swap(array, j, high);
                break;
            }
        }

        for (int j = low; j < high; j++) {
            if (compare(array[j], pivot) < 0) {
                swap(array, i, j);
                i++;
            }
        }
        swap(array, i, high);
        return i;
    }

    private void swap(char[] array, int i, int j) {
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private int compare(char a, char b) {
        int indexA = -1, indexB = -1;
        for (int i = 0; i < order.length; i++) {
            if (order[i] == a) indexA = i;
            if (order[i] == b) indexB = i;
            if (indexA != -1 && indexB != -1) break;
        }
        return Integer.compare(indexA, indexB);
    }
}
