
public class SudokuSolver {
	public void solveSudoku(char[][] board) {
		solve(board, 0, 0);
	}
	
	private boolean solve(char[][] board, int row, int col) {
		for (int i = row; i < board.length; i++, col = 0) {
			for (int j = col; j < board[0].length; j++) {
				if (board[i][j] != '.') continue;
				for (char num = '1'; num <= '9'; num++) {
					if (isValid(board, i, j, num)) {
						board[i][j] = num;
						if (solve(board, i, j + 1)) return true;
						board[i][j] = '.';
					}
				}
				return false;
			}
		}
		return true;
	}
	
	private boolean isValid(char[][] board, int row, int col, char num) {
		for (int i = 0; i < 9; i++) {
			int r = row / 3 * 3 + i / 3;
			int c = col / 3 * 3 + i % 3;
			if (board[row][i] == num || board[i][col] == num || board[r][c] == num) return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		String[] strs = {"..9748...","7........",".2.1.9...","..7...24.",".64.1.59.",".98...3..","...8.3.2.","........6","...2759.."};
		char[][] board = new char[9][];
		for (int i = 0; i < 9; i++) {
			board[i] = strs[i].toCharArray();
		}
		SudokuSolver ss = new SudokuSolver();
		ss.solveSudoku(board);
		System.out.println("");
	}
}
