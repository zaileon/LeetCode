
public class TicTacToe {
	
	int[] rows, cols;
	int n, diagonal, antidiagonal;

	public TicTacToe(int n) {
		this.n = n;
		rows = new int[n];
		cols = new int[n];
	}

	public int move(int row, int col, int player) {
		int toAdd = player == 1 ? 1 : -1;

		rows[row] += toAdd;
		cols[col] += toAdd;
		if (row == col) diagonal += toAdd;
		if (row + col == n - 1) antidiagonal += toAdd;
		
		if (Math.abs(rows[row]) == n || Math.abs(cols[col]) == n || Math.abs(diagonal) == n || Math.abs(antidiagonal) == n)
			return player;
		return 0;
	}
	
	public static void main(String[] args) {
//		TicTacToe toe = new TicTacToe(2);
//		System.out.println(toe.move(0, 0, 2)); // 0
//		System.out.println(toe.move(0, 1, 1)); // 0
//		System.out.println(toe.move(1, 1, 2)); // 2
		
		TicTacToe toe = new TicTacToe(2);
		System.out.println(toe.move(0, 1, 1)); // 0
		System.out.println(toe.move(1, 1, 2)); // 0
		System.out.println(toe.move(1, 0, 1)); // 1
		
//		TicTacToe toe = new TicTacToe(3);
//		System.out.println(toe.move(0, 0, 1)); // 0
//		System.out.println(toe.move(0, 2, 2)); // 0
//		System.out.println(toe.move(2, 2, 1)); // 0
//		System.out.println(toe.move(1, 1, 2)); // 0
//		System.out.println(toe.move(2, 0, 1)); // 0
//		System.out.println(toe.move(1, 0, 2)); // 0
//		System.out.println(toe.move(2, 1, 1)); // 1
	}
}
