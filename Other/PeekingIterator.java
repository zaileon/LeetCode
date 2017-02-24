import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class PeekingIterator {
	
	Iterator<Integer> iter;
	Integer E = null;
	
	public PeekingIterator(Iterator<Integer> iterator) {
		iter = iterator;
	}
	
	public Integer peek() {
		if (E == null) E = iter.next();
		return E;
	}
	
	public Integer next() {
		if (E == null) return iter.next();
		Integer ret = E;
		E = null;
		return ret;
	}
	
	public boolean hasNext() {
		return E != null || iter.hasNext();
	}
	
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1,2,3,4);
		PeekingIterator pi = new PeekingIterator(list.iterator());
		System.out.println(pi.hasNext());
		System.out.println(pi.next());
		System.out.println(pi.peek());
		System.out.println(pi.next());
		System.out.println(pi.peek());
		System.out.println(pi.hasNext());
		System.out.println(pi.next());
	}
}
