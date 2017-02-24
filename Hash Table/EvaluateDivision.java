import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class EvaluateDivision {
	
	public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        double[] result = new double[queries.length];
        Map<String, Set<Pair>> map = new HashMap<>();
        for (int i = 0; i < equations.length; i++) {
        	map.putIfAbsent(equations[i][0], new HashSet<>());
        	map.putIfAbsent(equations[i][1], new HashSet<>());
        	map.get(equations[i][0]).add(new Pair(equations[i][1], values[i]));
        	map.get(equations[i][1]).add(new Pair(equations[i][0], 1. / values[i]));
        }
        for (int i = 0; i < queries.length; i++) {
			result[i] = dfs(map, queries[i][0], queries[i][1], new HashSet<>(), 1.0);
        }
        return result;
    }
	
	private double dfs(Map<String, Set<Pair>> map, String from, String end, Set<String> route, double res) {
		if (!map.containsKey(from) || route.contains(from)) return -1;
		if (from.equals(end)) return res;
		route.add(from);
		for (Pair p : map.get(from)) {
			double d = dfs(map, p.to, end, route, res * p.value);
			if (d > 0) return d;
		}
//		route.remove(from);
		return -1;
	}

	public static void main(String[] args) {
		EvaluateDivision rd = new EvaluateDivision();
		String[][] equations = {{"a","b"},{"b","c"}}; double[] values = {2.0,3.0};
		String[][] queries = {{"a","c"},{"b","a"},{"a","e"},{"a", "a"}, {"x","x"}};
		for (double res : rd.calcEquation(equations, values, queries)) {
			System.out.println(res);
		}
	}

}

class Pair {
	String to;
	Double value;
	Pair(String to, Double value) { this.to = to; this.value = value; }
}