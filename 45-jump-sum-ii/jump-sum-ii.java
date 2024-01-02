class Solution {
    public int jump(int[] nums) {
        int step = 0, next = 0, destination = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            next = Math.max(next, nums[i] + i);
            if (i == destination) {
                step++;
                destination = next;
            }
        }
        return step;
    }
}