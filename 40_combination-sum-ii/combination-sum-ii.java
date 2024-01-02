class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        Arrays.sort(candidates);
        helper(candidates,0,target,ans,new ArrayList<Integer>());
        return ans;
    }
    void helper(int arr[],int ind,int target,List<List<Integer>> ans,ArrayList<Integer> ds){
        if(target==0){
            ans.add(new ArrayList<>(ds));
            return;
        }
        for(int i=ind; i<arr.length; i++){
            if(i>ind && arr[i]==arr[i-1]) continue;
            if(arr[i]>target) break;
            ds.add(arr[i]);
            helper(arr,i+1,target-arr[i],ans,ds);
            ds.remove(ds.size()-1);
        }
    }
}