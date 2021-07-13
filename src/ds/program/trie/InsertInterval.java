package ds.program.trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
[[1,3],[6,9]]
[2,5]
[[1,2],[3,5],[6,7],[8,10],[12,16]]
[4,8]
[]
[5,7]
[[1,5]]
[2,3]
{{4, 6}, {7, 9}, {1, 2}}
{1, 2}
 */
public class InsertInterval {
    public static void main(String[] args) {
        int[][] arr = {{3, 5}, {6, 7}, {8, 10}, {12, 16}};
        System.out.println(Arrays.deepToString((new InsertInterval()).insert(arr, new int[]{5, 6})));
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        /*
        List<int[]> list to hold merged result
        boolean inserted:
        1. interval[1] < new[0]
            interval add to list
        2. new[1] < interval[0]
            4.1 inserted = false
                insert new to list
                add interval
            4.2
                add interval
        */
        List<int[]> list = new ArrayList<>();
        boolean inserted = false;
        for (int[] interval : intervals) {
//            System.out.println(Arrays.toString(interval));
//            System.out.println(interval[0]+":"+interval[1]);
//            System.out.println(newInterval[0]+":"+newInterval[1]);
            if (interval[1] < newInterval[0]) {
                list.add(interval);
            } else if (newInterval[1] < interval[0]) {
                if (!inserted) {
                    list.add(newInterval);
                    inserted = true;
                }
                list.add(interval);
            } else {
                //merge all other cases to this operation
                newInterval[0] = Math.min(interval[0], newInterval[0]);
                newInterval[1] = Math.max(interval[1], newInterval[1]);
            }
        }
        if (!inserted) {
            list.add(newInterval);
        }
        int[][] result = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            result[i][0] = list.get(i)[0];
            result[i][1] = list.get(i)[1];
        }
        return result;
    }

    public int[][] insert1(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) return new int[][] {{newInterval[0],newInterval[1]}};
        List<int[]> res = new ArrayList<>();
        int start = newInterval[0];
        int end = newInterval[1];
        int i = 0;
        while ( i < intervals.length && intervals[i][1] < newInterval[0]){
            res.add(intervals[i]);
            i++;
        }
        /*if (i == intervals.length){
            res.add(newInterval);
        }
        */
        if ( i < intervals.length && intervals[i][1] >= newInterval[0]){
            start = Math.min(intervals[i][0], start);
        }

        while (i < intervals.length && intervals[i][0] <= newInterval[1]){
            end = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        res.add(new int[]{start,end});
        while ( i < intervals.length){
            res.add(intervals[i]);
            i++;
        }
        return res.toArray(new int[res.size()][2]);

    }
}
