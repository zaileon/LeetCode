import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigzagIterator {

	Queue<Iterator<Integer>> queue = new LinkedList<Iterator<Integer>>();;
	
	public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
		if (!v1.isEmpty()) queue.offer(v1.iterator());
		if (!v2.isEmpty()) queue.offer(v2.iterator());
	}
	
	public int next() {
		Iterator<Integer> iter = queue.poll();
		int ret = iter.next();
		if (iter.hasNext()) queue.offer(iter);
		return ret;
	}
	
	public boolean hasNext() {
		return !queue.isEmpty();
	}
	
	public static void main(String[] args) {
		ZigzagIterator zi = new ZigzagIterator(Arrays.asList(1,2), Arrays.asList(3,4,5,6));
		while (zi.hasNext()) {
			System.out.println(zi.next());
		}
	}
}
