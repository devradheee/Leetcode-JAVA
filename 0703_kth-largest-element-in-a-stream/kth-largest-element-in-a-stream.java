// package 0703_kth-largest-element-in-a-stream;

class KthLargest {
    List<Integer> num;
    int e;

    public KthLargest(int k, int[] nums) {
        e = k;
        num = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            num.add(i, nums[i]);
        }
    }

    public int add(int val) {
        num.add(val);
        Collections.sort(num);
        return num.get(num.size() - e);
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */