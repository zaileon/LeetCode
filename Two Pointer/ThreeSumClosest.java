import java.util.Arrays;


public class ThreeSumClosest {

	public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closest = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
        	if (nums[i] > target / 3) break;
        	int j = i + 1, k = nums.length - 1;
        	while (j < k) {
	        	int sum = nums[i] + nums[j] + nums[k];
	        	
	        	if (sum > target) k--;
	        	else if (sum < target) j++;
	        	else return target;
	        	
	        	if (Math.abs(sum - target) < Math.abs(closest - target)) 
	        		closest = sum;
        	}
        }
        return closest;
    }

	public static void main(String[] args) {
		ThreeSumClosest tsc = new ThreeSumClosest();
		int[] nums = {1,1,1,0}; int target = -100;
//		int[] nums = {0,0,0}; int target = 1;
//		int[] nums = {-1,2,1,4}; int target = 1;
		System.out.println(tsc.threeSumClosest(nums, target));
	}

}
