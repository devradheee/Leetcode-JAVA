package 0055_jump-game;

class Solution {
    public boolean canJump(int[] arr) {
        int target = arr.length - 1;

        if (arr.length == 1)
            return true;

        int i = arr.length - 2;
        while (i >= 0) {
            if (arr[i] >= (target - i)) {
                target = i;
            }
            i--;
        }

        return target == 0;
    }
}