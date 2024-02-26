// package 0213_house-robber-ii;

class Solution {

    public int rob(int[] nums) {
        int n = nums.length;
        int start = 0;
        int sec = 0;
        if (n == 1) {
            return nums[0];
        }
        for (int i = 0; i < n - 1; i++) {
            int temp = Math.max(sec, start + nums[i]);
            start = sec;
            sec = temp;
        }
        int max = sec;
        start = 0;
        sec = 0;
        for (int i = 1; i < n; i++) {
            int temp = Math.max(sec, start + nums[i]);
            start = sec;
            sec = temp;
        }
        return Math.max(max, sec);
    }
}
