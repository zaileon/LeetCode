
public class ContainerWater {
	
	// every time compare left and right boundary
	// move only the lower one, as it is the limiting factor
	// for example, left: height[2]=3, right: height[5]=4, then no matter what height[3]/height[4] is, the area
	// won't be larger than when height[5] is the right boundary
	public int maxArea(int[] height) {
		int area = 0, i = 0, j = height.length - 1;
		while (i < j) {
			int h = Math.min(height[i], height[j]);
			area = Math.max(area, h * (j - i));
			while (height[i] <= h && i < j) i++; // optimization. skip if the moving boundary is even smaller than previous
			while (height[j] <= h && i < j) j--; // same optimization
		}
		return area;
	}
	
	public static void main(String[] args) {
		ContainerWater cw = new ContainerWater();
		int[] height = {1,2};
//		int[] height = {1,1};
		System.out.println(cw.maxArea(height));
	}
}
