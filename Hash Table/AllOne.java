import java.util.HashMap;
import java.util.HashSet;

public class AllOne {
	
	HashMap<Integer, Node> map;
	HashMap<String, Integer> cache;
	Node head, tail;
	
	public AllOne() {
		map = new HashMap<>();
		cache = new HashMap<>();
		head = new Node(0);
		tail = new Node(Integer.MAX_VALUE);
		head.next = tail;
		tail.prev = head;
	}
	
	public void inc(String key) {
		int value = 0;
		Node prev = head;
		if (cache.containsKey(key)) {
			value = cache.get(key);
			prev = map.get(value);
			prev.keys.remove(key);
		}
		cache.put(key, value + 1);
		Node node = map.get(value + 1);
		if (node == null) {
			node = new Node(value + 1);
			map.put(value + 1, node);
			insertAfter(node, prev);
		}
		node.keys.add(key);
		if (prev != head && prev.keys.size() == 0) {
			map.remove(value);
			removeNode(prev);
		}
	}
	
	private void removeNode(Node node) {
		node.next.prev = node.prev;
		node.prev.next = node.next;
	}
	
	private void insertAfter(Node node, Node prev) {
		node.prev = prev;
		node.next = prev.next;
		prev.next = node;
		node.next.prev = node;
	}
	
	public void dec(String key) {
		Integer value = cache.get(key);
		if (value == null) return;
		Node curr = map.get(value);
		Node prev = curr.prev;
		curr.keys.remove(key);
		if (value == 1) {
			cache.remove(key);
		} else {
			cache.put(key, value - 1);
			Node node = map.get(value - 1);
			if (node == null) {
				node = new Node(value - 1);
				map.put(value - 1, node);
				insertAfter(node, prev);
			}
			node.keys.add(key);
		}
		if (curr.keys.size() == 0) {
			map.remove(value);
			removeNode(curr);
		}
	}
	
	public String getMaxKey() {
		if (tail.prev == head) return "";
		return tail.prev.keys.iterator().next();
	}
	
	public String getMinKey() {
		if (head.next == tail) return "";
		return head.next.keys.iterator().next();
	}
	
	class Node {
		int value;
		HashSet<String> keys;
		Node prev, next;
		Node(int v) { value = v; keys = new HashSet<String>(); }
	}
	

	public static void main(String[] args) {
	}

}
