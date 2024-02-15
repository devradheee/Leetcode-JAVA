public class non-overlapping-intervals {
    public int eraseOverlapIntervals(int[][] intervals) {;
        Arrays.sort(intervals,(a,b)->a[1]-b[1]);
        Stack<int[]> stk = new Stack<>();
        int res=0;
        for(int[] i : intervals){
            if(!stk.isEmpty() && i[0]< stk.peek()[1]){
                res++;
            }else{
                stk.push(i);
            }
        }

    return res;
    }
}
}
