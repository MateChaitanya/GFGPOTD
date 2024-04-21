class Solution {
    public int threeWayPartition(int[] array, int a, int b) {
        int start = 0, mid = 0, end = array.length - 1;

        while (mid <= end) {
            if (array[mid] < a) {
               
                swap(array, start, mid);
                start++;
                mid++;
            } 
            else if (array[mid] > b) {
              
                swap(array, mid, end);
                end--;
            } else {
              
                mid++;
            }
        }
        
        return 1; 
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
 }
