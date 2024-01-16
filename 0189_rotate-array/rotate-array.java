class Solution {
    public void rotate(int[] nums, int k) {
        Queue<Integer> que = new LinkedList<>();
        int n = nums.length;

        // Ensure k is within the valid range
        k = k % n;

        // put in the queue last k elements
        for (int i = n - k; i < n; i++) {
            que.add(nums[i]);
        }

        // put in the queue first n-k elements
        for (int i = 0; i < n - k; i++) {
            que.add(nums[i]);
        }

        // Dequeue elements from the queue and update the original array
        for (int j = 0; j < n; j++) {
            nums[j] = que.remove();
        }
    }
}