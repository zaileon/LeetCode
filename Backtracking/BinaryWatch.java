import java.util.ArrayList;
import java.util.List;

public class BinaryWatch {
	
	public List<String> readBinaryWatch(int num) {
	    List<String> times = new ArrayList<>();
	    for (int h=0; h<12; h++)
	        for (int m=0; m<60; m++)
	            if (Integer.bitCount(h * 64 + m) == num)
	                times.add(String.format("%d:%02d", h, m));
	    return times;        
	}

//	public List<String> readBinaryWatch(int num) {
//		List<String> result = new ArrayList<>();
//		if (num > 8) return result;
//		for (int h = Math.max(num - 5, 0); h <= Math.min(3, num); h++) {
//			int m = num - h;
//			backtrackHour(result, h, m, 0);
//		}
//		return result;
//	}
//	
//	private void backtrackHour(List<String> result, int h, int m, int hour) {
//		if (h == 0) {
//			backtrackMinute(result, m, hour, 0);
//			return;
//		}
//		int idx = 0, n = 1;
//		while (n < hour) { idx++; n <<= 1; }
//		for (int i = idx; i < 4; i++) {
//			if (((hour >> i) & 1) == 0 && hour + (1 << i) < 12) {
//				backtrackHour(result, h - 1, m, hour + (1 << i));
//			}
//		}
//	}
//	
//	private void backtrackMinute(List<String> result, int m, int hour, int minute) {
//		if (m == 0) {
//			result.add(String.format("%d:%02d", hour, minute));
//			return;
//		}
//		int idx = 0, n = 1;
//		while (n < minute) { idx++; n <<= 1; }
//		for (int i = idx; i < 6; i++) {
//			if (((minute >> i) & 1) == 0 && minute + (1 << i) < 60) {
//				backtrackMinute(result, m - 1, hour, minute + (1 << i));
//			}
//		}
//	}
	
	public static void main(String[] args) {
		BinaryWatch bw = new BinaryWatch();
		for (String time : bw.readBinaryWatch(2)) {
			System.out.println(time);
		}
	}
}
