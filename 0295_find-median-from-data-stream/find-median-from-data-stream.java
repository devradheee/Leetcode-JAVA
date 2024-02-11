// package 0295_find-median-from-data-stream;

class MedianFinder {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

    public MedianFinder() {

    }

    public void addNum(int num) {
        if (maxHeap.size() == minHeap.size()) {
            minHeap.add(num);
            maxHeap.add(minHeap.remove());
        } else {
            maxHeap.add(num);
            minHeap.add(maxHeap.remove());
        }

    }

    public double findMedian() {

        if (maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }
        return maxHeap.peek() / 1.0;

    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */