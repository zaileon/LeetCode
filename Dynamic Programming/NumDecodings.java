
public class NumDecodings {

	public int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;
        int c = s.charAt(0) - '0', cnt = c == 0 ? 0 : 1, prevCnt = 1;
        for (int i = 1; i < s.length(); i++) {
            int p = c, count = 0;
            c = s.charAt(i) - '0';
            if (c != 0) count = cnt;
            if ((p > 0 && p < 2) || (p == 2 && c <= 6)) count += prevCnt;
            prevCnt = cnt;
            cnt = count;
        }
        return cnt;
    }
	
	public static void main(String[] args) {
		NumDecodings nd = new NumDecodings();
		String s = "1203";
		System.out.println(nd.numDecodings(s));
	}

}
