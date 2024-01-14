class Solution {

    public int maxPoints(int[][] points) {
        int n = points.length;
        if (n == 1) return 1;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            double x1 = points[i][0], y1 = points[i][1];
            Map<Double, Integer> map = new HashMap<>();
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                double x2 = points[j][0], y2 = points[j][1];
                double dy = (y2 - y1), dx = (x2 - x1);
                double slope = dy / dx;
                map.put(slope, map.getOrDefault(slope, 1) + 1);
                ans = Math.max(ans, map.get(slope));
            }
        }

        return ans;
    }
}