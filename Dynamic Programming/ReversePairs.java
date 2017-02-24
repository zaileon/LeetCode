import java.util.Arrays;

public class ReversePairs {
	
	// similar problems 315/327
/**	
	// Divide and Conquer
	public int reversePairs(int[] nums) {
		if (nums == null || nums.length <= 1) return 0;
		int[] helper = new int[nums.length];
		return mergeSort(nums, 0, nums.length, helper);
	}
	
	private int mergeSort(int[] nums, int s, int e, int[] helper) {
		if (s == e - 1) return 0;
		int mid = s + (e - s) / 2;
		int cnt = mergeSort(nums, s, mid, helper) + mergeSort(nums, mid, e, helper);
		for (int i = s, j = mid; i < mid; i++) {
			while (j < e && nums[i] / 2.0 > nums[j]) j++;
			cnt += j - mid;
		}
		for(int i = s, j = mid, r = s; r < e; ) {
			if (i == mid || (j < e && nums[i] >= nums[j])) helper[r++] = nums[j++];
			else helper[r++] = nums[i++];
		}
		System.arraycopy(helper, s, nums, s, e - s);
		return cnt;
	}
	**/
	
/**	
    //  BST is TLE now, due to its extremely imbalance
	public int reversePairs(int[] nums) {
		int count = 0;
		Node root = null;
		for (int num : nums) {
			count += search(root, 2 * num + 1);
			root = insert(root, num);
		}
		return count;
	}
	
	private int search(Node root, int val) {
		if (root == null) return 0;
		if (root.val == val) return root.sz;
		else if (root.val > val) return root.sz + search(root.left, val);
		else return search(root.right, val);
	}
	
	private Node insert(Node root, int val) {
		if (root == null) root = new Node(val);
		else if (root.val == val) root.sz++;
		else if (root.val > val) root.left = insert(root.left, val);
		else root.right = insert(root.right, val);
		return root;
	}
	
	class Node {
		int val, sz;
		Node left, right;
		Node(int x) { val = x; sz = 1; }
	}
**/	

///**
	// BIT solution
	public int reversePairs(int[] nums) {
		int count = 0;
		int[] copy = Arrays.copyOf(nums, nums.length);
		int[] bit = new int[copy.length + 1];
		Arrays.sort(copy);
		
		for (int num : nums) {
			count += search(bit, index(copy, 2L * num + 1));
			insert(bit, index(copy, num));
		}
		return count;
	}
	
	private int index(int[] arr, long val) {
		int l = 0, r = arr.length - 1, m = 0;
		while (l <= r) {
			m = l + (r - l) / 2;
			if (arr[m] >= val) r = m - 1;
			else l = m + 1;
		}
		return l + 1;
	}
	
	private int search(int[] bit, int i) {
		int sum = 0;
		while (i < bit.length) {
			sum += bit[i];
			i += i & -i;
		}
		return sum;
	}
	
	private void insert(int[] bit, int i) {
		while (i > 0) {
			bit[i] += 1;
			i -= i & -i;
		}
	}
//**/
	
	public static void main(String[] args) {
		ReversePairs rp = new ReversePairs();
//		int[] nums = {1,3,2,3,1}; // 2
//		int[] nums = {-3,-2}; // 1
//		int[] nums = {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE}; // 0
//		int[] nums = {Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE}; // 10
//		int[] nums = {-5,-5}; // 1
		int[] nums = {5,4,3,2,1}; // 4
//		int[] nums = {2,4,3,5,1}; // 3
		System.out.println(rp.reversePairs(nums));
	}
}
