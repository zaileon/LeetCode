
public class BeautifulArrangement {
	
	int total;
	public int countArrangement(int N) {
		total = 0;
		int[] nums = new int[N + 1];
		boolean[] visited = new boolean[N + 1];
		backtrack(nums, 1, visited);
		return total;
	}
	
	private void backtrack(int[] nums, int start, boolean[] visited) {
		if (start == nums.length) {
			total++;
			return;
		}
		for (int i = 1; i < visited.length; i++) {
			if (!visited[i] && (i % start == 0 || start % i == 0)) {
				nums[start] = i; 
				visited[i] = true;
				backtrack(nums, start + 1, visited);
				visited[i] = false;
			}
		}
	}
	
	public static void main(String[] args) {
		BeautifulArrangement ba = new BeautifulArrangement();
		System.out.println(ba.countArrangement(3));
	}
}
