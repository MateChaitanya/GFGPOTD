class Solution {
    
    // Function for finding maximum and value pair
    public static int[] game_with_number (int arr[], int n) {
        // Modify the array elements in-place
        for (int i = 0; i < n - 1; i++) {
            arr[i] = arr[i] | arr[i + 1];
        }
        
        return arr;
    }
    
    // Sample test cases
    public static void main(String[] args) {
        int[] arr1 = {10, 11, 1, 2, 3};
        int[] arr2 = {5, 9, 2, 6};
        
        int n1 = 5;
        int n2 = 4;
        
        int[] result1 = game_with_number(arr1, n1);
        int[] result2 = game_with_number(arr2, n2);
        
        System.out.print("Output 1: ");
        for (int num : result1) {
            System.out.print(num + " ");
        }
        System.out.println();
        
        System.out.print("Output 2: ");
        for (int num : result2) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
