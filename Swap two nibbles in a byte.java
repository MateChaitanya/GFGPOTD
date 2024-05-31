class Solution {
    public int swapNibbles(int n) {
        // Extract the right nibble
        int rn = n & 0b11110000;
        // Extract the left nibble
        int ln = n & 0b00001111;

        // Shift the right nibble to the right
        rn = rn >> 4;
        // Shift the left nibble to the left
        ln = ln << 4;

        // Combine the shifted nibbles
        return rn | ln;
    }
}
