import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IncreasingSubsequences {
	public List<List<Integer>> findSubsequences(int[] nums) {
		Set<List<Integer>> set = new HashSet<>();
		List<Integer> seq = new ArrayList<>();
		backtrack(set, seq, 0, nums);
		return new ArrayList<>(set);
	}
	
	private void backtrack(Set<List<Integer>> set, List<Integer> seq, int start, int[] nums) {
		if (seq.size() >= 2) {
			set.add(new ArrayList<>(seq));
		}
		
		for (int i = start; i < nums.length; i++) {
			if (seq.size() == 0 || seq.get(seq.size() - 1) <= nums[i]) {
				seq.add(nums[i]);
				backtrack(set, seq, i + 1, nums);
				seq.remove(seq.size() - 1);
			}
		}
	}

	public static void main(String[] args) {
		IncreasingSubsequences is = new IncreasingSubsequences();
		int[] nums = {4,6,7,7};
		for (List<Integer> seq : is.findSubsequences(nums)) {
			for (int i : seq) {
				System.out.print(i + " ");
			}
			System.out.println("");
		}
	}

}
