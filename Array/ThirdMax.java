
public class ThirdMax {
	
	public int thirdMax(int[] nums) {
		Integer p1 = null, p2 = null, p3 = null;
		for (int num : nums) {
			// trap num in the first loop when p1 is still null or num >= p1
			if (p1 == null || num >= p1) {
				// trigger the right shift only when num > p1
				if (p1 != null && num > p1) {
					if (p2 != null) p3 = p2;
					p2 = p1;
				}
				p1 = num;
			} else if (p2 == null || num >= p2) {
				if (p2 != null && num > p2) p3 = p2;
				p2 = num;
			} else if (p3 == null || num > p3) {
				p3 = num;
			}
		}
		return p3 == null ? p1 : p3;
	}

	public static void main(String[] args) {
		ThirdMax tm = new ThirdMax();
		System.out.println(tm.thirdMax(new int[] {3,2,1}));    // 1
		System.out.println(tm.thirdMax(new int[] {1,2}));      // 2
		System.out.println(tm.thirdMax(new int[] {2,2,3,1}));  // 1
		System.out.println(tm.thirdMax(new int[] {Integer.MIN_VALUE, Integer.MIN_VALUE, 0}));  // 0
		System.out.println(tm.thirdMax(new int[] {1, Integer.MIN_VALUE, 2}));  // Integer.MIN_VALUE
	}

}
