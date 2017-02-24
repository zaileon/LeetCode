
public class PatchingArray {

	public int minPatches(int[] nums, int n) {
		long miss = 1;
		int added = 0, i = 0;
		while (miss <= n) {
			if (i < nums.length && nums[i] <= miss) {
				miss += nums[i++];
			} else {
				miss += miss;
				added++;
			}
		}
		return added;
	}

	public static void main(String[] args) {
		PatchingArray pa = new PatchingArray();
//		int[] nums = {1,2,31,33}; int n = Integer.MAX_VALUE;
//		int[] nums = {1,3}; int n = 6;
		int[] nums = {1,2,4,13,43}; int n = 100;
//		int[] nums = {1,2,2}; int n = 5;
//		int[] nums = {1,5,10}; int n = 20;
		System.out.println(pa.minPatches(nums, n));
	}
	
}
