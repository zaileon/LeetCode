import java.util.Arrays;
import java.util.Stack;

public class AddTwoNumbersII {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		Stack<Integer> s1 = createStack(l1);
		Stack<Integer> s2 = createStack(l2);
		int sum = 0;
		ListNode curr = new ListNode(0);
		while (!s1.isEmpty() || !s2.isEmpty()) {
			if (!s1.isEmpty()) sum += s1.pop();
			if (!s2.isEmpty()) sum += s2.pop();
			curr.val = sum % 10;
			ListNode head = new ListNode(sum / 10);
			head.next = curr;
			curr = head;
			sum /= 10;
		}
		return curr.val == 0 ? curr.next : curr;
	}
	
	private Stack<Integer> createStack(ListNode l) {
		Stack<Integer> s = new Stack<>();
		while (l != null) { s.push(l.val); l = l.next; }
		return s;
	}
	
	public static void main(String[] args) {
		AddTwoNumbersII atn = new AddTwoNumbersII();
//		ListNode l1 = ListUtils.buildList(Arrays.asList(7, 2, 4, 3));
//		ListNode l2 = ListUtils.buildList(Arrays.asList(5, 6, 4));
		ListNode l1 = ListUtils.buildList(Arrays.asList(7, 2, 4, 3));
		ListNode l2 = ListUtils.buildList(Arrays.asList(2, 7, 6, 4));
		ListNode l3 = atn.addTwoNumbers(l1, l2);
		while (l3 != null) {
			System.out.println(l3.val);
			l3 = l3.next;
		}
	}

}
