import java.util.*;

public class MergeIntervals {

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

    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> final_list = new LinkedList<Interval>();
        if (intervals.isEmpty()) {
            return final_list;
        }


        Collections.sort(intervals, (a, b) -> {
            if (a.start != b.start) {
                return Integer.compare(a.start, b.end);
            }
            if(a.end!=b.end) return Integer.compare(a.end, b.end);
            return 0;
        });



        int startnumber = intervals.get(0).start;
        int endnumber = intervals.get(0).end;
        System.out.println(startnumber+" "+endnumber);
        for (Interval i : intervals) {
            if (i.start <= endnumber) {
                endnumber = Math.max(i.end, endnumber);
            } else {
                final_list.add(new Interval(startnumber, endnumber));
                startnumber = i.start;
                endnumber = i.end;
            }

        }
        if (final_list.isEmpty() || final_list.get(final_list.size() - 1).end != endnumber) {
            final_list.add(new Interval(startnumber, endnumber));
        }


        return final_list;


    }
}
