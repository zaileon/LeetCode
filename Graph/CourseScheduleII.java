import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CourseScheduleII {

	public int[] findOrder(int numCourses, int[][] prerequisites) {
		List<List<Integer>> adj = new ArrayList<>();
		for (int i = 0; i < numCourses; i++) adj.add(new ArrayList<>());
		for (int[] pre : prerequisites)      adj.get(pre[1]).add(pre[0]);
		boolean[] visited = new boolean[numCourses];
		boolean[] onPath = new boolean[numCourses];
		Stack<Integer> path = new Stack<>();
		for (int i = 0; i < numCourses; i++) {
			if (!dfs(adj, onPath, visited, path, i)) return new int[0];
		}
		int i = 0;
		int[] result = new int[numCourses];
		while (!path.isEmpty()) result[i++] = path.pop();
		return result;
	}
	
	private boolean dfs(List<List<Integer>> adj, boolean[] onPath, boolean[] visited, Stack<Integer> topo, int node) {
		if (visited[node]) return true;
		if (onPath[node]) return false;
		onPath[node] = true;
		for (int i : adj.get(node)) {
			if (!dfs(adj, onPath, visited, topo, i)) return false;
		}
		onPath[node] = false;
		visited[node] = true;
		topo.push(node);
		return true;
	}
	
	public static void main(String[] args) {
		CourseScheduleII cs = new CourseScheduleII();
		int numCourses = 2; int[][] prerequisites = {{0,1},{1,0}};
//		int numCourses = 2; int[][] prerequisites = {{1,0}};
//		int numCourses = 6; int[][] prerequisites = {{0,5},{0,4},{2,5},{1,4},{3,2},{1,3}};
		for (int i : cs.findOrder(numCourses, prerequisites)) {
			System.out.println(i);
		}
	}
}
