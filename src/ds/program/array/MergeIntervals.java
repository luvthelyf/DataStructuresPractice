package ds.program.array;

import java.util.*;

/*
56. Merge Intervals
Given a collection of intervals, merge all overlapping intervals.

Example 1:

Input: [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
Example 2:

Input: [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 */
public class MergeIntervals {

    public static void main(String[] args) {
//        /*System.out.println(Arrays.deepToString(*/new MergeIntervals().merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}});
        List<Integer> list = new ArrayList<>();
//        list.add(5);
//        list.add(6);
//        list.add(5);
//        list.add(7);
//        list.add(7);
//        list.add(8);


        list.add(1);
        list.add(3);
        list.add(46);
        list.add(1);
        list.add(3);
        list.add(9);
        System.out.println(new MergeIntervals().countUniquePairsWithTargetSum(list,47/*14*/));
    }

//    public int[][] merge(int[][] intervals) {
////        Arrays.sort(intervals, (t1, t2) -> t1[0] - t2[0]);
//        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
//
//        LinkedList<int[]> result = new LinkedList<>();
//        for (int[] interval : intervals) {
//            if (result.isEmpty() || result.getLast()[1] < interval[0]) {
//                result.add(interval);
//            } else {
//                result.getLast()[1] = Math.max(result.getLast()[1], interval[1]);
//            }
//        }
//        return result.toArray(new int[result.size()][2]);
//    }
    LinkedList<int[]> result = new LinkedList<>();
    public void merge(int[][] range) {

        print(null);
//        if(result.size() == 0) result.add(range);

//        else {
////            for(int[] )
//        }

    }
    public int countUniquePairsWithTargetSum(List<Integer> list, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int ans = 0;
        HashSet<String> set = new HashSet<>();
        for (Integer element : list) {
            int diff = target - element;
            if (map.containsKey(diff)) {
                if(diff <= element)
                    set.add(diff + " " + element);
                else
                    set.add(element + " " + diff);
            }
            map.put(element, map.getOrDefault(element, 0) + 1);
//            System.out.println(map);

        }
        return set.size();
    }

    static class Pair {
        int time;
        char type;
        Pair(int time, char type) {
            this.time = time;
            this.type = type;
        }
    }
    public int maxPresentation(List<Integer> start, List<Integer> end) {
        List<Pair> temp = new ArrayList<>();
        int count = 0;
        int ans = 0;
        for(Integer ele : start) {
            temp.add(new Pair(ele, 's'));
        }
        for(Integer ele : end) {
            temp.add(new Pair(ele, 'e'));
        }

        temp.sort(Comparator.comparingInt(o -> o.time));

        for(Pair pair : temp) {
            if(pair.type == 's') count++;
            else count--;
            ans = Math.max(ans, count);
        }
        return ans;
    }
    public void print(String abc){
        System.out.println("sandeep");
    }
    public void print(Object ob) {
        System.out.println("sandy");
    }
}
