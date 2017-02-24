
public class JumpGameII {
	public int jump(int[] nums) {
		// BFS 
//		if (nums.length < 2) return 0;
//		int currReach = 0; // i ~ currMaxNumber are the reachable at the current level 
//		int nextReach = 0;
//		int level = 0, i = 0;
//		while ( i <= currReach) {
//			level++;
//			for (; i <= currReach; i++) {
//				nextReach = Math.max(nextReach, i + nums[i]);
//				if (nextReach >= nums.length - 1) return level;
//			}
//			if (currReach == nextReach) return -1;
//			currReach = nextReach;
//		}
//		return -1;
		
		// Greedy
		int currReach = 0, nextReach = nums[0], step = 0;
		for (int i = 1; i < nums.length; i++) {
			if (i > currReach) {  // next step
				step++;
				currReach = nextReach;
				if (currReach >= nums.length - 1) return step;
			}
			nextReach = Math.max(nextReach, i + nums[i]); // keep pushing the boundary to the right
			if (nextReach == i) return -1; // nextReach can not advance anymore. The case (i == nums.length - 1) is excluded due to line 25
		}
		return step;
	}
	
	public static void main(String[] args) {
		JumpGameII jg = new JumpGameII();
		int[] nums = {3,0,0,0,4};
//		int[] nums = {2,3,1,1,0};
		System.out.println(jg.jump(nums));
	}
}
