package segment_tree;

public class NumArray {

	class SegmentTreeNode {
		int start, end;
		SegmentTreeNode left, right;
		int sum;
		public SegmentTreeNode(int start, int end) {
			this.start = start;
			this.end = end;
			this.left = null;
			this.right = null;
			this.sum = 0;
		}
	}

	SegmentTreeNode root = null;
	
	public NumArray(int[] nums) {
		root = buildTree(nums, 0, nums.length - 1);
	}
	
	private SegmentTreeNode buildTree(int[] nums, int start, int end) {
		if (start > end) return null;
		SegmentTreeNode node = new SegmentTreeNode(start, end);
		if (start == end) node.sum = nums[start];
		else {
			int mid = start + (end - start) / 2;
			node.left = buildTree(nums, start, mid);
			node.right = buildTree(nums, mid + 1, end);
			node.sum = node.left.sum + node.right.sum;
		}
		return node;
	}
	
	public void update(int i, int val) {
		update(root, i, val);
	}
	
	private void update(SegmentTreeNode node, int i, int val) {
		if (node.start == node.end) node.sum = val;
		else {
			int mid = node.start + (node.end - node.start) / 2;
			if (i <= mid) update(node.left, i, val);
			else update(node.right, i, val);
			node.sum = node.left.sum + node.right.sum;
		}
	}
	
	public int sumRange(int i, int j) {
		return sumRange(root, i, j);
	}
	
	private int sumRange(SegmentTreeNode node, int i, int j) {
		if (node == null || i > node.end || j < node.start) return 0;
		if (i <= node.start && node.end <= j) return node.sum;
		int left = sumRange(node.left, i, j);
		int right = sumRange(node.right, i, j);
		return left + right;
	}
	
	public static void main(String[] args) {
//		int[] nums = {-1};
//		NumArray na = new NumArray(nums);
//		System.out.println(na.sumRange(0, 0));  // -1
//		na.update(0, 1);
//		System.out.println(na.sumRange(0, 0));  // 1
		
		int[] nums = {1,3,5};
		NumArray na = new NumArray(nums);
		System.out.println(na.sumRange(0, 2));  // 9
		na.update(1, 2);
		System.out.println(na.sumRange(0, 2));  // 8
	}
}
