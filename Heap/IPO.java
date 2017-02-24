import java.util.Arrays;
import java.util.PriorityQueue;

public class IPO {
	public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
		int N = Profits.length;
		Integer[] idx = new Integer[N];
		for (int i = 0; i < N; i++) idx[i] = i;
		Arrays.sort(idx, (i1, i2) -> Capital[i1] != Capital[i2] ? Capital[i1] - Capital[i2] : Profits[i2] - Profits[i1]);
		PriorityQueue<Project> heap = new PriorityQueue<>((p1, p2) -> p2.profit - p1.profit); // (p2.profit - p2.capital) - (p1.profit - p1.capital));
		int total = W;
		int j = 0;
		while (k-- > 0) {
			while (j < N && Capital[idx[j]] <= W) {
				heap.add(new Project(Profits[idx[j]], Capital[idx[j]]));
				j++;
			}
			if (heap.isEmpty()) break;
			Project p = heap.poll();
			W += p.profit;
			total += p.profit;
		}
		return total;
	}
	
	class Project {
		int profit, capital;
		Project(int p, int c) { this.profit = p; this.capital = c; }
	}
	
	public static void main(String[] args) {
		IPO ipo = new IPO();
//		int k = 11, W = 11; int[] Profit = {1,2,3}, Capital = {11,12,13}; // 17
//		int k = 1, W = 0; int[] Profit = {1,2,3}, Capital = {1,1,2}; // 0
//		int k = 2, W = 0; int[] Profit = {1,2,3}, Capital = {0,1,1}; // 4
		int k = 1, W = 2; int[] Profit = {1,2,3}, Capital = {0,1,1}; // 5
//		int k = 1, W = 2; int[] Profit = {1,2,3}, Capital = {1,1,2}; // 5
		System.out.println(ipo.findMaximizedCapital(k, W, Profit, Capital));
	}
}
