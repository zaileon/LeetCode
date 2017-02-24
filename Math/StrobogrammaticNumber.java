
public class StrobogrammaticNumber {
	
	// num is a valid number, so no need to test the initial 0
	// 696 covers 69 and 96
	public boolean isStrobogrammatic(String num) {
		for (int i = 0, j = num.length() - 1; i <= j; i++, j--) {
			if (!"00 11 88 696".contains(num.charAt(i) + "" + num.charAt(j))) return false;
		}
		return true;
	}

	public static void main(String[] args) {
		StrobogrammaticNumber sn = new StrobogrammaticNumber();
		System.out.println(sn.isStrobogrammatic("619"));
		System.out.println(sn.isStrobogrammatic("11"));
		System.out.println(sn.isStrobogrammatic("121"));
		System.out.println(sn.isStrobogrammatic("101"));
		System.out.println(sn.isStrobogrammatic("181"));
	}

}
