
public class ReadNChars {

	// read into a manually assigned buffer for each batch, then copy to buf
	// say the last bacth reads in only 3 chars, and we only need 2 more (10 - 8)
	public int read(char[] buf, int n) {
		char[] buffer = new char[4];
		for (int i = 0; i < n; i += 4) {
			int len = read4(buffer);
			System.arraycopy(buffer, 0, buf, i, Math.min(len, n - i)); // we might not need all the len chars
			if (len < 4) return Math.min(i + len, n); 
		}
		return n;
	}
	
	private int read4(char[] buf) {
		return -1;
	}
	
}
