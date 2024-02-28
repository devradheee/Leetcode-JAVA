package 0026_remove-duplicates-from-sorted-arrays;

public class remove-duplicates-from-sorted-array {
      
            public int removeDuplicates(int[] nums) {
                int count = 1;
                for (int i = 1; i < nums.length; i++) {
                    if (nums[i] != nums[i - 1]) {
                        nums[count] = nums[i];
                        count++;
                    }
                }
                return count;
            }
        }

