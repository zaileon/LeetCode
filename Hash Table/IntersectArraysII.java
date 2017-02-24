import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class IntersectArraysII {
	
//	public int[] intersect(int[] nums1, int[] nums2) {
//		HashMap<Integer, Integer> map = new HashMap<>();
//		for (int num : nums1) {
//			map.put(num, map.getOrDefault(num, 0) + 1);
//		}
//		ArrayList<Integer> result = new ArrayList<>();
//		for (int num : nums2) {
//			if (map.containsKey(num) && map.get(num) > 0) {
//				result.add(num);
//				map.put(num, map.get(num) - 1);
//			}
//		}
//		int[] arr = new int[result.size()];
//		for (int i = 0; i < result.size(); i++) arr[i] = result.get(i);
//		return arr;
//	}
	
	// Two pointers
	public int[] intersect(int[] nums1, int[] nums2) {
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		ArrayList<Integer> result = new ArrayList<>();
		for (int i = 0, j = 0; i < nums1.length && j < nums2.length;) {
			if (nums1[i] < nums2[j]) i++;
			else if (nums1[i] > nums2[j]) j++;
			else {
				result.add(nums1[i]);
				i++; j++;
			}
		}
		int[] arr = new int[result.size()];
		for (int i = 0; i < result.size(); i++) arr[i] = result.get(i);
		return arr;
	}

	public static void main(String[] args) {
		IntersectArraysII ia = new IntersectArraysII();
		int[] nums1 = {1,2,2,1}; int[] nums2 = {2,2};
		for (int num : ia.intersect(nums1, nums2)) {
			System.out.println(num);
		}
	}

}
