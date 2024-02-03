// package 0496_next-greater-element-i;

class Solution {

    public int solve(int numberToFind, int arr[]) {
        int i = 0;
        while (arr[i] != numberToFind) {
            i++;
        }
        if (i == arr.length) {
            return -1;
        } else {
            int j = i + 1;
            while (j < arr.length) {
                if (arr[j] > numberToFind) {
                    return arr[j];
                }
                j++;
            }
        }
        return -1;
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = solve(nums1[i], nums2);
        }

        return nums1;

    }
}