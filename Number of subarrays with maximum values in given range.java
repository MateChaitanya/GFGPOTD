class Solution{
    
    static long countSubarrays(int a[], int n, int L, int R)  
    { 
        // Complete the function
        long co= 0; 
        int i = 0; 
        int j = 0; 
         int w=0; 
         while(j<n){
           if(a[j]>R){
                  w = 0; 
                  i = j+1; 
              }
              else if(a[j]>=L && a[j]<=R){
                  w = j- i+1;
              }
              co+=w ;
              j++;
         }
        return co;
        
        
    } 
}
