
public class ValidNumber {
	public boolean isNumber(String s) {
		s = s.trim();
		if (s.length() == 0) return false;
		
		boolean dotSeen = false;
		boolean numSeen = false;
		boolean numAfterE = true;
		boolean eSeen = false;
		
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if ('0' <= c && c <= '9') {
				numSeen = true;
				numAfterE = true;
			} else if (c == '.') {
				if (eSeen || dotSeen) return false;
				dotSeen = true;
			} else if (c == 'e') {
				if (eSeen || !numSeen) return false;
				numAfterE = false;
				eSeen = true;
			} else if (c == '+' || c == '-') {
				if (i != 0 && s.charAt(i - 1) != 'e') return false;
			} else
				return false;
		}
		
		return numSeen && numAfterE;
	}
	
	public static void main(String[] args) {
		ValidNumber vn = new ValidNumber();
		System.out.println(vn.isNumber("3.12"));
	}
}
