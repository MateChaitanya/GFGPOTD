  public boolean canSplit(int arr[]) {
        // code here
        int sum = 0,firstSum=0;
        for(int x:arr)sum+=x;
        for(int x:arr){
            sum-=x;
            firstSum+=x;
            if(firstSum==sum)return true;
        }
        return false;
    }
