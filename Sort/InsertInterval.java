import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {
	
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		List<Interval> result = new ArrayList<>();
		int i = 0;
		
		while (i < intervals.size() && intervals.get(i).end < newInterval.start) 
			result.add(intervals.get(i++));
		
		while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
			newInterval.start = Math.min(newInterval.start, intervals.get(i).start);
			newInterval.end   = Math.max(newInterval.end, intervals.get(i).end);
			i++;
		}
		result.add(newInterval);
		
		while (i < intervals.size()) result.add(intervals.get(i++));
		return result;
	}

	public static void main(String[] args) {
		InsertInterval ii = new InsertInterval();
		List<Interval> intervals = Arrays.asList(new Interval[] { new Interval(1,3), new Interval(6, 9)}); Interval newInterval = new Interval(3,6); // 1-9
//		List<Interval> intervals = Arrays.asList(new Interval[] { new Interval(1,3), new Interval(6, 9)}); Interval newInterval = new Interval(4,6); // 1-3,4-9
//		List<Interval> intervals = Arrays.asList(new Interval[] { new Interval(1,3), new Interval(6, 9)}); Interval newInterval = new Interval(3,5); // 1-5, 6-9
//		List<Interval> intervals = Arrays.asList(new Interval[] { new Interval(1,3), new Interval(6, 9)}); Interval newInterval = new Interval(4,5); // 1-3,4-5,6-9 
//		List<Interval> intervals = Arrays.asList(new Interval[] { new Interval(1,3), new Interval(6, 9)}); Interval newInterval = new Interval(2,7); // 1-9
		for (Interval interval : ii.insert(intervals, newInterval)) {
			System.out.print(interval.start);
			System.out.print(" - ");
			System.out.print(interval.end);
			System.out.println("");
		}
	}

}
