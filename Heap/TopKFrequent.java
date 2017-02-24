import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequent {
	public List<Integer> topKFrequent(int[] nums, int k) {
		Map<Integer, Integer> frequencies = new HashMap<>();
		for (int num : nums) {
			frequencies.put(num, frequencies.getOrDefault(num, 0) + 1);
		}
		List<Integer>[] buckets = new List[nums.length + 1]; 
		for (int key : frequencies.keySet()) {
			int frequency = frequencies.get(key);
			if (buckets[frequency] == null) buckets[frequency] = new ArrayList<>();
			buckets[frequency].add(key);
		}
		List<Integer> result = new ArrayList<>();
		for (int i = buckets.length - 1; i >= 0 && result.size() < k; i--) {
			if (buckets[i] != null) result.addAll(buckets[i]);
		}
		return result;
	}
	
	public static void main(String[] args) {
		TopKFrequent tkf = new TopKFrequent();
		int[] nums = {1,1,1,2,2,3}; int k = 2;
		for (int num : tkf.topKFrequent(nums, k)) {
			System.out.println(num);
		}
	}
}
