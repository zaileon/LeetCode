import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class RandomizedCollection {
	private List<Integer> nums;
	private Map<Integer, LinkedHashSet<Integer>> locs;
	private Random r = new Random();
	
	public RandomizedCollection() {
		this.nums = new ArrayList<>();
		this.locs = new HashMap<>();
	}
	
	public boolean insert(int val) {
		boolean contains = locs.containsKey(val);
		if (!contains) locs.put(val, new LinkedHashSet<>());
		locs.get(val).add(nums.size());
		nums.add(val);
		return !contains;
	}
	
	public boolean remove(int val) {
		boolean contains = locs.containsKey(val);
		if (!contains) return false;
		int loc = locs.get(val).iterator().next();
		locs.get(val).remove(loc);
		if (loc < nums.size() - 1) {
			int last = nums.get(nums.size() - 1);
			nums.set(loc, last);
			locs.get(last).remove(nums.size() - 1);
			locs.get(last).add(loc);
		}
		if (locs.get(val).size() == 0) locs.remove(val);
		nums.remove(nums.size() - 1);
		return true;
	}
	
	public int getRandom() {
		return nums.get(r.nextInt(nums.size()));
	}
	
	public static void main(String[] args) {
		RandomizedCollection rc = new RandomizedCollection();
		System.out.println(rc.insert(1));
		System.out.println(rc.insert(1));
		System.out.println(rc.insert(2));
		System.out.println(rc.insert(1));
		System.out.println(rc.insert(2));
		System.out.println(rc.insert(2));
		System.out.println(rc.remove(1));
		System.out.println(rc.remove(2));
		System.out.println(rc.remove(2));
		System.out.println(rc.remove(2));
		System.out.println(rc.getRandom());
		System.out.println(rc.getRandom());
		System.out.println(rc.getRandom());
		System.out.println(rc.getRandom());
		System.out.println(rc.getRandom());
		System.out.println(rc.getRandom());
		System.out.println(rc.getRandom());
		System.out.println(rc.getRandom());
		System.out.println(rc.getRandom());
		System.out.println(rc.getRandom());
	}
	
}
