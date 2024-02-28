class Solution {
    int DivisibleByEight(String s) {
        
        if (s.length() < 3) {
            int num = Integer.parseInt(s);
            if (num % 8 == 0) {
                return 1;
            } else {
                return -1;
            }
        }
        
        int n = s.length();
        int lastThreeDigits = Integer.parseInt(s.substring(n - 3));

        if (lastThreeDigits % 8 == 0) {
            return 1;
        }

        char[] chars = s.substring(n - 3).toCharArray();
        boolean[] used = new boolean[3];
        return generatePermutations(chars, used, 0) ? 1 : -1;
    }

    boolean generatePermutations(char[] chars, boolean[] used, int length) {
        if (length == 3) {
            int num = Integer.parseInt(new String(chars));
            return num % 8 == 0;
        }

        for (int i = 0; i < 3; i++) {
            if (!used[i]) {
                used[i] = true;
                if (generatePermutations(chars, used, length + 1)) {
                    return true;
                }
                used[i] = false;
            }
        }

        return false;
    }
}
