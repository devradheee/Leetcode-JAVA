class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;

        //Step2: Calculate the actual sum using Mathematical formulae
        long actualSum = (n*(n+1))/2;

        //Step3: Calculate the given sum.
        long sum = 0;
        for(int element: nums)
        {
            sum += element;
        }

        //Step 4: return actualSum-givenSum.
        return (int)(actualSum-sum);
    }
}