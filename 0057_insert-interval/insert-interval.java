package 0057_insert-interval;

public class insert-interval {
        class Solution {
            public int[][] insert(int[][] intervals, int[] newInterval) {
                List<int[]> mergedIntervals = new ArrayList<>();

                for (int[] interval : intervals) {

                    // Before the new interval
                    if (interval[1] < newInterval[0]) {
                        mergedIntervals.add(interval);
                    }
                    // After the new interval
                    else if (interval[0] > newInterval[1]) {
                        mergedIntervals.add(newInterval);
                        newInterval = interval; // Update newInterval to current, as it will be added in order
                                                // afterwards
                    }
                    // Overlapping intervals
                    else {
                        // Merge with newInterval by updating its start and end as needed
                        newInterval[0] = Math.min(newInterval[0], interval[0]);
                        newInterval[1] = Math.max(newInterval[1], interval[1]);
                    }
                }

                // Add the last interval, which is either the original newInterval or the one
                // merged with others
                mergedIntervals.add(newInterval);

                return mergedIntervals.toArray(new int[mergedIntervals.size()][2]);
            }
        } 
}
