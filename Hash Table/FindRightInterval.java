import java.util.TreeMap;

public class FindRightInterval {

	public int[] findRightInterval(Interval[] intervals) {
		int[] idx = new int[intervals.length];
		TreeMap<Integer, Integer> map = new TreeMap<>();
		for (int i = 0; i < intervals.length; i++) {
			map.put(intervals[i].start, i);
		}
		for (int i = 0; i < intervals.length; i++) {
			Integer index = map.ceilingKey(intervals[i].end);
			idx[i] = (index == null) ? -1 : map.get(index);
		}
		return idx;
	}
	
	public static void main(String[] args) {
		FindRightInterval fri = new FindRightInterval();
		Interval[] intervals = {new Interval(1,4), new Interval(2,3), new Interval(3,4)};
		for (int i : fri.findRightInterval(intervals)) {
			System.out.println(i);
		}
	}
}
