class Solution {
    String printLargest(int n, String[] arr) {
        // Define a custom comparator to compare strings based on their concatenation
        Comparator<String> customComparator = new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                String ab = a + b;
                String ba = b + a;
                // Compare the concatenation of a and b to determine the order
                return ba.compareTo(ab);
            }
        };

        // Sort the array of strings using the custom comparator
        Arrays.sort(arr, customComparator);

        // Concatenate the sorted strings to form the largest possible number
        StringBuilder result = new StringBuilder();
        for (String s : arr) {
            result.append(s);
        }

        return result.toString();
    }
}
