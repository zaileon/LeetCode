
public class SmallestGoodBase {
	
	public String smallestGoodBase(String n) {
		long num = 0;
		for (int i = 0; i < n.length(); i++) num = num * 10 + n.charAt(i) - '0';
		long x = 1;
		for (int m = 62; m >= 1; m--) {
			if ((x << m) < num) {
				long l = 1, r = (long)Math.pow(num, 1.0/m) + 1; 
				while (l < r) {
					long mid = l + (r - l) / 2;
					long sum = 0, curr = 1;
					for (int i = 0; i <= m; i++) {
						sum += curr;
						curr *= mid;
					}
					if (sum == num) return String.valueOf(mid);
					else if (sum > num) r = mid - 1;
					else l = mid + 1;
				}
			}
		}
		return String.valueOf(num - 1);
	}

	public static void main(String[] args) {
		SmallestGoodBase sgb = new SmallestGoodBase();
		System.out.println(sgb.smallestGoodBase("16035713712910627")); // 502
		System.out.println(sgb.smallestGoodBase("2251799813685247")); // 2
		System.out.println(sgb.smallestGoodBase("13")); // 3
		System.out.println(sgb.smallestGoodBase("4681")); // 8
		System.out.println(sgb.smallestGoodBase("1000000000000000000")); // 999999999999999999
	}

}
