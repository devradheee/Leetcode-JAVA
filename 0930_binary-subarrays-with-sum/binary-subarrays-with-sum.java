class Solution {
    public int solve(int []nums, int k){
        if(k<0){
            return 0;
        }
        int s=0;
        int e=0;
        int sum=0;
        int ans=0;
        while(e<nums.length){
            sum+=nums[e];
            while(sum>k&&s<nums.length){
            sum-=nums[s];
                s++;
            }
            if(sum<=k){
                ans+=e-s+1;
                }
            e++;
        }
        return ans;
    }
    public int numSubarraysWithSum(int[] nums, int goal) {
       int x=solve(nums,goal);
       int y=solve(nums,goal-1);
       return x-y;
    }
}