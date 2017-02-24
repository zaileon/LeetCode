import java.util.Arrays;

public class EraseOverlapIntervals {

	// sort by the end time, pick the one that ends early to leave room for other intervals
	public int eraseOverlapIntervals(Interval[] intervals) {
		if (intervals == null || intervals.length <= 1) return 0;
		
		Arrays.sort(intervals, (a, b) -> a.end - b.end);
		int count = 0, end = Integer.MIN_VALUE;
		
		for (Interval interval : intervals) {
			if (interval.start >= end) {
				end = interval.end;
			} else
				count++;
		}
		return count;
	}
	
//	public int eraseOverlapIntervals(Interval[] intervals) {
//		if (intervals == null || intervals.length <= 1) return 0;
//		
//		Arrays.sort(intervals, (a, b) -> a.start - b.start);
//		int count = 0, end = Integer.MIN_VALUE;
//		
//		for (int i = 0; i < intervals.length; i++) {
//			if (intervals[i].start < end) {
//				count++;
//				end = Math.min(end, intervals[i].end);
//			} else
//				end = intervals[i].end;
//		}
//		return count;
//	}
	
	public static void main(String[] args) {
		EraseOverlapIntervals eoi = new EraseOverlapIntervals();
		Interval[] intervals = {new Interval(1,2), new Interval(2,3), new Interval(3,4), new Interval(1,3)};
		System.out.println(eoi.eraseOverlapIntervals(intervals));
	}
}
