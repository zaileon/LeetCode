
public class ReadNCharsMultiple {

	// the difference with once is that every time we read 4 bytes to buffer using read4
	// there may be some left over after copy to buf in the end. The second time can read
	// those left bytes first before read4
	private int start = 0, end = 0;
	private char[] buffer = new char[4];
	public int read(char[] buf, int n) {
		int total = 0;
		while (total < n) {
			// no left over chars, start a new batch
			if (start == 0) {
				end = read4(buffer);
			}
			while (total < n && start < end) {
				buf[total++] = buffer[start++];
			}
			if (start == end) start = 0;
			if (end < 4) break;
		}
		return total;
	}
	
	private int read4(char[] buf) {
		return -1;
	}
	
}
