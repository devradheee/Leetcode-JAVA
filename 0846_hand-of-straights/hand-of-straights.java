// package 0846_hand-of-straights;

class Solution {

    public boolean isNStraightHand(int[] hand, int groupSize) {

        int n = hand.length;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] > b[0])
                return 1;
            else
                return -1;
        });
        HashMap<Integer, Integer> map = new HashMap();
        for (int l : hand)
            map.put(l, map.getOrDefault(l, 0) + 1);
        for (int k : map.keySet())
            pq.add(new int[] { k, map.get(k) });
        if (n % groupSize != 0)
            return false;
        int gs = n / groupSize;

        for (int i = 0; i < gs; i++) {
            List<int[]> list = new LinkedList();
            int curr = 0;
            for (int j = 0; j < groupSize; j++) {
                int[] temp;
                if (pq.size() > 0)
                    temp = pq.poll();
                else
                    return false;

                if (j != 0)
                    if (temp[0] != curr + 1)
                        return false;

                if (temp[1] > 1)
                    list.add(new int[] { temp[0], temp[1] - 1 });

                curr = temp[0];

            }
            for (int[] a : list) {
                pq.add(a);
            }
        }
        return true;

    }
}