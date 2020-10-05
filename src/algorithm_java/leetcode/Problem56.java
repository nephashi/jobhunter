package algorithm.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Interval {
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

public class Problem56 {

    private static boolean isOverlap(Interval i1, Interval i2) {
        if (i1.end < i2.start)
            return false;
        else
            return true;
    }

    public static List<Interval> merge(List<Interval> intervals) {
        intervals.sort(new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if (o1.start < o2.start)
                    return -1;
                else if (o1.start > o2.start)
                    return 1;
                else
                    return 0;
            }
        });

        List<Interval> newIntervals = new ArrayList<>();
        for (int i = 0; i < intervals.size(); i++) {
            Interval curInterval = intervals.get(i);
            int j = 0;
            while (i + j + 1 < intervals.size() && isOverlap(curInterval, intervals.get(i + j + 1))) {
                int newStart = Math.min(curInterval.start, intervals.get(i + j + 1).start);
                int newEnd = Math.max(curInterval.end, intervals.get(i + j + 1).end);
                curInterval = new Interval(newStart, newEnd);
                j++;
            }
            i += j;
            newIntervals.add(curInterval);
        }
        return newIntervals;
    }

    public static void main(String[] args) {
        List<Interval> l = new ArrayList<>();
        l.add(new Interval(1,4));
        l.add(new Interval(0,4));
        List<Interval> n = merge(l);
        System.out.println(" ");

    }
}
