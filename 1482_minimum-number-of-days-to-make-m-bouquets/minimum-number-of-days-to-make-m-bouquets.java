class Solution {
    public boolean bloom(int []arr, int m, int k, int days){
        int count=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]<=days){
                count++;
            }
            if(count==k){
                m--;
                count=0;
            }
            if(arr[i]>days){
                count=0;
            }
        }
        if(m<=0){
        return true;
        }
        return false;
    }
    public int Days(int[] arr, int m, int k, int last){
        int s=1,l=last;
        int ans=-1;
        while(s<=l){
            int mid=(s+l)/2;
            // System.out.println(mid);
            if(bloom(arr,m,k,mid)){
                ans=mid;
                l=mid-1;
            }
            else{
                s=mid+1;
            }
        }
        return ans;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        int max=bloomDay[0];
        for(int i=1;i<bloomDay.length;i++){
            max=Math.max(max,bloomDay[i]);
        }
        return Days(bloomDay,m,k,max);
    }
}