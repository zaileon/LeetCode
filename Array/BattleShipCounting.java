
public class BattleShipCounting {

	// count only the heads of the battleships
	// only increase count if there is no 'X' atop or on the left of current 'X'
	public int countBattleships(char[][] board) {
		int count = 0;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == '.')	 continue;
				if (i > 0 && board[i-1][j] == 'X') continue; // there is 'X' atop. this is a continuation of a vertical ship
				if (j > 0 && board[i][j-1] == 'X') continue; // there is 'X' on the left. this is a continuation of a horizontal ship
				count++;
			}
		}
		return count;
	}
}
