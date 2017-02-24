
public class TwoSumII {
	
	public int[] twoSum(int[] numbers, int target) {
		int i = 0, j = numbers.length - 1;
		while (i < j) {
			int sum = numbers[i] + numbers[j];
			if (sum > target) j--;
			else if (sum < target) i++;
			else return new int[] {i,j};
		}
		return new int[] {-1,-1};
	}

	public static void main(String[] args) {
		TwoSumII ts = new TwoSumII();
		int[] numbers = {2, 7, 11, 15}; int target = 9;
		for (int i : ts.twoSum(numbers, target)) {
			System.out.println(i);
		}
	}

}
