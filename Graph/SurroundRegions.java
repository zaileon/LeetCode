
public class SurroundRegions {
	
	private static final int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};
	
	public void solve(char[][] board) {
		if (board == null || board.length == 0 || board[0].length == 0) return;
		int m = board.length, n = board[0].length;
		for (int i = 0; i < m; i++) {
			bfs(board, i, 0);
			if (n > 1) bfs(board, i, n-1);
		}
		for (int col = 1; col < n - 1; col++) {
			bfs(board, 0, col);
			if (m > 1) bfs(board, m-1, col);
		}
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == 'O') board[i][j] = 'X';
				else if (board[i][j] == '1') board[i][j] = 'O';
			}
		}
	}
	
	private void bfs(char[][] board, int i, int j) {
		if (board[i][j] == 'O') {
			board[i][j] = '1';
			for (int[] dir : dirs) {
				int x = i + dir[0], y = j + dir[1];
				if (x > 0 && x < board.length - 1 && y > 0 && y < board[0].length - 1)
					bfs(board, x, y);
			}
		}
	}

	public static void main(String[] args) {
		SurroundRegions sr = new SurroundRegions();
		char[][] board = {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
		sr.solve(board);
		for (char[] row : board) {
			for (char c : row) {
				System.out.print(c);
				System.out.print(" ");
			}
			System.out.println("");
		}
	}

}
