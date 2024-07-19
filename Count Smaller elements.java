class Solution {
    public int countSpecialNumbers(int N, int arr[]) {
        // Code here
        int mx = arr[0];
        for(int i = 1; i < N; i++) mx = Math.max(arr[i], mx);
        int special[] = new int[mx + 1];
        Arrays.fill(special, 0);
        for(int i = 0; i < N; i++) {
            if(special[arr[i]] < 2) {
                for(int j = arr[i]; j <= mx; j += arr[i]) special[j]++;
            }
        }
        int ans = 0;
        for(int x : arr) if(special[x] > 1) ans++;
        return ans;
    }

    public int[] constructLowerArray(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        int[] indices = new int[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }
        mergeSort(arr, indices, result, 0, n - 1);
        return result;
    }

    private void mergeSort(int[] arr, int[] indices, int[] result, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSort(arr, indices, result, left, mid);
        mergeSort(arr, indices, result, mid + 1, right);
        merge(arr, indices, result, left, mid, right);
    }

    private void merge(int[] arr, int[] indices, int[] result, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int[] tempIndices = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0, count = 0;

        while (i <= mid && j <= right) {
            if (arr[indices[j]] < arr[indices[i]]) {
                count++;
                tempIndices[k] = indices[j];
                j++;
            } else {
                result[indices[i]] += count;
                tempIndices[k] = indices[i];
                i++;
            }
            k++;
        }

        while (i <= mid) {
            result[indices[i]] += count;
            tempIndices[k] = indices[i];
            i++;
            k++;
        }

        while (j <= right) {
            tempIndices[k] = indices[j];
            j++;
            k++;
        }

        for (i = left; i <= right; i++) {
            indices[i] = tempIndices[i - left];
        }
    }
}
