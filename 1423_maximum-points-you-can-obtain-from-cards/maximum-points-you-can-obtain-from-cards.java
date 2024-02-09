class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int len = cardPoints.length;
        int st = len - k;
        int end = st;
        int sum = 0;
        int res = 0;
        for (int i = 0; i < k * 2; i++) {
            sum += cardPoints[end % len];
            if (i >= k - 1) {
                res = Math.max(res, sum);
                sum -= cardPoints[st % len];
                st++;
            }
            end++;
        }
        return res;
    }
}
