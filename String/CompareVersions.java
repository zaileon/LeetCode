
public class CompareVersions {
//	public int compareVersion(String version1, String version2) {
//		String[] seg1 = version1.split("\\.");
//		String[] seg2 = version2.split("\\.");
//		int i = 0, n1, n2;
//		for (; i < Math.max(seg1.length, seg2.length); i++) {
//			n1 = i < seg1.length ? Integer.parseInt(seg1[i]) : 0;
//			n2 = i < seg2.length ? Integer.parseInt(seg2[i]) : 0;
//			if (n1 > n2) return 1;
//			else if (n1 < n2) return -1;
//		}
//		return 0;
//	}
	
	public int compareVersion(String version1, String version2) {
		int i1 = 0, i2 = 0;
		int n1 = 0, n2 = 0;
		while (i1 < version1.length() || i2 < version2.length()) {
			while (i1 < version1.length() && version1.charAt(i1) != '.') {
				n1 = n1 * 10 + version1.charAt(i1) - '0';
				i1++;
			}
			while (i2 < version2.length() && version2.charAt(i2) != '.') {
				n2 = n2 * 10 + version2.charAt(i2) - '0';
				i2++;
			}
			if (n1 > n2) return 1;
			else if (n1 < n2) return -1;
			n1 = n2 = 0;
			i1++; i2++;
		}
		return 0;
	}
	

	public static void main(String[] args) {
		CompareVersions cv = new CompareVersions();
		System.out.println(cv.compareVersion("1.0", "1")); // 0
		System.out.println(cv.compareVersion("1.1", "1.1")); // 0
		System.out.println(cv.compareVersion("1.1", "1.1.2")); // -1
		System.out.println(cv.compareVersion("1.1.3", "1.1")); // 1
		System.out.println(cv.compareVersion("2.3", "2.2")); // 1
	}

}
