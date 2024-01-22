class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int l=0,r=0;
        for(int w : weights){
            l = Math.max(w,l);
            r += w;
        }
        while(l<=r)
        {
            int mid = l + (r-l)/2;
            if(checkLimit(weights,days,mid))
                r=mid-1;
            else
                l=mid+1;
        }
        return l;
    }

    public boolean checkLimit(int[] weights, int days, int limit)
    {
        int sum=0;
        int count=1;
        for(int i=0;i<weights.length;i++)
        {   
            if(count > days) return false;
            if(sum+weights[i]>limit)
            {
                count+=1;
                sum=0;
            }    
            sum+=weights[i];
        }
        return (days>=count);
    }   
}