class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count1 = 0;
        int count2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count1 += 1;
            } else {
                count2 = Math.max(count1, count2);
                count1 = 0;
            }
        }
        return Math.max(count1, count2);
    }
}