import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ValidTree {
	
	// Union find
	public boolean validTreeUnion(int n, int[][] edges) {
		if (edges.length != n - 1) return false;
		int[] id = new int[n];
		Arrays.fill(id, -1);
		for (int[] edge : edges) {
			int x = find(id, edge[0]);
			int y = find(id, edge[1]);
			if (x == y) return false;
			id[x] = y;
		}
		return true;
	}
	
	private int find(int[] id, int i) {
		if (id[i] == -1) return i;
		return find(id, id[i]);
	}
	
	
	public boolean validTree(int n, int[][] edges) {
		if (edges.length != n - 1) return false;
		boolean[] vis = new boolean[n];
		List<Integer>[] adj = new ArrayList[n];
		for (int i = 0; i < n; i++) adj[i] = new ArrayList<Integer>();
		for (int[] edge : edges) {
			adj[edge[0]].add(edge[1]);
			adj[edge[1]].add(edge[0]);
		}
		// if (hasCycle(vis, adj, 0, -1)) return false;
		dfs(vis, adj, 0);
		for (int i = 0; i < n; i++) {
			if (!vis[i]) return false;
		}
		return true;
	}
	
	private void dfs(boolean[] vis, List<Integer>[] adj, int i) {
		vis[i] = true;
		for (int j : adj[i]) {
			if (!vis[j]) {
				dfs(vis, adj, j);
			} 
		}
	}
	
	// no duplicate in undirected graph means no [i,j] and [j,i] together
	// if we keep going until we hit a visited node, then there is a cycle
	private boolean hasCycle(boolean[] vis, List<Integer>[] adj, int i, int parent) {
		if (vis[i]) return true;
		vis[i] = true;
		for (int j : adj[i]) {
			if (j != parent && hasCycle(vis, adj, j, i)) return true;
		}
		return false;
	}

	public static void main(String[] args) {
		ValidTree vt = new ValidTree();
		int n = 5; int[][] edges = {{0,1},{0,2},{0,3},{1,4}};
//		int n = 5; int[][] edges = {{0,1},{1,2},{2,3},{1,3},{1,4}};
		System.out.println(vt.validTreeUnion(n, edges));
	}

}
