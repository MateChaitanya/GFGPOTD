 public static int grayToBinary(int n) {
        
        // Your code here
        ArrayList<Integer> temp = new ArrayList<>();
        while(n!=0){
            if((n&1)==1)temp.add(1);
            else temp.add(0);
            n>>=1;
        }
        Collections.reverse(temp);
        for(int i=1;i<temp.size();i++){
            temp.set(i,temp.get(i-1)^temp.get(i));
        }
        int ans = 0,j=0;
        for(int i=temp.size()-1;i>=0;i--){
            if(temp.get(i)==1)ans+=Math.pow(2,j);
            j++;
        }
        return ans;
    }
