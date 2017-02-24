import java.util.HashSet;
import java.util.Set;

public class ContainsNearbyDuplciate {
	public boolean containsNearbyDuplicate(int[] nums, int k) {
//		HashMap<Integer, Integer> indices = new HashMap<>();
//		for (int i = 0; i < nums.length; i++) {
//			if (indices.containsKey(nums[i])) {
//				if (i - indices.get(nums[i]) <= k) return true;
//			}
//			indices.put(nums[i], i);
//		}
//		return false;
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (i > k) set.remove(nums[i - k - 1]);
			if (!set.add(nums[i])) return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		ContainsNearbyDuplciate cnd = new ContainsNearbyDuplciate();
		int[] nums = new int[30000];
		for (int i = 0; i < 30000; i++) nums[i] = i;
		System.out.println(cnd.containsNearbyDuplicate(nums, 15000));
	}
}
