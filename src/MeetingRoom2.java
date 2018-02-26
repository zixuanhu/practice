import java.util.Arrays;

public class MeetingRoom2 {

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

    public int minMeetingRooms(Interval[] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];
        for (int i=0; i <intervals.length; i++) {
            start[i]=intervals[i].start;
            end[i]=intervals[i].end;
        }
        Arrays.sort(start);
        Arrays.sort(end);


        int end_index = 0;
        int amount = 1;

        for (int start_index = 1; start_index < intervals.length; start_index++) {
            if (start[start_index]< end[end_index]) {
                amount++;
            } else {
                end_index++;
            }
        }
        return amount;

    }
}
