class Solution {
    public boolean isAdditiveSequence(String num) {
        int n = num.length();
        if (n < 3) return false;
        for (int i = 1; i <= n / 2; i++) {
            for (int j = 1; Math.max(i, j) <= n - i - j; j++) {
                String first = num.substring(0, i);
                String second = num.substring(i, i + j);
                
                if (first.length() > 1 && first.charAt(0) == '0') break;
                if (second.length() > 1 && second.charAt(0) == '0') break;
                
                int start = i + j;
                String sum;
                while (start < n) {
                    sum = addStrings(first, second);
                    if (start + sum.length() > n || !sum.equals(num.substring(start, start + sum.length()))) {
                        break;
                    }
                    first = second;
                    second = sum;
                    start += sum.length();
                }
                if (start == n) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private String addStrings(String num1, String num2) {
        StringBuilder sb1 = new StringBuilder(num1).reverse();
        StringBuilder sb2 = new StringBuilder(num2).reverse();

        StringBuilder res = new StringBuilder();
        int carry = 0;
        int i = 0;
        while (i < Math.min(sb1.length(), sb2.length())) {
            int x = carry;
            x += sb1.charAt(i) - '0';
            x += sb2.charAt(i) - '0';
            carry = x / 10;
            x = x % 10;
            res.append(x);
            i++;
        }
        while (i < sb1.length()) {
            int x = carry;
            x += sb1.charAt(i) - '0';
            carry = x / 10;
            x = x % 10;
            res.append(x);
            i++;
        }
        while (i < sb2.length()) {
            int x = carry;
            x += sb2.charAt(i) - '0';
            carry = x / 10;
            x = x % 10;
            res.append(x);
            i++;
        }
        while (carry != 0) {
            int x = carry;
            carry = x / 10;
            x = x % 10;
            res.append(x);
        }
        return res.reverse().toString();
    }
}
