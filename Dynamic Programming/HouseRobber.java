
public class HouseRobber {
	public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int money = nums[0], prev_money = 0;
        for (int i = 1; i < nums.length; i++) {
            int temp = money;
            money = Math.max(money, prev_money + nums[i]);
            prev_money = temp;
        }
        return money;
    }
}
