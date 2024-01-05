class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
         int n = nums1.length, m = nums2.length;
        int len = n + m;

        int mid = (len % 2 == 0) ? (len - 1) / 2 : len / 2;
        // System.out.println(mid + "<----");

        int i = 0, j = 0;
        Integer val1 = null, val2 = null;
        while (i < n && j < m) {
            if (nums1[i] <= nums2[j]) {
                if (val1 == null && i + j == mid) val1 = nums1[i];
                if (val2 == null && i + j == mid + 1) val2 = nums1[i];
                // System.out.print("index " + (i + j) + "->" + nums1[i] + " ");
                i++;
            } else {
                if (val1 == null && i + j == mid) val1 = nums2[j];
                if (val2 == null && i + j == mid + 1) val2 = nums2[j];
                // System.out.print("index " + (i + j) + "->" + nums2[j] + " ");

                j++;
            }
        }
        for (; i < n; i++) {
            // System.out.print("index " + (i + j) + "->" + nums1[i] + " ");

            if (val1 == null && i + j == mid) val1 = nums1[i];
            if (val2 == null && i + j == mid + 1) val2 = nums1[i];
        }
        // System.out.println(j);
        for (; j < m; j++) {
            // System.out.print("index " + (i + j) + "->" + nums2[j] + " ");

            if (val1 == null && i + j == mid) val1 = nums2[j];
            if (val2 == null && i + j == mid + 1) val2 = nums2[j];
        }
        // System.out.println(val1 + " " + val2);

        if (len % 2 == 0) return ((val1 + val2) * 1.0) / 2;
        return (double)val1;
    }
}