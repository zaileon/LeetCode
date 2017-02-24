
public class IslandPerimeter {
	
	// Neighbor islands collapsed two adjacent edges
	public int islandPerimeter(int[][] grid) {
		if (grid == null || grid.length == 0) return 0;
		int islands = 0, neighbours = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					islands++;
					if (i < grid.length - 1 && grid[i + 1][j] == 1) neighbours++;
					if (j < grid[0].length - 1 && grid[i][j + 1] == 1) neighbours++;
				}
			}
		}
		return islands * 4 - neighbours * 2;
	}
	
	public static void main(String[] args) {
		IslandPerimeter ip = new IslandPerimeter();
//		int[][] grid = {{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
		int[][] grid = {{0,1,0,0}};
		System.out.println(ip.islandPerimeter(grid));
	}
}
