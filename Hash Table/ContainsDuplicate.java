import java.util.HashSet;

public class ContainsDuplicate {
	public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) return false;
            set.add(num);
        }
        return true;
    }
	
	public static void main(String[] args) {
		ContainsDuplicate cd = new ContainsDuplicate();
		int[] nums = {1,1,2};
		System.out.println(cd.containsDuplicate(nums));
	}
}
