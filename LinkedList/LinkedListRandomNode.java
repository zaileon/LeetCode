public class LinkedListRandomNode {

	// Reservoir sampling
	// https://discuss.leetcode.com/topic/53753/brief-explanation-for-reservoir-sampling
	java.util.Random random;
	ListNode head;
	public LinkedListRandomNode(ListNode head) {
		this.random = new java.util.Random();
		this.head = head;
	}
	
	public int getRandom() {
		ListNode node = head, candidate = head;
		for (int i = 1; node != null; i++) {
			node = node.next;
			if (random.nextInt(i + 1) == i) candidate = node; 
		}
		return candidate.val;
	}
}
