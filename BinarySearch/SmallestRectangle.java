
public class SmallestRectangle {

	public int minArea(char[][] image, int x, int y) {
		int m = image.length, n = image[0].length;
		int left = searchCol(image, 0, y, 0, m, true);
		int right   = searchCol(image, y + 1, n, 0, m, false);
		int x_start = searchRow(image, 0, x, left, right, true);
		int x_end   = searchRow(image, x + 1, m, left, right, false);
		
		return (right - left) * (x_end - x_start);
	}
	
	private int searchCol(char[][] image, int l, int r, int top, int bottom, boolean left) {
		while (l < r) {
			int mid = l + (r - l) / 2, i = 0;
			while (i < bottom && image[i][mid] == '0') i++; 
			if (i < bottom == left) r = mid;
			else l = mid + 1;
		}
		return l;
	}
	
	private int searchRow(char[][] image, int l, int r, int left, int right, boolean up) {
		while (l < r) {
			int mid = l + (r - l) / 2, i = left;
			while (i < right && image[mid][i] == '0') i++;
			if (i < right == up) r = mid;
			else l = mid + 1;
		}
		return l;
	}
	
	public static void main(String[] args) {
		SmallestRectangle sr = new SmallestRectangle();
		char[][] image = {"11".toCharArray()}; int x = 0, y = 1;
//		char[][] image = {"0010".toCharArray(),"0110".toCharArray(),"0100".toCharArray()}; int x = 0, y = 2;
		System.out.println(sr.minArea(image, x, y));
	}
}
