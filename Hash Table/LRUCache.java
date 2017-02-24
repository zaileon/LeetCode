import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {
	private LinkedHashMap<Integer, Integer> map;
	private final int CAPACITY;
	public LRUCache(int capacity) {
		CAPACITY = capacity;
		// 
		map = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
			protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
				return size() > CAPACITY;
			}
		};
	}
	
	public int get(int key) {
		return map.getOrDefault(key, -1);
	}
	
	public void put(int key, int value) {
		map.put(key, value);
	}
	

//	private int capacity;
//	private DLinkedNode head, tail;
//	private Map<Integer, DLinkedNode> cache = new HashMap<>();
//	
//	public LRUCache(int capacity) {
//		this.capacity = capacity;
//		this.head = new DLinkedNode();
//		this.tail = new DLinkedNode();
//		head.next = tail;
//		tail.prev = head;
//	}
//	
//	public int get(int key) {
//		DLinkedNode node = cache.get(key);
//		if (node == null) return -1;
//		moveToHead(node);
//		return node.value;
//	}
//	
//	public void put(int key, int value) {
//		DLinkedNode node = cache.get(key);
//		if (node == null) {
//			node = new DLinkedNode(key, value);
//			addFirst(node);
//			cache.put(key, node);
//			if (cache.size() > capacity) {
//				DLinkedNode last = removeLast();
//				cache.remove(last.key);
//			}
//		} else {
//			node.value = value;
//			moveToHead(node);
//		}
//	}
//	
//	private void addFirst(DLinkedNode node) {
//		node.prev = head;
//		node.next = head.next; 
//		head.next.prev = node;
//		head.next = node; 
//	}
//	
//	private void removeNode(DLinkedNode node) {
//		node.prev.next = node.next;
//		node.next.prev = node.prev;
//	}
//	
//	private void moveToHead(DLinkedNode node) {
//		removeNode(node);
//		addFirst(node);
//	}
//	
//	private DLinkedNode removeLast() {
//		DLinkedNode last = tail.prev;
//		removeNode(last);
//		return last;
//	}
//	
//	class DLinkedNode {
//		int key, value;
//		DLinkedNode prev, next;
//		DLinkedNode() {}
//		DLinkedNode(int key, int value) { this.key = key; this.value = value; }
//	}
	
	
	
	public static void main(String[] args) {
		LRUCache cache = new LRUCache(2);
		cache.put(2, 1);
		cache.put(1, 1);
		cache.put(2, 3);
		cache.put(4, 1);
		System.out.println(cache.get(1)); // -1
		System.out.println(cache.get(2)); // 3
		
	}
}
