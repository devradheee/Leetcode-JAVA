class Solution {

    static boolean bfs(int arr[][], int src, int color[]) {
        int n = arr.length;

        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        color[src] = 0;

        while (q.size() != 0) {
            int a = q.remove();
            int col = color[a];

            for (var x : arr[a]) {
                if (color[x] == -1) {
                    color[x] = (col == 1) ? 0 : 1;
                    q.add(x);
                } else {
                    if (color[x] == col)
                        return false;
                }
            }
        }
        return true;
    }

    public boolean isBipartite(int[][] arr) {
        int n = arr.length;

        int color[] = new int[n]; // this will act as the visited array
        Arrays.fill(color, -1);

        // if Graph is not disconnect then you can do a simple bfs with by adding any
        // node to the queue. But here we can have disconnected graph therefore we have
        // to check each and every node.

        for (int i = 0; i < n; i++) {
            if (color[i] == -1) {
                if (bfs(arr, i, color) == false)
                    return false;
            }
        }
        return true;
    }
}