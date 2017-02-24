import java.util.Arrays;

public class SearchInsertPosition {
	
	public int searchInsert(int[] nums, int target) {
		int idx = Arrays.binarySearch(nums, target);
		if (idx < 0) idx = -idx - 1;
		return idx;
	}

	public static void main(String[] args) {
		SearchInsertPosition sip = new SearchInsertPosition();
		int[] nums = {1,3,5,6};
		System.out.println(sip.searchInsert(nums, 5)); // 2
		System.out.println(sip.searchInsert(nums, 2)); // 1
		System.out.println(sip.searchInsert(nums, 7)); // 4
		System.out.println(sip.searchInsert(nums, 0)); // 0
	}

}
