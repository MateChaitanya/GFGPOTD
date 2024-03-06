class Solution {
    ArrayList<Integer> search(String pattern, String text) {
        ArrayList<Integer> res = new ArrayList<>();
        int q = 101;
        int d = 26;
        int M = pattern.length();
        int N = text.length();
        int p = 0;
        int t = 0;
        int h = 1;

        // Calculate h = pow(d, M-1) % q
        for (int i = 0; i < M - 1; i++) {
            h = (h * d) % q;
        }

        // Calculate the hash value of pattern and first window of text
        for (int i = 0; i < M; i++) {
            p = (d * p + pattern.charAt(i)) % q;
            t = (d * t + text.charAt(i)) % q;
        }

        // Slide the pattern over the text one by one
        for (int i = 0; i <= N - M; i++) {
            // Check if the hash values are equal
            if (p == t) {
                // Check for characters one by one
                int j = 0;
                for (j = 0; j < M; j++) {
                    if (text.charAt(i + j) != pattern.charAt(j)) {
                        break;
                    }
                }
                if (j == M) {
                    res.add(i + 1);
                }
            }
            if (i < N - M) {
                t = (d * (t - text.charAt(i) * h) + text.charAt(i + M)) % q;
                if (t < 0) {
                    t = t + q;
                }
            }
        }
        return res;
    }
}
