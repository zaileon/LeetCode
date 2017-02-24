
public class FirstBadVersion {
	public int firstBadVersion(int n) {
		int s = 1, e = n;
		while (s < e) {
			int m = s + ((e - s) >> 1);
			if (isBadVersion(m)) e = m;
			else s = m + 1;
		}
		return e;
	}
	
	private boolean isBadVersion(int m) {
		if (m >= 37) return true;
		return false;
	}
	
	public static void main(String[] args) {
		FirstBadVersion fbv = new FirstBadVersion();
		System.out.println(fbv.firstBadVersion(100));
	}
}
