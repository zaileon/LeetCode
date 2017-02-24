import java.util.PriorityQueue;

public class MazeIII {

	public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
		int m = maze.length, n = maze[0].length;
		int[][] distance = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				distance[i][j] = Integer.MAX_VALUE;
			}
		}
		distance[ball[0]][ball[1]] = 0;
		
		int[][] dirs = {{1,0},{0,-1},{-1,0},{0,1}};
		char[] labels = {'d','l','u','r'};
		
		PriorityQueue<Point> queue = new PriorityQueue<>();
		PriorityQueue<Point> result = new PriorityQueue<>();
		queue.offer(new Point(ball[0], ball[1], 0, ""));
		
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			for (int i = 0; i < 4; i++) {
				int x = p.x, y = p.y, dx = dirs[i][0], dy = dirs[i][1], l = p.l;
				while (!hitWall(maze, x, y, dx, dy)) {
					x += dx;
					y += dy;
					l++;
					if (x == hole[0] && y == hole[1] && l <= distance[x][y]) { // need to keep all paths with equal or less distance
						distance[x][y] = l;
						result.add(new Point(x, y, l, p.path + labels[i]));
						break;
					}
				}
				if (l > p.l && l <= distance[x][y]) { // the equal sign here is important
					distance[x][y] = l;
					queue.offer(new Point(x, y, l, p.path + labels[i]));
				}
			}
		}
		return result.isEmpty() ? result.poll().path : "impossible";
	}
	
	class Point implements Comparable<Point> {
		int x, y, l;
		String path;
		Point(int x, int y, int l, String path) { this.x = x; this.y = y; this.l = l; this.path = path; }
		@Override
		public int compareTo(Point other) { return this.l != other.l ? this.l - other.l : this.path.compareTo(other.path); }
	}
	
	private boolean hitWall(int[][] maze, int x, int y, int dx, int dy) {
		int x1 = x + dx, y1 = y + dy;
		return x1 < 0 || x1 >= maze.length || y1 < 0 || y1 >= maze[0].length || maze[x1][y1] == 1;
	}
	
	public static void main(String[] args) {
		MazeIII m = new MazeIII();
//		int[][] maze = {
//				{0,0,0,0,0},
//				{1,1,0,0,1},
//				{0,0,0,0,0},
//				{0,1,0,0,1},
//				{0,1,0,0,0},
//		};
//		int[] start = {4,3}, hole = {3,0};
//		int[] start = {4,3}, hole = {0,1};
		int[][] maze = {
				{0,1,0,0,1,0,0,1,0,0},
				{0,0,1,0,0,1,0,0,1,0},
				{0,0,0,0,0,0,1,0,0,1},
				{0,0,0,0,0,0,1,0,0,1},
				{0,1,0,0,1,0,0,1,0,0},
				{0,0,1,0,0,1,0,0,0,0},
				{0,0,0,0,0,0,1,0,0,0},
				{1,0,0,1,0,0,0,0,0,1},
				{0,1,0,0,1,0,0,1,0,0},
				{0,0,0,0,0,1,0,0,1,0}
		};
		int[] start = {2,4}, hole = {7,6};
		System.out.println(m.findShortestWay(maze, start, hole));
	}
}
