class Solution{
    static String smallestNumber(int S, int D){
        // If the sum S is greater than the maximum possible sum for D digits
        if(S > D * 9 || S < 1) return "-1";
        
        char[] ans = new char[D];
        
        // Decrease S by 1 to ensure we can fill the leading digit properly
        S -= 1;
        
        // Start filling the digits from the end
        for(int i = D - 1; i > 0; i--) {
            if(S >= 9) {
                ans[i] = '9';
                S -= 9;
            } else {
                ans[i] = (char)(S + '0');
                S = 0;
            }
        }
        
        // Place the remaining value in the first digit and increment it by 1
        ans[0] = (char)(S + '1');
        
        return new String(ans);
    }
}
