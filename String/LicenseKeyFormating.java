
public class LicenseKeyFormating {
	
	public String licenseKeyFormatting(String S, int K) {
		int len = S.length(), maxLen = len + len / K + 1;
		char[] cs = new char[maxLen];
		int j = maxLen - 1, j0 = maxLen - 1;
		for (int i = len - 1; i >= 0; i--) {
			char c = S.charAt(i);
			if (c == '-') continue;
			if ((c >= '0' && c <= '9') || (c >= 'A' && c <= 'Z')) 
				cs[j--] = c;
			else if (c >= 'a' && c <= 'z') 
				cs[j--] = (char)(c + 'A' - 'a');  
			if (j0 - j == K) {
				cs[j--] = '-';
				j0 = j;
			}
		}
		j++;
		if (j < maxLen && cs[j] == '-') j ++;
		return new String(cs, j, maxLen - j);
	}

	public static void main(String[] args) {
		LicenseKeyFormating lkf = new LicenseKeyFormating();
//		System.out.println(lkf.licenseKeyFormatting("2", 2)); // "2"
//		System.out.println(lkf.licenseKeyFormatting("---", 3)); // ""
//		System.out.println(lkf.licenseKeyFormatting("aaaa", 2)); // "AA-AA"
//		System.out.println(lkf.licenseKeyFormatting("2-4A0r7-4k", 4)); // "24A0-R74K"
		System.out.println(lkf.licenseKeyFormatting("2-4A0r7-4k", 3)); // "24-A0R-74K"
	}

}
