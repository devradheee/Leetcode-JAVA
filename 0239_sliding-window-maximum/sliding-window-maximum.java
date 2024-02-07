// package 0239_sliding-window-maximum;

class Solution {
    static class Pairs implements Comparable<Pairs> {
        int val;
        int idx;

        public Pairs(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }

        @Override
        public int compareTo(Pairs p) {
            return p.val - this.val;
        }
    }

    public int[] maxSlidingWindow(int[] array, int K) {
        int res[] = new int[array.length - K + 1];
        PriorityQueue<Pairs> pairs = new PriorityQueue<>();
        for (int i = 0; i < K; i++)
            pairs.add(new Pairs(array[i], i));
        res[0] = pairs.peek().val;
        for (int i = K; i < array.length; i++) {
            while (pairs.size() > 0 && pairs.peek().idx <= (i - K))
                pairs.remove();
            pairs.add(new Pairs(array[i], i));
            res[i - K + 1] = pairs.peek().val;
        }
        return res;
    }
}