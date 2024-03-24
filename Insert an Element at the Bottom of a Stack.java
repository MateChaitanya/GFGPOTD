class Solution {
    public Stack<Integer> insertAtBottom(Stack<Integer> st, int x) {
        Stack<Integer> temp = new Stack<Integer>();
        
        while(!st.isEmpty()){
            temp.add(st.pop());
            }
            st.push(x);
            
            
        while(!temp.isEmpty()){
            st.add(temp.pop());
            
          
        }
        return st;
    }
}
