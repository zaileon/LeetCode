import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {
	
	List<List<String>> solveQueens(int n) {
		List<List<String>> result = new ArrayList<>();
		if (n <= 0) return result;
		int[] positions = new int[n];
		boolean[] used = new boolean[n];
		String[] rows = prepareRows(n);
		backtrack(result, new ArrayList<String>(), 0, positions, used, rows);
		return result;
	}
	
	private void backtrack(List<List<String>> result, List<String> layout, int row, int[] positions, boolean[] used, String[] rows) {
		if (row == positions.length) {
			result.add(new ArrayList<String>(layout));
			return;
		}
		for (int i = 0; i < positions.length; i++) {
			if (!used[i] && isValid(positions, row, i)) {
				positions[row] = i; used[i] = true; layout.add(rows[i]);
				backtrack(result, layout, row + 1, positions, used, rows);
				used[i] = false; layout.remove(row);
			}
		}
	}
	
	private boolean isValid(int[] positions, int row, int p) {
		for (int i = 0; i < row; i++) {
			if (p - positions[i] == row - i || p - positions[i] == i - row) return false;
		}
		return true;
	}
	
	private String[] prepareRows(int n) {
		String[] rows = new String[n];
		char[] row = new char[n];
		Arrays.fill(row, '.');
		for (int i = 0; i < n; i++) {
			row[i] = 'Q';
			rows[i] = new String(row);
			row[i] = '.';
		}
		return rows;
	}

	public static void main(String[] args) {
		NQueens nq = new NQueens();
		for (List<String> layout : nq.solveQueens(4)) {
			for (String row : layout) {
				System.out.println(row);
			}
		}
	}

}
