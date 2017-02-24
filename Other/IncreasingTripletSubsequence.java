
public class IncreasingTripletSubsequence {
	// C1 = so far best candidate of end element of a one-cell subsequence to form a triplet subsequence
	// C2 = so far best candidate of end element of a two-cell subsequence to form a triplet subsequence
	public boolean increasingTriplet(int[] nums) {
		int c1 = Integer.MAX_VALUE, c2 = Integer.MAX_VALUE;
		for (int num : nums) {
			if (num <= c1) c1 = num;
			else if (num <= c2) c2 = num;
			else return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		IncreasingTripletSubsequence lts = new IncreasingTripletSubsequence();
		int[] nums = {5,4,3,2,1};
//		int[] nums = {1,2,3,4,5};
		System.out.println(lts.increasingTriplet(nums));
	}
}
