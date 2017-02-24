import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class PhoneDirectory {

	private Set<Integer> used = new HashSet<>();
	private Queue<Integer> available = new LinkedList<>();
	int maxNumbers;
	
	public PhoneDirectory(int maxNumbers) {
		this.maxNumbers = maxNumbers;
		for (int i = 0; i < maxNumbers; i++) {
			available.offer(i);
		}
	}
	
	public int get() {
		Integer i = available.poll();
		if (i == null) return -1;
		used.add(i);
		return i;
	}
	
	public boolean check(int number) {
		if (number >= maxNumbers || number < 0) return false;
		return !used.contains(number);
	}
	
	public void release(int number) {
		if (used.remove(number)) {
			available.offer(number);
		}
	}
}
