import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class RandomizedSet {
	private List<Integer> nums;
	private Map<Integer, Integer> locs;
	private Random r = new Random();
	
	RandomizedSet() {
		nums = new ArrayList<>();
		locs = new HashMap<>();
	}
	
	public boolean insert(int val) {
		if (locs.containsKey(val)) return false;
		locs.put(val, nums.size());
		nums.add(val);
		return true;
	}
	
	public boolean remove(int val) {
		if (!locs.containsKey(val)) return false;
		int idx = locs.get(val);
		if (idx < nums.size() - 1) {
			int last = nums.get(nums.size() - 1);
			nums.set(idx, last);
			locs.put(last, idx);
		}
		nums.remove(nums.size() - 1);
		locs.remove(val);
		return true;
	}
	
	public int getRandom() {
		return nums.get(r.nextInt(nums.size()));
	}
}
