class Solution {
    public String printString(String s, char ch, int count) {
        int occurrenceCount = 0;
        int n = s.length();
        
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == ch) {
                occurrenceCount++;
            }
            
            if (occurrenceCount == count) {
                if (i + 1 < n) {
                    return s.substring(i + 1);
                } else {
                    return "";
                }
            }
        }
        
        return "";
    }
}
