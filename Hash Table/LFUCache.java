import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;

public class LFUCache {
	
	private Map<Integer, Node> nodeMap;
	private Map<Integer, Integer> cache;
	private Node head, tail;
	private int capacity;
	
	public LFUCache(int capacity) {
		if (capacity <= 0) return;
		this.capacity = capacity;
		nodeMap = new HashMap<>(capacity);
		cache = new HashMap<>(capacity);
		head = new Node(-1);
		tail = new Node(Integer.MAX_VALUE);
		head.next = tail;
		tail.prev = head;
	}
	
	public int get(int key) {
		if (capacity == 0 || !cache.containsKey(key)) return -1;
		increaseCount(key);
		return cache.get(key);
	}

	public void put(int key, int value) {
		if (capacity == 0) return;
		if (cache.size() == capacity && !cache.containsKey(key)) {
			Iterator<Integer> iterator = head.next.keys.iterator();
			int oldKey = iterator.next();
			iterator.remove();
			if (!iterator.hasNext()) removeNode(head.next);
			nodeMap.remove(oldKey);
			cache.remove(oldKey);
		}
		Node node = nodeMap.get(key);
		if (node == null) {
			nodeMap.put(key, head);
			head.keys.add(key);
		}
		increaseCount(key);
		cache.put(key, value);
	}
	
	private void increaseCount(int key) {
		Node node = nodeMap.get(key);
		node.keys.remove(key);
		
		Node next = node.next;
		if (next.count > node.count + 1) {
			next = new Node(node.count + 1);
			insertAfter(next, node);
		}
		next.keys.add(key);
		nodeMap.put(key, next);
		
		if (node.keys.size() == 0 && node != head) removeNode(node);
	}
	
	private void removeNode(Node node) {
		node.prev.next = node.next;
		node.next.prev = node.prev;
	}
	
	private void insertAfter(Node node, Node prev) {
		node.next = prev.next;
		node.prev = prev;
		prev.next.prev = node;
		prev.next = node;
	}
	
	class Node {
		int count;
		LinkedHashSet<Integer> keys;
		Node prev, next;
		Node(int c) { count = c; keys = new LinkedHashSet<>(); }
	}

	public static void main(String[] args) {
//		LFUCache cache = new LFUCache(0);
//		cache.put(0, 0);
//		System.out.println(cache.get(0));
		
		LFUCache cache = new LFUCache(3);
		cache.put(1, 1);
		cache.put(2, 2);
		cache.put(3, 3);
		cache.put(4, 4);
		System.out.println(cache.get(4)); // 4
		System.out.println(cache.get(3)); // 3
		System.out.println(cache.get(2)); // 2
		System.out.println(cache.get(1)); // -1
		cache.put(5, 5);
		System.out.println(cache.get(1)); // -1
		System.out.println(cache.get(2)); // 2
		System.out.println(cache.get(3)); // 3
		System.out.println(cache.get(4)); // -1
		System.out.println(cache.get(5)); // 5
		
//		LFUCache cache = new LFUCache(2);
//		System.out.println(cache.get(2));  // -1
//		cache.put(2, 6);
//		System.out.println(cache.get(1)); // -1
//		cache.put(1, 5);
//		cache.put(1, 2);
//		System.out.println(cache.get(1)); // 2
//		System.out.println(cache.get(2)); // 6
		
		
//		LFUCache cache = new LFUCache(2);
//		cache.put(2, 1);
//		cache.put(1, 1);
//		cache.put(2, 3);
//		cache.put(4, 1);
//		System.out.println(cache.get(1)); // -1
//		System.out.println(cache.get(2)); // 3
		
//		LFUCache cache = new LFUCache(2);
//		cache.put(1, 1);
//		cache.put(2, 2);
//		System.out.println(cache.get(1));  // 1
//		cache.put(3, 3); // evict 2
//		System.out.println(cache.get(2)); // -1
//		System.out.println(cache.get(3)); // 3
//		cache.put(4, 4); // evict 1
//		System.out.println(cache.get(1)); // -1
//		System.out.println(cache.get(3)); // 3
//		System.out.println(cache.get(4)); // 4
		
//		LFUCache cache = new LFUCache(1);
//		cache.put(2, 1);
//		System.out.println(cache.get(2)); // 1
//		cache.put(3, 2);
//		System.out.println(cache.get(2)); // -1
//		System.out.println(cache.get(3)); // 2
	
	}

}
