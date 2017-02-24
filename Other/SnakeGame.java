import java.util.LinkedList;

public class SnakeGame {
	
	LinkedList<Integer> body = new LinkedList<>();
	int[][] food;
	int m, n, cnt;

	public SnakeGame(int width, int height, int[][] food) {
		this.m = height;
		this.n = width;
		this.food = food;
		body.add(0);
	}
	
	public int move(String direction) {
		int head = body.getFirst();
		int x = head / n, y = head % n;
		switch(direction) {
			case "L": y--; break;
			case "R": y++; break;
			case "U": x--; break;
			case "D": x++; break;
		}
		if (x < 0 || x >= m || y < 0 || y >= n) return -1;
		int k = 0;
		for (int p : body) {
			if (k++ == cnt) break;
			if (x == p / n && y == p % n) return -1;
		}
		body.addFirst(x * n + y);
		if (cnt < food.length && x == food[cnt][0] && y == food[cnt][1]) {
			cnt++;
		} else {
			body.removeLast();
		}
		return cnt;
	}
	
	public static void main(String[] args) {
		int[][] food = {{1,2},{0,1}}; 
		SnakeGame sg = new SnakeGame(3, 2, food);
		System.out.println(sg.move("R")); // 0
		System.out.println(sg.move("D")); // 0
		System.out.println(sg.move("R")); // 1
		System.out.println(sg.move("U")); // 1
		System.out.println(sg.move("L")); // 2
		System.out.println(sg.move("U")); //-1
		
//		int[][] food = {{0,1}}; 
//		SnakeGame sg = new SnakeGame(2, 2, food);
//		System.out.println(sg.move("R")); // 1
//		System.out.println(sg.move("D")); // 1
		
//		int[][] food = {{2,0},{0,0},{0,2},{2,2}}; 
//		SnakeGame sg = new SnakeGame(3, 3, food);
//		System.out.println(sg.move("D")); // 0
//		System.out.println(sg.move("D")); // 1
//		System.out.println(sg.move("R")); // 1
//		System.out.println(sg.move("U")); // 1
//		System.out.println(sg.move("U")); // 1
//		System.out.println(sg.move("L")); // 2
//		System.out.println(sg.move("D")); // 2
//		System.out.println(sg.move("R")); // 2
//		System.out.println(sg.move("R")); // 2
//		System.out.println(sg.move("U")); // 3
//		System.out.println(sg.move("L")); // 3
//		System.out.println(sg.move("D")); // 3
		
	}
	
}
