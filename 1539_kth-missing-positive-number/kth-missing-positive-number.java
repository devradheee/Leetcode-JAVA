// package 1539_kth-missing-positive-number;
class Solution {
    public int findKthPositive(int[] arr, int k) {
        int missingNum = 1;
        int numOrder = 1;
        int size = Math.max(arr.length, (arr.length + k));
        for (int i = 0; i < size; i++) {
            if (i > arr.length - 1) {
                if (k == missingNum) {
                    return numOrder;
                }
                numOrder++;
                missingNum++;
            } else if (arr[i] == numOrder) {
                numOrder++;
            } else {
                if (k == missingNum) {
                    return numOrder;
                }
                numOrder++;
                missingNum++;
                i--;
            }
        }
        return numOrder;
    }
}