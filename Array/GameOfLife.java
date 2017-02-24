
public class GameOfLife {
	// 1. each cell is a int, but only use the first bit, we can use the second bit for next state
	//    e.g. 01->[next dead, current live] etc.
	// 2. next state of board[i][j] becomes 1 iff (lives == 2/3 and board[i][j] == 1) or (lives == 3 and board[i][j] == 0) 
	public void gameOfLife(int[][] board) {
		if (board == null || board.length == 0) return;
		int m = board.length, n = board[0].length;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				int lives = -board[i][j]; // to compensate itself in the next step
				for (int x = Math.max(i - 1, 0); x <= Math.min(i + 1, m - 1); x++) {
					for (int y = Math.max(j - 1, 0); y <= Math.min(j + 1, n - 1); y++) {
						lives += board[x][y] & 1; // board[x][y] might be changed already, need LSB
					}
				}
				if ((lives | board[i][j]) == 3) board[i][j] |= 2;
			}
		}
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				board[i][j] >>= 1;
			}
		}
	}
	
	public static void main(String[] args) {
		GameOfLife gl = new GameOfLife();
		int[][] board = {{1,1},{1,0}};
		gl.gameOfLife(board);
	}
}
