// package 0503_next-greater-element-ii;

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int size = (n * 2) - 1, k = n - 1;
        Stack<Integer> stck = new Stack();
        int[] ans = new int[n];
        Arrays.fill(ans, -1);

        while (size >= 0) {
            int idx = size % n;

            while (!stck.isEmpty() && stck.peek() <= nums[idx])
                stck.pop();

            if (size < n) {
                if (!stck.isEmpty() && stck.peek() > nums[idx])
                    ans[k] = stck.peek();
                k--;
            }

            stck.push(nums[idx]);
            size--;
        }

        return ans;
    }
}