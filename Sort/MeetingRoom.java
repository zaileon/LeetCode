import java.util.Arrays;

public class MeetingRoom {

	public boolean canAttendMeetings(Interval[] intervals) {
		if (intervals == null || intervals.length <= 1) return true;
		Arrays.sort(intervals, (interval1, interval2) -> interval1.start - interval2.start);
		for (int i = 1; i < intervals.length; i++) {
			if (intervals[i].start < intervals[i - 1].end) return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		MeetingRoom mr = new MeetingRoom();
		Interval[] intervals = new Interval[] {new Interval(0,30), new Interval(5,10), new Interval(15, 20)};
		System.out.println(mr.canAttendMeetings(intervals));
	}
}
