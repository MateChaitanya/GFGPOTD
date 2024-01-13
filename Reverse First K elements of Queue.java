class GfG {
    // Function to reverse the first k elements of a queue.
    public Queue<Integer> modifyQueue(Queue<Integer> q, int k) {

        Stack<Integer> st = new Stack<>();
        int shift = k;

        // Push the first k elements into the stack
        while (k > 0) {
            st.push(q.peek());
            q.remove();
            k--;
        }

        // Enqueue elements from the stack back to the queue
        while (!st.isEmpty()) {
            q.add(st.peek());
            st.pop();
        }

        // Shift the remaining elements in the queue
        int temp = q.size() - shift;
        while (temp > 0) {
            q.add(q.peek());
            q.remove();
            temp--;
        }

        return q;
    }
}
