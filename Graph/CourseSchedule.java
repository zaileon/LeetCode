import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CourseSchedule {
	
	// DFS
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		boolean[] visited = new boolean[numCourses]; // all visited nodes
		boolean[] path = new boolean[numCourses]; // visited nodes in the current DFS
		List<Set<Integer>> adj = new ArrayList<>();
		for (int i = 0; i < numCourses; i++) adj.add(new HashSet<>());
		for (int[] pre : prerequisites) adj.get(pre[1]).add(pre[0]);
		for (int i = 0; i < numCourses; i++) {
			if (!visited[i] && dfs_cycle(adj, path, visited, i)) return false;
		}
		return true;
	}
	
	private boolean dfs_cycle(List<Set<Integer>> adj, boolean[] path, boolean[] visited, int i) {
		if (visited[i]) return false; // pruning technique; useful during DFS
		path[i] = visited[i] = true;
		for (int j : adj.get(i)) {
			if (path[j] || dfs_cycle(adj, path, visited, j)) return true;
		}
		path[i] = false;
		return false;
	}
	
	// BFS
//	public boolean canFinish(int numCourses, int[][] prerequisites) {
//		int[][] matrix = new int[numCourses][numCourses];
//		int[] indegree = new int[numCourses];
//		for (int[] pre : prerequisites) {
//			if (matrix[pre[1]][pre[0]] == 0) indegree[pre[0]]++;
//			matrix[pre[1]][pre[0]] = 1;
//		}
//		int count = 0;
//		Queue<Integer> queue = new LinkedList<>();
//		for (int i = 0; i < numCourses; i++) {
//			if (indegree[i] == 0) queue.offer(i);
//		}
//		while (!queue.isEmpty()) {
//			int course = queue.poll();
//			count++;
//			for (int i = 0; i < numCourses; i++) {
//				if (matrix[course][i] == 1 && --indegree[i] == 0)
//					queue.offer(i);
//			}
//		}
//		return count == numCourses;
//	}
	
	public static void main(String[] args) {
		CourseSchedule cs = new CourseSchedule();
//		int numCourses = 2; int[][] prerequisites = {{0,1},{1,0}};
		int numCourses = 2; int[][] prerequisites = {{0,1}};
		System.out.println(cs.canFinish(numCourses, prerequisites));
	}
}
