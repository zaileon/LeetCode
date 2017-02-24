public class ConnectedComponents {
	
	public int countComponents(int n, int[][] edges) {
		int[] id = new int[n];
		for (int i = 0; i < n; i ++) id[i] = i;
		for (int[] edge : edges) {
			int x = findId(id, edge[0]);
			int y = findId(id, edge[1]);
			if (x != y) {
				id[x] = y;
				n--;
			}
		}
		return n;
	}
	
	private int findId(int[] id, int i) {
		while (i != id[i]) {
			id[i] = id[id[i]];
			i = id[i];
		}
		return i;
	}

	public static void main(String[] args) {
		ConnectedComponents cc = new ConnectedComponents();
		int[][] edges = {{0,1},{1,2},{2,3},{3,4}}; int n = 5;
//		int[][] edges = {{0,1},{1,2},{3,4}}; int n = 5;
		System.out.println(cc.countComponents(n, edges));
	}

}
