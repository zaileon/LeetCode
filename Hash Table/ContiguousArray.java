import java.util.HashMap;
import java.util.Map;

public class ContiguousArray {

	public int findMaxLength(int[] nums) {
		Map<Integer, int[]> map = new HashMap<>();
		map.put(0, new int[] { 0, 0 });
		int sum = 0, max = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 1) sum++; else sum--;
			map.putIfAbsent(sum, new int[] { i, i });
			int[] d = map.get(sum);
			max =  sum == 0 ? i + 1 : Math.max(i - d[0], max);
			d[1] = i;
		}
		return max;
	}
	
	public static void main(String[] args) {
		ContiguousArray ca = new ContiguousArray();
//		int[] nums = {0,1};
		int[] nums = {0,1,0};
		System.out.println(ca.findMaxLength(nums));
	}
}
