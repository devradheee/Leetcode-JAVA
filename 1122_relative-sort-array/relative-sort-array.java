class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int n=arr1.length;
        int[] ans=new int[n];
        int x=0;
        boolean[] check=new boolean[n];
        for(int i=0;i<arr2.length;i++){
            for(int j=0;j<n;j++){
                if(arr2[i]==arr1[j]){
                    ans[x++]=arr2[i];
                    check[j]=true;
                }
            }
        }
        int[] left=new int[n-x];
        int k=0;
        for(int i=0;i<n;i++){
            if(!check[i]){
                left[k++]=arr1[i];
            }
        }
        Arrays.sort(left);
        k=0;
        for(int i=0;i<left.length;i++){
            ans[x++]=left[k++];
        }
        return ans;
    }
}