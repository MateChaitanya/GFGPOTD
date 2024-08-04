public int maxMeetings(int n, int start[], int end[]) {
        // add your code here
        int temp[][] = new int[n][2];
        for(int i=0;i<n;i++){
            temp[i][0]=end[i];
            temp[i][1]=start[i];
        }
        Arrays.sort(temp,new Comparator<int[]>(){
            public int compare(int a[],int b[]){
                return a[0]-b[0];
            }
        });
        int ans = 1,last = temp[0][0];
        for(int i=1;i<n;i++){
            if(temp[i][1]>last){
                ans++;
                last=temp[i][0];
            }
        }
        return ans;
    }
