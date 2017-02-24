
public class ConvertToHexadecimal {

	char[] map = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
	public String toHex(int num) {
		char[] cs = new char[8];
		int offset = 7;
		do {
			cs[offset--] = map[num & 15];
			num >>>= 4;
		} while (num != 0);
		return new String(cs, offset + 1, 7 - offset);
	}
	public static void main(String[] args) {
		ConvertToHexadecimal cth = new ConvertToHexadecimal();
		System.out.println(cth.toHex(Integer.MAX_VALUE));
		System.out.println(cth.toHex(Integer.MIN_VALUE));
		System.out.println(cth.toHex(26));
		System.out.println(cth.toHex(0));
		System.out.println(cth.toHex(-1));
	}

}
