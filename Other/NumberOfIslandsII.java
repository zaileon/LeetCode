import java.util.ArrayList;
import java.util.List;

public class NumberOfIslandsII {
	
	private static final int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};
	public List<Integer> numIslands2(int m, int n, int[][] positions) {
		List<Integer> ret = new ArrayList<>();
		UnionFind2D islands = new UnionFind2D(m, n);
		for (int[] position : positions) {
			int x = position[0], y = position[1];
			int p = islands.add(x, y);
			for (int[] dir : dirs) {
				int q = islands.getId(x + dir[0], y + dir[1]);
				if (q > 0 && !islands.find(p, q))
					islands.union(p, q);
			}
			ret.add(islands.size());
		}
		return ret;
	}
	
	public static void main(String[] args) {
		NumberOfIslandsII noi = new NumberOfIslandsII();
		int[][] positions = {{0,0},{0,1},{1,2},{2,1},{1,1}};
		for (int i : noi.numIslands2(3, 3, positions)) {
			System.out.println(i);
		}
	}
}

class UnionFind2D {
	private int m, n, count;
	private int[] id;
	private int[] sz; // size of tree, for weighted join, i.e. join smaller tree to larger tree
	
	public UnionFind2D(int m, int n) {
		this.count = 0;
		this.m = m;
		this.n = n;
		this.id = new int[m * n + 1];
		this.sz = new int[m * n + 1];
	}
	
	public int index(int x, int y) { return x * n + y + 1; }
	
	public int size() { return this.count; }
	
	public int getId(int x, int y) {
		if (0 <= x && x < m && 0 <= y && y < n)
			return id[index(x, y)];
		return 0;
	}
	
	public int add(int x, int y) {
		int i = index(x, y);
		id[i] = i; sz[i] = 1;
		++count;
		return i;
	}
	
	public boolean find(int p, int q) {
		return root(p) == root(q);
	}
	
	// sz keep the the # of subtree with i as root
	// therefore we need to find the roots first
	public void union(int p, int q) {
		int i = root(p), j = root(q); 
		if (sz[i] < sz[j]) {
			id[i] = j; sz[j] += sz[i];
		} else {
			id[j] = i; sz[i] += sz[j];
		}
		--count;
	}
	
	// path compression
	private int root(int i) {
		while (i != id[i]) {
			id[i] = id[id[i]];
			i = id[i];
		}
		return i;
	}
}