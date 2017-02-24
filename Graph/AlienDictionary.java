import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AlienDictionary {

	public String alienOrder(String[] words) {
		List<List<Integer>> adj = new ArrayList<>();
		for (int i = 0; i < 26; i++) {
			adj.add(new ArrayList<>());
		}
		int[] visited = new int[26];
		Arrays.fill(visited, -1); // by default, non-exist
		for (int i = 0; i < words.length; i++) {
			String s = words[i];
			for (int j = 0; j < s.length(); j++)
				visited[s.charAt(j) - 'a'] = 0; // if appear, set to 0
			if (i > 0) {
				int j = 0, len1 = words[i - 1].length(), len2 = words[i].length();
				while (j < len1 && j < len2 && words[i - 1].charAt(j) == words[i].charAt(j))
					j++;
				if (j == len1 || j == len2) {
					if (len1 > len2)
						return ""; // case of ["wrtkj","wrt"]
				} else {
					adj.get(words[i - 1].charAt(j) - 'a').add(words[i].charAt(j) - 'a');
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 26; i++) {
			if (visited[i] == 0 && !dfs(adj, visited, i, sb))
				return "";
		}
		return sb.reverse().toString();
	}

	private boolean dfs(List<List<Integer>> adj, int[] visited, int i, StringBuilder sb) {
		visited[i] = 1; // visiting
		for (int j : adj.get(i)) {
			if (visited[j] == 1)
				return false; // cycle detected, return false;
			if (visited[j] == 0 && !dfs(adj, visited, j, sb))
				return false; // j unvisited, but failed to visit
		}
		visited[i] = 2; // finish visited
		sb.append((char) (i + 'a'));
		return true;
	}

	public static void main(String[] args) {
		AlienDictionary ad = new AlienDictionary();
		// String[] words = {"wrtkj", "wrt"};
		String[] words = { "wrt", "wrt" };
		// String[] words = {"wrt", "wrtkj"};
		// String[] words = {"z", "z"};
		// String[] words = {"wrt", "wrf", "er", "ett", "rftt"};
		System.out.println(ad.alienOrder(words));
	}

}
