package tag_01_arraries.code_005_mergeSpace;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution_19_03_13 {

    public static class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
  }

  public List<Interval> merge(List<Interval> intervals){
        if (intervals.size() < 2){
            return intervals;
        }

      Collections.sort(intervals, new Comparator<Interval>() {
          @Override
          public int compare(Interval o1, Interval o2) {
              return o1.start - o2.start;
          }
      });

        int start = 0;
        Interval in1 = null,in2 = null;

        while (start < intervals.size() - 1){
            in1 = intervals.get(start);
            in2 = intervals.get(start+1);

            if (in1.end >= in2.start){
                in1.end = Math.max(in1.end,in2.end);
                intervals.remove(start+1);
            }else {
                start++;
            }
        }
        return intervals;
  }

  public static void main(String[] args){
        List<Interval> list = new ArrayList<>();
        Interval interval = new Interval(1,4);
        list.add(interval);
        Interval interva2 = new Interval(4,5);
        list.add(interva2);

  }



}
