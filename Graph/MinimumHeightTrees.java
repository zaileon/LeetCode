import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MinimumHeightTrees {
	
	// BFS. Starting from all leaves, after removing all leaves, the inner nodes that have only one degree become new leaves
	// This is like peel the skin of an onion, layer by layer. The remaining core nodes are the roots of MHT
	// The number of MHT is at most 2
	public List<Integer> findMinHeightTrees(int n, int[][] edges) {
		if (n == 1) return Collections.singletonList(0);
		
		List<Set<Integer>> adj = new ArrayList<>(n);
		for (int i = 0; i < n; i++) adj.add(new HashSet<>());
		for (int[] edge : edges) {
			adj.get(edge[0]).add(edge[1]);
			adj.get(edge[1]).add(edge[0]);
		}
		List<Integer> leaves = new ArrayList<>();
		for (int i = 0; i < n; i++) 
			if (adj.get(i).size() == 1) leaves.add(i);
		
		while (n > 2) {
			n -= leaves.size();
			List<Integer> newLeaves = new ArrayList<>();
			for (int leaf : leaves) {
				int j = adj.get(leaf).iterator().next();
				adj.get(j).remove(leaf); // remove itself from the neighbor (there is only one per leaf), use set for O(1) remove
				if (adj.get(j).size() == 1) newLeaves.add(j);
			}
			leaves = newLeaves;
		}
		return leaves;
	}

	public static void main(String[] args) {
		MinimumHeightTrees mht = new MinimumHeightTrees();
		int n = 2; int[][] edges = {{0,1}};
//		int n = 4; int[][] edges = {{1,0},{1,2},{1,3}};
		for (int i : mht.findMinHeightTrees(n, edges))
			System.out.println(i);
	}

}
