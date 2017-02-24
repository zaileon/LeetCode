public class Maze {
	
	private static final int[] DIRECTIONS = {1,0,-1,0,1};
	public boolean hasPath(int[][] maze, int[] start, int[] destination) {
		boolean[][] visited = new boolean[maze.length][maze[0].length];
		return dfs(maze, visited, start[0], start[1], destination);
	}
	
	private boolean dfs(int[][] maze, boolean[][] visited, int x, int y, int[] e) {
		if (visited[x][y]) return false;
		if (x == e[0] && y == e[1]) return true;
		visited[x][y] = true;
		for (int i = 0; i < 4; i++) {
			int[] pos = new int[] { x, y };
			while (!hitWall(maze, pos, i)) {
				pos[0] += DIRECTIONS[i];
				pos[1] += DIRECTIONS[i + 1];
			}
			if (dfs(maze, visited, pos[0], pos[1], e)) return true;
		}
		return false;
	}

	private boolean hitWall(int[][] maze, int[] pos, int d) {
		int x1 = pos[0] + DIRECTIONS[d], y1 = pos[1] + DIRECTIONS[d + 1];
		return x1 < 0 || x1 >= maze.length || y1 < 0 || y1 >= maze[0].length || maze[x1][y1] == 1;
	}
	
	public static void main(String[] args) {
		Maze m = new Maze();
		int[][] maze = {
				{0,0,1,0,0},
				{0,0,0,0,0},
				{0,0,0,1,0},
				{1,1,0,1,1},
				{0,0,0,0,0},
		};
//		int[] start = {0,4}, destination = {3,2};
		int[] start = {0,4}, destination = {4,4};
		System.out.println(m.hasPath(maze, start, destination));
	}

}
