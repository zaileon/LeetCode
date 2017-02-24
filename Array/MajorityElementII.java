import java.util.ArrayList;
import java.util.List;

public class MajorityElementII {
	
	public List<Integer> majorityElement(int[] nums) {
		List<Integer> result = new ArrayList<>();
		int candidate1 = 0, candidate2 = 1, cnt1 = 0, cnt2 = 0;
		for (int num : nums) {
			if (num == candidate1) cnt1++;
			else if (num == candidate2) cnt2++;
			else if (cnt1 == 0) { candidate1 = num; cnt1 = 1; }
			else if (cnt2 == 0) { candidate2 = num; cnt2 = 1; }
			else { cnt1--; cnt2--; }
		}
		cnt1 = cnt2 = 0;
		for (int num : nums) {
			if (num == candidate1) cnt1++;
			else if (num == candidate2) cnt2++;
		}
		if (cnt1 > nums.length / 3) result.add(candidate1);
		if (cnt2 > nums.length / 3) result.add(candidate2);
		return result;
	}
	
	public static void main(String[] args) {
		MajorityElementII me = new MajorityElementII();
		int[] nums = {1};
//		int[] nums = {1,1};
//		int[] nums = {1,2};
//		int[] nums = {1,1,1,2,3,4,5,6};
		for (int m : me.majorityElement(nums)) {
			System.out.println(m);
		}
	}
}
