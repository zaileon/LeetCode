import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MergeIntervals {
	
//	public List<Interval> merge(List<Interval> intervals) {
//		Collections.sort(intervals, (i1, i2) -> i1.start - i2.start);
//		List<Interval> result = new ArrayList<>();
//		int i = 0;
//		while (i < intervals.size()) {
//			Interval interval = intervals.get(i++);
//			while (i < intervals.size() && intervals.get(i).start <= interval.end)
//				interval.end = Math.max(interval.end, intervals.get(i++).end);
//			result.add(interval);
//		}
//		return result;
//	}
	
	public List<Interval> merge(List<Interval> intervals) {
		int n = intervals.size();
		int[] starts = new int[n];
		int[] ends = new int[n];
		for (int i = 0; i < n; i++) {
			starts[i] = intervals.get(i).start;
			ends[i] = intervals.get(i).end;
		}
		Arrays.sort(starts);
		Arrays.sort(ends);
		List<Interval> result = new ArrayList<>();
		for (int i = 0, j = 0; j < n; i++) {
			// keep increasing i as long as next segment's start overlap with last segment's end
			// image extending a segment
			// when it's no long extendable, add the segment
			if (i == n - 1 || starts[i + 1] > ends[i]) {
				result.add(new Interval(starts[j], ends[i]));
				j = i + 1;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		MergeIntervals mi = new MergeIntervals();
//		List<Interval> intervals = Arrays.asList(new Interval[] { new Interval(1,4), new Interval(0,2), new Interval(3,5)});
		List<Interval> intervals = Arrays.asList(new Interval[] { new Interval(1,3), new Interval(2, 6), new Interval(8,15), new Interval(15,18)});
		for (Interval interval : mi.merge(intervals)) {
			System.out.print(interval.start);
			System.out.print(" - ");
			System.out.print(interval.end);
			System.out.println("");
		}
	}

}
