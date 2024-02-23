class Solution {

    static class Pair {
        int i;
        int j;
        int time;

        public Pair(int x, int y, int time) {
            this.i = x;
            this.j = y;
            this.time = time;
        }

        public int getI() {
            return i;
        }

        public int getY() {
            return j;
        }

        public int getTime() {
            return time;
        }
    }

    public static int orangesRotting(int[][] grid) {

        Queue<Pair> rottenQ = new LinkedList<Pair>();
        int time = 0;
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    rottenQ.add(new Pair(i, j, time));
                }
            }
        }

        Pair p = new Pair(0, 0, 0);

        while (!rottenQ.isEmpty()) {
            p = rottenQ.poll();

            int x = p.getI();
            int y = p.getY();
            int t = p.getTime();

            if (x - 1 >= 0 && grid[x - 1][y] == 1) {
                grid[x - 1][y] = 2;
                rottenQ.add(new Pair(x - 1, y, t + 1));
            }
            if (x + 1 < m && grid[x + 1][y] == 1) {
                grid[x + 1][y] = 2;
                rottenQ.add(new Pair(x + 1, y, t + 1));
            }
            if (y - 1 >= 0 && grid[x][y - 1] == 1) {
                grid[x][y - 1] = 2;
                rottenQ.add(new Pair(x, y - 1, t + 1));
            }
            if (y + 1 < n && grid[x][y + 1] == 1) {
                grid[x][y + 1] = 2;
                rottenQ.add(new Pair(x, y + 1, t + 1));
            }
        }

        for (int[] ints : grid) {
            for (int j = 0; j < grid[0].length; j++) {
                if (ints[j] == 1) {
                    return -1;
                }
            }
        }
        return p.getTime();
    }
}