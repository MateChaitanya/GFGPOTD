class Solution {

   String roundToNearest(String str) {
        // Complete the function
        int n = str.length()-1;
        char temp[] = str.toCharArray();
        if(temp[n]<='5'){
            temp[n]='0';
            return new String(temp);
        }
        temp[n]='0';
        n--;
        while(n>=0 && temp[n]=='9'){
            temp[n]='0';
            n--;
        }
        if(n==-1)return '1' + new String(temp);
        temp[n]+=1;
        return new String(temp);
    }
}
