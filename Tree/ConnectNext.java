
public class ConnectNext {
	public void connect(TreeLinkNode root) {
		while (root != null && root.left != null) {
			TreeLinkNode curr = root;
			while (curr != null) {
				curr.left.next = curr.right;
				curr.right.next = curr.next == null ? null : curr.next.left;
				curr = curr.next;
			}
			root = root.left;
		}
	}
}

class TreeLinkNode {
	int val;
	TreeLinkNode left, right, next;
	TreeLinkNode(int x) { this.val = x; }
}