import java.util.Arrays;

public class MeetingRoomII {
	
	public int minMeetingRooms(Interval[] intervals) {
		int len = intervals.length;
		int[] starts = new int[len];
		int[] ends = new int[len];
		for (int i = 0; i < len; i++) {
			starts[i] = intervals[i].start;
			ends[i]   = intervals[i].end;
		}
		Arrays.sort(starts);
		Arrays.sort(ends);
		int rooms = 0;
		int endsItr = 0;
		for (int i = 0; i < len; i++) {
			if (starts[i] < ends[endsItr]) rooms++;
			else endsItr++;
		}
		return rooms;
	}

	public static void main(String[] args) {
		MeetingRoomII mr = new MeetingRoomII();
//		Interval[] intervals = new Interval[] {new Interval(7,10), new Interval(2,4)};
		Interval[] intervals = new Interval[] {new Interval(0,30), new Interval(5,10), new Interval(15,20)};
		System.out.println(mr.minMeetingRooms(intervals));
	}

}
