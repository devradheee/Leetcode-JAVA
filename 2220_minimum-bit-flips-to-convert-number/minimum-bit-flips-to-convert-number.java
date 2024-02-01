// package 2220_minimum-bit-flips-to-convert-number;

class Solution {
    public int minBitFlips(int start, int goal) {
        int steps = 0;

        while (start > 0 || goal > 0) {
            if ((start & (1)) != (goal & (1))) {
                steps++;
            }
            start = start >> 1;
            goal = goal >> 1;
        }
        return steps;
    }
}