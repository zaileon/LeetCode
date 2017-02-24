import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class MedianFinder {

	Queue<Integer> large, small;
	
	public MedianFinder() {
		large = new PriorityQueue<Integer>();
		small = new PriorityQueue<Integer>(Collections.reverseOrder());
	}
	
	public void addNum(int num) {
		large.offer(num);
		small.offer(large.poll());
		if (large.size() < small.size()) large.offer(small.poll());
	}
	
	public double findMedian() {
		if (small.size() == large.size()) return (large.peek() + small.peek()) / 2.0;
		else return large.peek();
	}
	
	public static void main(String[] args) {
		MedianFinder mf = new MedianFinder();
		mf.addNum(2);
		System.out.println(mf.findMedian());
		mf.addNum(3);
		System.out.println(mf.findMedian());
	}
}
