
public class RemoveKDigits {

	public String removeKdigits(String num, int k) {
		char[] cs = num.toCharArray();
		int len = cs.length - k;
		for (int i = 0, top = 0; i < num.length(); i++) {
			while (top > 0 && cs[i] < cs[top - 1] && k > 0) {
				--top;
				--k;
			}
			cs[top++] = cs[i];
		}
		int start = 0;
		while (start < len && cs[start] == '0') start++; 
		return start == len ? "0" : new String(cs, start, len - start);
	}
	
	public static void main(String[] args) {
		RemoveKDigits rkd = new RemoveKDigits();
//		String num = "10"; int k = 2;	// 0
//		String num = "112"; int k = 1;	// 0
//		String num = "10200"; int k = 1; // 200
//		String num = "1432219"; int k = 3; // 1219
//		String num = "21"; int k = 1; // 1
//		String num = "9"; int k = 1; // 0
		String num = "1234567890"; int k = 9; // 0
//		String num = "1000"; int k = 1; // 0
		System.out.println(rkd.removeKdigits(num, k));
	}
}
