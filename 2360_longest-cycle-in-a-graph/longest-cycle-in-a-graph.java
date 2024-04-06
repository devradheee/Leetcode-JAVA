class Solution {
    public int longestCycle(int[] edges) {
        boolean[] vis = new boolean[edges.length];
        int ans= -1;
        for(int i=0;i<edges.length;i++)
        {
            if(!vis[i]){
                vis[i] = true;
                ans = Math.max(ans, findLength(i, edges, vis));
            }
        }

        return ans;
    }

    int findLength(int ind, int[] edges, boolean[] vis){
        int len = 0;
        int temp = ind;
        while(len < edges.length){
            len++;
            if(temp == -1 || !vis[temp])
                return -1;
            if(edges[temp] == ind)
                return len;

            temp = edges[temp];
        }
        return -1;
    }
}