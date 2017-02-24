import java.util.Arrays;

public class Zuma {
	
	public int findMinStep(String board, String hand) {
		Ball prev = null, head = null;
		int cnt = 1;
		for (int i = 1; i <= board.length(); i++) {
			if (i == board.length() || board.charAt(i) != board.charAt(i - 1)) {
				Ball b = new Ball(board.charAt(i - 1), cnt);
				if (prev != null) {
					b.prev = prev;
					prev.next = b;
				} else head = b;
				prev = b;
				cnt = 1;
			} else cnt++;
		}
		
		boolean[] visited = new boolean[hand.length()];
		char[] arr = hand.toCharArray();
		Arrays.sort(arr);
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < arr.length; i++) {
			if (i == 0 || arr[i] != arr[i - 1]) {
				int step = dfs(head, visited, arr, i, 0);
				if (step >= 0) min = Math.min(min, step);
			}
		}
		return min == Integer.MAX_VALUE ? -1 : min;
	}
	
	private int dfs(Ball head, boolean[] visited, char[] arr, int d, int step) {
		Ball b = head;
		while (b != null) {
			if (b.color != arr[d]) { b = b.next; continue; }
			b.count++;
			if (b.count == 3) {
				Ball prev = b, next = b;
				while ((prev = prev.prev) != null && (next = next.next) != null && prev.color == next.color) {
					prev.count += next.count;
					if (prev.count < 3) { next = next.next; break; }
				}
				if (prev == null && next == null) return step + 1;
				if (prev != null) prev.next = next;
				if (next != null) next.prev = prev;
			}
			b.count--;
			b = b.next;
		}
		
		return -1;
	}
	
	class Ball {
		char color;
		int count;
		Ball prev, next;
		Ball(char c, int count) { this.color = c; this.count = count; this.prev = this.next = null; }
	}
	
	public static void main(String[] args) {
		Zuma zuma = new Zuma();
		System.out.println(zuma.findMinStep("WWRRBBRWW", "RWBRW"));
	}
}
