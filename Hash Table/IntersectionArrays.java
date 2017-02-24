import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class IntersectionArrays {
	public int[] intersection(int[] nums1, int[] nums2) {
		Set<Integer> set = new HashSet<>();
		for (int num : nums1) set.add(num);
		ArrayList<Integer> result = new ArrayList<>();
		for (int num : nums2) {
			if (set.contains(num)) {
				result.add(num);
				set.remove(num);
			}
		}
		int[] arr = new int[result.size()];
		for (int i = 0; i < result.size(); i++)
			arr[i] = result.get(i);
		return arr;
	}
}
