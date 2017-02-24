import java.util.List;

public class ListUtils {
	
	public static ListNode buildList(List<Integer> elems) {
		ListNode head = new ListNode(elems.get(0));
		ListNode prev = head;
		for (int i = 1; i < elems.size(); i++) {
			ListNode node = new ListNode(elems.get(i));
			prev.next = node;
			prev = node;
		}
		return head;
	}
}
