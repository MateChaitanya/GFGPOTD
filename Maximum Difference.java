 public int findMaxDiff(int[] arr) {
        // code here
        int n = arr.length;
        int left[] = new int[n];
        int right[] = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<n;i++){
            while(!st.empty() && st.peek()>=arr[i])st.pop();
            if(!st.empty())left[i]=st.peek();
            else left[i]=0;
            st.push(arr[i]);
        }
        while(!st.empty())st.pop();
        for(int i=n-1;i>=0;i--){
            while(!st.empty() && st.peek()>=arr[i])st.pop();
            if(!st.empty())right[i]=st.peek();
            else right[i]=0;
            st.push(arr[i]);
        }
        int ans = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            ans = Math.max(ans,Math.abs(left[i]-right[i]));
        }
        return ans;
    }
