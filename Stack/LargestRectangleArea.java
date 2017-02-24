import java.util.ArrayDeque;
import java.util.Deque;

public class LargestRectangleArea {
	
	// O(n) with a stack, find the left and right bounds (exclusive) that are lower than each bar 
	// area is height * (right - left - 1)
//	public int largestRectangleArea(int[] heights) {
//		Deque<Integer> stack = new ArrayDeque<Integer>();
//		int maxArea = 0, i = 0;
//		while (i <= heights.length) {
//			int h = (i == heights.length) ? 0 : heights[i];
//			// if strictly increasing, push
//			// no equal as it will cause TLE
//			if (stack.isEmpty() || h > heights[stack.peek()]) {
//				stack.push(i++);
//			} else {
//				// found the right bound (i) for stack.top at i. The left bound is right underneath 
//				// if stack is empty, no bar on the left is lower than it, the area is height * i
//				maxArea = Math.max(maxArea, heights[stack.pop()] * (stack.isEmpty() ? i : (i - stack.peek() - 1))); 
//			}
//		}
//		return maxArea;
//	}
	
	// The same solution as above, except using an array instead of a stack
	public int largestRectangleArea(int[] heights) {
		int n = heights.length;
		int maxArea = 0;
		int[] stack = new int[n + 1];
		int idx = -1;
		for (int i = 0; i <= n; i++) {
			int h = (i == n) ? 0 : heights[i];
			while (idx != -1 && h < heights[stack[idx]]) {
				int height = heights[stack[idx--]];
				int width = idx == -1 ? i : i - stack[idx] - 1;
				maxArea = Math.max(maxArea, height * width);
			}
			stack[++idx] = i;
		}
		return maxArea;
	}
	
	public static void main(String[] args) {
		LargestRectangleArea lra = new LargestRectangleArea();
		int[] heights = {1,1,1,1,1};
//		int[] heights = {2,1,5,6,2,3};
		System.out.println(lra.largestRectangleArea(heights));
	}
}
