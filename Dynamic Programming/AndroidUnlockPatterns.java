
public class AndroidUnlockPatterns {
	public int numberofPatterns(int m, int n) {
		boolean[] visited = new boolean[10];
		
		int[][] skip = new int[10][10];
		skip[1][3] = skip[3][1] = 2;
		skip[1][7] = skip[7][1] = 4;
		skip[3][9] = skip[9][3] = 6;
		skip[7][9] = skip[9][7] = 8;
		skip[1][9] = skip[9][1] = 5;
		skip[2][8] = skip[8][2] = 5;
		skip[3][7] = skip[7][3] = 5;
		skip[4][6] = skip[6][4] = 5;
		
		int result = 0;
		for (int i = m; i <= n; i++) {
			result += dfs(1, i - 1, skip, visited) * 4;
			result += dfs(2, i - 1, skip, visited) * 4;
			result += dfs(5, i - 1, skip, visited);
		}
		
		return result;
	}
	
	private int dfs(int curr, int remainingSteps, int[][] skip, boolean[] visited) {
		if (remainingSteps == 0) return 1;
		int result = 0;
		visited[curr] = true;
		for (int i = 1; i <= 9; i++) {
			if (!visited[i] && (skip[curr][i] == 0 || visited[skip[curr][i]])) {
				result += dfs(i, remainingSteps - 1, skip, visited);
			}
		}
		visited[curr] = false;
		return result;
	}
	
	public static void main(String[] args) {
		AndroidUnlockPatterns aup = new AndroidUnlockPatterns();
		int m = 3, n = 3;
		System.out.println(aup.numberofPatterns(m, n));
	}
}
