class Solution {

    static List<List<Integer>> ans;
    static void helper(int arr[], int idx, int target, List<Integer> a){
        if(target==0){
            ans.add(new ArrayList<>(a));
            return;
        }
        if(idx>=arr.length || target<0) return;

        a.add(arr[idx]);
        helper(arr,idx,target-arr[idx],a);
        a.remove(a.size()-1);
        helper(arr,idx+1,target,a);
    }
    public List<List<Integer>> combinationSum(int[] arr, int target) {
        ans = new ArrayList<>();
        helper(arr,0,target,new ArrayList<>());
        return ans;
    }
}