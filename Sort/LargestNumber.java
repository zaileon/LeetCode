import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LargestNumber {
	
	public String largestNumber(int[] nums) {
		List<Integer> list = new ArrayList<>();
		for (int num : nums) list.add(num);
		Collections.sort(list, (a, b) -> {
			if (a == b) return 0;
			String s1 = String.valueOf(a), s2 = String.valueOf(b);
			for (int i = 0, j = 0; i < s1.length() || j < s2.length(); i++, j++) {
				if (i == s1.length()) i = 0;
				if (j == s2.length()) j = 0;
				if (s1.charAt(i) < s2.charAt(j)) return 1;
				else if (s1.charAt(i) > s2.charAt(j)) return -1;
			}
			return 0;
		});
		if (list.get(0) == 0) return "0";
		StringBuilder sb = new StringBuilder();
		for (int num : list) {
			sb.append(num);
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		LargestNumber ln = new LargestNumber();
//		int[] nums = {121, 12};
//		int[] nums = {3, 30, 34, 5, 9};
//		int[] nums = {3,43,48,94,85,33,64,32,63,66};
//		int[] nums = {3,31};
		int[] nums = {1,0,0};
//		int[] nums = {1,1,1};
		System.out.println(ln.largestNumber(nums));
	}
	
}
