
public class RemoveElement {
	public int removeElement(int[] nums, int val) {
		int i = 0, j = nums.length;
        while (i < j) {
            if (nums[i] == val) {
            	nums[i] = nums[j-1];
                j--;
            } else 
            	i++;
        }
        return j;
	}

	public static void main(String[] args) {
		RemoveElement re = new RemoveElement();
//		int[] nums = {1}; int val = 1;
		int[] nums = {3,3,3,3}; int val = 3;
//		int[] nums = {3,2,2,3}; int val = 3;
		System.out.println(re.removeElement(nums, val));
	}

}
