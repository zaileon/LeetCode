
public class BombEnemy {
	public int maxKilledEnemies(char[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
		int m = grid.length, n = grid[0].length;
		int result = 0;
		int rowHits = 0;
		int[] colHits = new int[n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				// if the first column or left one is a wall, recalculate the row streak rightward
				if (j == 0 || grid[i][j - 1] == 'W') {
					rowHits = 0;
					for (int k = j; k < n && grid[i][k] != 'W'; k++) 
						rowHits += grid[i][k] == 'E' ? 1 : 0;
				}
				// if the first row or above one is a wall, recalculate the column streak downward
				if (i == 0 || grid[i - 1][j] == 'W') {
					colHits[j] = 0;
					for (int k = i; k < m && grid[k][j] != 'W'; k++)
						colHits[j] += grid[k][j] == 'E' ? 1 : 0;
				}
				if (grid[i][j] == '0')
					result = Math.max(result, rowHits + colHits[j]);
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		BombEnemy be = new BombEnemy();
//		char[][] grid = {
//				{'0', 'E', '0', '0'},
//				{'E', '0', 'W', 'E'},
//				{'0', 'E', '0', '0'}
//		};
		char[][] grid = {{'E', '0', 'W', 'E'}};
		System.out.println(be.maxKilledEnemies(grid));
	}
}
