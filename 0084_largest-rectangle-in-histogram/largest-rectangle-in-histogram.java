// package 0084_largest-rectangle-in-histogram;

class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights.length == 0)
            return 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxArea = 0;
        for (int i = 0; i <= heights.length; i++) {
            int cur = i == heights.length ? 0 : heights[i];
            while (stack.peek() != -1 && cur < heights[stack.peek()]) {
                maxArea = Math.max(maxArea, heights[stack.pop()] * (i - stack.peek() - 1));
            }
            stack.push(i);
        }
        return maxArea;
    }
}