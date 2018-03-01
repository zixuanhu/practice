import java.util.Arrays;
public class MeetingRoom {
    public class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    public boolean canAttendMeetings(Interval[] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a.start != b.start) {
                return Integer.compare(a.start, b.start);
            }
            return 0;
        });
        if (intervals.length < 2) {
            return true;
        }
        int end = intervals[0].end;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start < end) {
                return false;
            }
            end = intervals[i].end;
        }
        return true;

    }
}
