class Solution {
    public int findPeakElement(int[] arr) {
        int n = arr.length;
        int low=0, high=n-1,mid;
        if(n==1){
            return 0;
        }

        if(arr[low]>arr[low+1]){ 
            return low;
        }
        else if(arr[high]>arr[high-1]){
            return high; 
        }
        else{
            low++;
            high--;
        }
    
        while(low<=high){
            mid = (low+high)/2;
            if(arr[mid]>arr[mid-1] && arr[mid]>arr[mid+1]){
                return mid;
            }
            else if(arr[mid-1]>arr[mid]){
                if(arr[mid+1]>arr[mid] && arr[mid+1]!=arr[mid-1]){
                    return mid+1;
                }
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return -1;
    }
}