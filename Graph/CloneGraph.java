import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneGraph {
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
		return clone(node, map);
	}
	
	private UndirectedGraphNode clone(UndirectedGraphNode node, Map<UndirectedGraphNode, UndirectedGraphNode> map) {
		if (node == null) return null;
		if (map.containsKey(node)) return map.get(node);
		UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
		map.put(node, clone);
		for (UndirectedGraphNode n : node.neighbors) {
			clone.neighbors.add(clone(n, map));
		}
		return clone;
	}
	
	public static void main(String[] args) {
		UndirectedGraphNode n0 = new UndirectedGraphNode(0); 
		UndirectedGraphNode n1 = new UndirectedGraphNode(1); 
		UndirectedGraphNode n2 = new UndirectedGraphNode(2);
		UndirectedGraphNode n3 = new UndirectedGraphNode(3);
		UndirectedGraphNode n4 = new UndirectedGraphNode(4);
		UndirectedGraphNode n5 = new UndirectedGraphNode(5);
		n0.neighbors.add(n1); n0.neighbors.add(n5);
		n1.neighbors.add(n2); n1.neighbors.add(n5);
		n2.neighbors.add(n3);
		n3.neighbors.add(n4); n3.neighbors.add(n4);
		n4.neighbors.add(n5); n4.neighbors.add(n5);
		CloneGraph cg = new CloneGraph();
		UndirectedGraphNode ugn = cg.cloneGraph(n0);
		System.out.println(ugn.label);
	}
}

class UndirectedGraphNode {
	int label;
	List<UndirectedGraphNode> neighbors;
	UndirectedGraphNode(int x) { this.label = x; this.neighbors = new ArrayList<>(); }
}