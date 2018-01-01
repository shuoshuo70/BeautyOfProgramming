package Chapter1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Created by shuoshu on 2018/1/1.
 */
public class Meeting {
    public static void main(String[] args) {
        Meeting solution = new Meeting();
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1, 3));
        intervals.add(new Interval(3, 7));
        System.out.println(solution.minMeetRooms(intervals));
    }
    public int minMeetRooms(List<Interval> intervals) {
        List<Element> elements = new ArrayList<>();
        for (Interval interval : intervals) {
            elements.add(new Element(interval.beginTime, true));
            elements.add(new Element(interval.endTime, false));
        }

        Collections.sort(elements, (e1, e2) -> e1.data - e2.data);
        int rooms = 0, maxRooms = 0;

        for (Element element : elements) {
            if (element.isBegin) {
                rooms++;
                maxRooms = Math.max(maxRooms, rooms);
            } else {
                rooms--;
            }
        }

        return maxRooms;
    }
}

class Interval {
    int beginTime;
    int endTime;
    Interval (int beginTime, int endTime) {
        this.beginTime = beginTime;
        this.endTime = endTime;
    }
}

class Element {
    int data;
    boolean isBegin;
    Element (int data, boolean isBegin) {
        this.data = data;
        this.isBegin = isBegin;
    }
}