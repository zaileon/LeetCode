import java.util.PriorityQueue;

public class MazeII {

	public static final int[] DIRECTIONS = {1,0,-1,0,1};
	public int shortestDistance(int[][] maze, int[] start, int[] destination) {
		int m = maze.length, n = maze[0].length;
		int[][] distance = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) distance[i][j] = Integer.MAX_VALUE;
		}
		
		PriorityQueue<Point> queue = new PriorityQueue<>();
		queue.offer(new Point(start[0], start[1], 0));
		
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			if (p.x == destination[0] && p.y == destination[1]) return p.l;
			for (int d = 0; d < 4; d++) {
				int x = p.x, y = p.y, l = p.l;
				while (!hitWall(maze, x, y, d)) {
					x += DIRECTIONS[d];
					y += DIRECTIONS[d + 1];
					l++;
				}
				if (l > p.l && l < distance[x][y]) {
					distance[x][y] = l;
					queue.offer(new Point(x, y, l));
				}
			}
		}
		if (distance[destination[0]][destination[1]] == Integer.MAX_VALUE) return -1;
		else return distance[destination[0]][destination[1]];
	}
	
	class Point implements Comparable<Point> {
		int x, y, l;
		Point(int x, int y, int l) { this.x = x; this.y = y; this.l = l; }
		@Override
		public int compareTo(Point other) { return this.l - other.l; }
	}
	
	private boolean hitWall(int[][] maze, int x, int y, int d) {
		int x1 = x + DIRECTIONS[d], y1 = y + DIRECTIONS[d + 1];
		return x1 < 0 || x1 >= maze.length || y1 < 0 || y1 >= maze[0].length || maze[x1][y1] == 1;
	}
	
	public static void main(String[] args) {
		MazeII m = new MazeII();
		int[][] maze = {
				{0,0,1,0,0},
				{0,0,0,0,0},
				{0,0,0,1,0},
				{1,1,0,1,1},
				{0,0,0,0,0},
		};
//		int[] start = {0,4}, destination = {3,2};
		int[] start = {0,4}, destination = {4,4};
		System.out.println(m.shortestDistance(maze, start, destination));
	}
}
