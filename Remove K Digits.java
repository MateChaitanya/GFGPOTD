class Solution {
    public String removeKdigits(String S, int K) {
        int n = S.length();

        if (n == K) {
            return "0";
        }

        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (char digit : S.toCharArray()) {
            while (K > 0 && result.length() > 0 && result.charAt(result.length() - 1) > digit) {
                result.deleteCharAt(result.length() - 1);
                K--;
            }

            if (result.length() != 0 || digit != '0') {
                result.append(digit);
            }
        }

        while (K > 0 && result.length() > 0) {
            result.deleteCharAt(result.length() - 1);
            K--;
        }

        return result.length() == 0 ? "0" : result.toString();
    }
}
