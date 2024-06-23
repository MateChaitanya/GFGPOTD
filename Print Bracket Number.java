class Solution {
    ArrayList<Integer> bracketNumbers(String str) {
        ArrayList<Integer> result = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        int count = 1;

        for (char c : str.toCharArray()) {
            if (c == '(') {
                stack.push(count);
                result.add(count);
                count++;
            } else if (c == ')') {
                result.add(stack.pop());
            }
        }

        return result;
    }
}
