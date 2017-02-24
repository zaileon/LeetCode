
public class NQueensII {
	
	int count = 0;
	public int totalNQueens(int n) {
		boolean[] used = new boolean[n];
		int[] positions = new int[n];
		backtrack(0, positions, used);
		return count;
	}
	
	private void backtrack(int row, int[] positions, boolean[] used) {
		if (row == positions.length) count++;
		for (int i = 0; i < positions.length; i++) {
			if (!used[i] && isValid(positions, row, i)) {
				positions[row] = i; used[i] = true;
				backtrack(row + 1, positions, used);
				used[i] = false;
			}
		}
	}
	
	private boolean isValid(int[] positions, int row, int p) {
		for (int i = 0; i < row; i++) {
			if (p - positions[i] == row - i || p - positions[i] == i - row) return false;
		}
		return true;
	}

	public static void main(String[] args) {
		NQueensII nq = new NQueensII();
		System.out.println(nq.totalNQueens(4));
	}

}
