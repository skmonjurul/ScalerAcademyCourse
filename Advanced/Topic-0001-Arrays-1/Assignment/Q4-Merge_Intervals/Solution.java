/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        if(newInterval.end < newInterval.start) {
            int temp = newInterval.end;
            newInterval.end = newInterval.start;
            newInterval.start = temp;
        }
        ArrayList<Interval> result = new ArrayList<>();

        if(intervals.size() == 0) {
            result.add(newInterval);
            return result;
        }


        boolean isOverLap = false;
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

        for(int i = 0; i < intervals.size(); i++) {
            if(isOverLap(intervals.get(i), newInterval)) {
                isOverLap = true;
                min = Math.min(min, Math.min(intervals.get(i).start, newInterval.start));
                max = Math.max(max, Math.max(intervals.get(i).end, newInterval.end));
            }
            else if(!isOverLap) {
                if(i == 0 && newInterval != null && newInterval.end < intervals.get(i).start) {
                    result.add(newInterval);
                    result.addAll(intervals);
                    break;
                } else if(i == intervals.size() - 1 && newInterval != null && newInterval.start > intervals.get(i).end) {
                    result.add(intervals.get(i));
                    result.add(newInterval);
                    break;
                } else {
                    if(newInterval!= null && newInterval.end < intervals.get(i).start) {
                        result.add(newInterval);
                    }
                    result.add(intervals.get(i));
                }
            }
            else if(isOverLap) {
                result.add(new Interval(min, max));
                result.add(intervals.get(i));
                newInterval = null;
                isOverLap = false;
            }
        }

        if(isOverLap) {
            result.add(new Interval(min, max));
        }

        return result;
    }


    public boolean isOverLap(Interval interval, Interval newInterval) {
        if(newInterval == null) return false;
        if( interval.start <= newInterval.start && newInterval.end <= interval.end) {
            return true;
        }
        else if(newInterval.start <= interval.start && interval.end <= newInterval.end) {
            return true;
        }
        else if(interval.start <= newInterval.start && newInterval.start <= interval.end) {
            return true;
        }
        else if(interval.start <= newInterval.end && newInterval.end <= interval.end) {
            return true;
        }

        return false;
    }
}
