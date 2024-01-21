// package 0724_binary-search;

class Solution {
    public int search(int[] nums, int target) {
        return binary(nums, target, 0, nums.length - 1);
    }

    public int binary(int a[], int x, int s, int e) {
        while (s <= e) {
            int m = s + (e - s) / 2;
            if (a[m] == x) {
                return m;
            }
            if (x < a[m]) {
                e = m - 1;
            } else {
                s = m + 1;
            }
        }
        return -1;
    }
}
