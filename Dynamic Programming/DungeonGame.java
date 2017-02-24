import java.util.Arrays;

public class DungeonGame {
	public int calculateMinimumHP(int[][] dungeon) {
		if (dungeon == null || dungeon.length == 0 || dungeon[0].length == 0) return 0;
		int m = dungeon.length, n = dungeon[0].length;
		// hp represents the minumun hp upon entering each cell
		// here we use 1D array to save on space
		int[] hp = new int[n + 1];
		Arrays.fill(hp, Integer.MAX_VALUE);
		// initial hp [Integer.MAX_VALUE, ..., 1, Integer.MAX_VALUE]
		// ideally K should reach P with a HP of 1
		// the last Integer.MAX_VALUE is an useful dummy
		hp[n - 1] = 1;
		for (int i = m - 1; i >= 0; i--) {
			for (int j = n - 1; j >= 0; j--) {
				// every step compare hp down and right, choose the smaller one
				// because it will requires smaller hp upon entering the cell
				// e.g. dungeon[i][j] = -4, hp[j] = 3, hp[j+1] = 4, then need = 7
				int need = Math.min(hp[j + 1], hp[j]) - dungeon[i][j];
				hp[j] = need <= 0 ? 1 : need;
			}
		}
		return hp[0];
	}
	
	public static void main(String[] args) {
		DungeonGame dg = new DungeonGame();
		int[][] dungeon = {{0}};
		System.out.println(dg.calculateMinimumHP(dungeon));
	}
}
