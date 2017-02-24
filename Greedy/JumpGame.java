
public class JumpGame {
	public boolean canJump(int[] nums) {
		int end = nums.length-1;
		for (int i = 0, reach = 0; i <= reach; i++) {
			reach = Math.max(i + nums[i], reach);
			if (reach >= end) return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		JumpGame jg = new JumpGame();
		int[] nums = new int[25000];
		for (int i = 0; i < 25000; i++) {
			nums[i] = 25000 - i;
		}
		System.out.println(jg.canJump(nums));
	}
}
