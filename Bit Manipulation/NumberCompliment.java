
public class NumberCompliment {

	public int findCompliment(int num) {
		int n = ~num;
//		long mask = 1;
//		while (mask < num) mask <<= 1;
//		return n & ((int)(mask - 1));
		int mask = (Integer.highestOneBit(num) << 1) - 1;
		return n & mask;
	}
	
	public static void main(String[] args) {
		NumberCompliment nc = new NumberCompliment();
		System.out.println(nc.findCompliment(5)); // 2
		System.out.println(nc.findCompliment(1)); // 0
		System.out.println(nc.findCompliment(Integer.MAX_VALUE)); // 0
	}
}
