
public class RemoveDuplicatesII {
	
	public int removeDuplicates(int[] nums) {
		int len = 0;
        for (int i = 0, j = 0; i < nums.length; i++) {
        	if (nums[i] == nums[j]) {
        		if (i - j >= 2) continue;
        	} else 
        		j = i;
        	nums[len++] = nums[i];
        }
        return len;
    }
	
	public static void main(String[] args) {
		RemoveDuplicatesII rd = new RemoveDuplicatesII();
		System.out.println(rd.removeDuplicates(new int[] {1,1,1,2}));
		System.out.println(rd.removeDuplicates(new int[] {1,1,1,2,2,3}));
		System.out.println(rd.removeDuplicates(new int[] {}));
	}

}
