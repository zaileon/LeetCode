
public class ConnectNextII {
	
	
	public void connect(TreeLinkNode root) {
		TreeLinkNode head = null, prev = null, curr = root;
		while (curr != null) {
			while (curr != null) {
				if (curr.left != null) {
					if (prev != null) {
						prev.next = curr.left;
					} else {
						head = curr.left;
					}
					prev = curr.left;
				}
				if (curr.right != null) {
					if (prev != null) {
						prev.next = curr.right;
					} else {
						head = curr.right;
					}
					prev = curr.right;
				}
				
			}
			curr = head;
			head = null;
			prev = null;
		}
	}

//	public void connect(TreeLinkNode root) {
//		TreeLinkNode curr, next, nextSibling;
//		while (root != null) {
//			curr = root;
//			root = findNext(root);
//			if (root != null) root = root.left != null ? root.left : root.right;
//			while (curr != null) {
//				next = findNext(curr.next);
//				nextSibling = next != null ? (next.left != null ? next.left : next.right) : null;
//				if (curr.right != null) {
//					curr.right.next = nextSibling;
//					if (curr.left != null) curr.left.next = curr.right;
//				} else if (curr.left != null) {
//					curr.left.next = nextSibling;
//				}
//				curr = next;
//			}
//		}
//	}
//	
//	private TreeLinkNode findNext(TreeLinkNode node) {
//		while (node != null  && !hasChild(node))  node = node.next;
//		return node != null && hasChild(node) ? node : null;
//	}
//	
//	private boolean hasChild(TreeLinkNode node) {
//		return node.left != null || node.right != null;
//	}
	
	public static void main(String[] args) {
		ConnectNextII cn = new ConnectNextII();
		TreeLinkNode t1 = new TreeLinkNode(-1);
		TreeLinkNode t2 = new TreeLinkNode(-7);
		TreeLinkNode t3 = new TreeLinkNode(-9);
		TreeLinkNode t4 = new TreeLinkNode(-1);
		TreeLinkNode t5 = new TreeLinkNode(-7);
		TreeLinkNode t6 = new TreeLinkNode(8);
		TreeLinkNode t7 = new TreeLinkNode(-9);
		t1.left = t2; t1.right = t3;
		t3.left = t4; t3.right = t5;
		t4.right = t6; t5.left = t7;
		cn.connect(t1);
	}

}
