import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class ReconstructItinerary {
	
	public List<String> findItinerary(String[][] tickets) {
		LinkedList<String> itinerary = new LinkedList<>();
		Map<String, Queue<String>> map = new HashMap<>();
		for (String[] ticket : tickets) {
			map.putIfAbsent(ticket[0], new PriorityQueue<String>());
			map.get(ticket[0]).add(ticket[1]);
		}
		dfs(map, itinerary, "JFK"); 
		return itinerary;
	}
	
	private void dfs(Map<String, Queue<String>> map, LinkedList<String> itinerary, String from) {
		while (map.containsKey(from) && !map.get(from).isEmpty())
			dfs(map, itinerary, map.get(from).poll());
		itinerary.addFirst(from);
	}

	public static void main(String[] args) {
//		String[][] tickets = {{"MUC", "LHR"}, {"JFK", "MUC"}, {"SFO", "SJC"}, {"LHR", "SFO"}};
//		String[][] tickets = {{"JFK","SFO"},{"JFK","ATL"},{"SFO","ATL"},{"ATL","JFK"},{"ATL","SFO"}};
		String[][] tickets = {{"JFK","KUL"},{"JFK","NRT"},{"NRT","JFK"}};
		ReconstructItinerary ri = new ReconstructItinerary();
		for (String d : ri.findItinerary(tickets)) {
			System.out.println(d);
		}
	}

}
