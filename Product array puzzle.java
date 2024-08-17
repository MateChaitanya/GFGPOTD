public static long[] productExceptSelf(int nums[]) {
        // code here
        long temp = 1,c=0;
        int n=nums.length,index=-1;
        for(int i=0;i<n;i++){
            if(nums[i]!=0)temp*=nums[i];
            else{
                c++;
                index=i;
            }
        }
        long ans[] = new long[n];
        if(c>1)return ans;
        if(c==1){
            ans[index]=temp;
            return ans;
        }
        for(int i=0;i<n;i++){
            ans[i]=temp/nums[i];
        }
        return ans;
    }
