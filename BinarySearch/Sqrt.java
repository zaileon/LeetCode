
public class Sqrt {
	
//	public int mySqrt(int x) {
//		if (x <= 0) return 0;
//		int low = 1, hi = x / 2;
//		while (true) {
//			int mid = low + (hi - low) / 2;
//			if (mid > x / mid) hi = mid - 1;
//			else {
//				if ((mid + 1) > x / (mid + 1)) return mid;
//				low = mid + 1;
//			}
//		}
//	}
	
	public int mySqrt(int x) {
		if (x <= 1) return x;
		int left = 1, right = x / 2;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (mid == x / mid) return mid;
			else if (mid < x / mid) left = mid + 1;
			else right = mid - 1;
		}
		return right;
	}

	// Newton method. This one runs fastest at Leetcode
//	public int mySqrt(int x) {
//		long r = x;
//	    while (r*r > x)
//	        r = (r + x/r) / 2;
//	    return (int) r;
//	}
	
	public static void main(String[] args) {
		Sqrt s = new Sqrt();
		System.out.println(s.mySqrt(26));
		System.out.println(s.mySqrt(25));
		System.out.println(s.mySqrt(24));
		System.out.println(s.mySqrt(2));
		System.out.println(s.mySqrt(1));
		System.out.println(s.mySqrt(0));
	}

}
