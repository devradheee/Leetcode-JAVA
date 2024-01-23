class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        Set<List<Integer>> s = new HashSet<>();
        List<List<Integer>> output = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if(i>0&&nums[i]==nums[i-1]) continue;
            for (int j = i + 1; j < nums.length; j++) {
                if(j!=i+1&&nums[j]==nums[j-1]) continue;
                int k = j + 1;
                int l = nums.length - 1;
                while (k < l) {
                   long g=nums[k];
                   g+=nums[l];
                   long v=target;
                   v-=nums[i];
                   v-=nums[j];
                    if (g == v) {
              
            s.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        k++;
                        l--;
                        while(k<nums.length&&nums[k]==nums[k-1]) k++;
                        while(l>=0&&nums[l]==nums[l+1]) l--;
                    }
            else if (g < v) {
               
                        k++;
                     while(k<nums.length&&nums[k]==nums[k-1]) k++;
                    } else {

                        l--;
                         while(l>=0&&nums[l]==nums[l+1]) l--;
                    }
                }
            }
        }
        output.addAll(s);
        return output;
    }
}