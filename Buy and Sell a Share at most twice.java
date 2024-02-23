class Solution {
    public static int maxProfit(int n, int[] price) {
        if (n <= 1)
            return 0;
        
        // Initialize variables to track the maximum profit after each buy and sell operation
        int buy1 = Integer.MIN_VALUE, sell1 = 0;
        int buy2 = Integer.MIN_VALUE, sell2 = 0;
        
        // Traverse the price array to update buy and sell variables for each transaction
        for (int i = 0; i < n; i++) {
            buy1 = Math.max(buy1, -price[i]); // Maximize profit or minimize cost for the first buy
            sell1 = Math.max(sell1, buy1 + price[i]); // Maximize profit for the first sell
            buy2 = Math.max(buy2, sell1 - price[i]); // Maximize profit or minimize cost for the second buy
            sell2 = Math.max(sell2, buy2 + price[i]); // Maximize profit for the second sell
        }
        
        // Return the maximum profit after two transactions
        return sell2;
    }
}
