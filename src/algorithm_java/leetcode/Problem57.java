package algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Problem57 {

    private static boolean isOverlap(Interval i1, Interval i2) {
        if (i1.start > i2.start) {
            Interval tmp = i2;
            i2 = i1;
            i1 = tmp;
        }
        if (i1.end < i2.start)
            return false;
        else
            return true;
    }

    public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> itvs = new ArrayList<>();
        if (intervals.size() == 0) {
            itvs.add(newInterval);
            return itvs;
        }

        int i = 0;
        while (i < intervals.size() && intervals.get(i).end < newInterval.start) {
            itvs.add(intervals.get(i));
            i++;
        }
        int j = 0;
        Interval bigInterval = newInterval;
        while (i + j < intervals.size() && isOverlap(intervals.get(i + j), bigInterval)) {
            bigInterval = new Interval(Math.min(intervals.get(i + j).start, bigInterval.start),
                    Math.max(intervals.get(i + j).end, bigInterval.end));
            j++;
        }
        itvs.add(bigInterval);
        i += j;
        for (; i < intervals.size(); i++)
            itvs.add(intervals.get(i));
        return itvs;
    }

    public static void main(String[] args) {
        List<Interval> itvs = new ArrayList<>();
        itvs.add(new Interval(1, 5));
        List<Interval> ans = insert(itvs, new Interval(6,8));
        System.out.println();
    }
}
