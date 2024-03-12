class Solution {
    static long[][] help(long m, long[][] mat1, long[][] mat2){
        int size = mat1.length;
        long[][] ans = new long[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < size; k++) {
                    ans[i][j] += (mat1[i][k] % m * mat2[k][j] % m) % m;
                    ans[i][j] %= m;
                }
            }
        }
        return ans;
    } 
    
    static long genFibNum(long a, long b, long c, long n, long m) {
        // code here
        if(n==1 || n==2) return 1%m;
        long[][] relation = {{a,b,c},{1,0,0},{0,0,1}};
        long[][] result = {{1,0,0},{0,1,0},{0,0,1}};
        n-=2;
        while(n > 0){
            if((n & 1) == 1){
                result = help(m, relation, result);
            }
            relation = help(m, relation, relation);
            n >>= 1;
        }
        return (result[0][0] + result[0][1] + result[0][2]) % m;
    }
}
