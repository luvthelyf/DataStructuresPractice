package ds.program.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountElements {
    public static void main(String[] args) {

        int[] arr = new int[]/*{1,3,2,3,5,0}*/{2,1,1}/*{1, 3, 2, 3, 5, 0}*//*{1,1,3,3,5,5,7,7}*//*{1,2,3}*/;
//["eat","tea","tan","ate","nat","bat"]
//["abc"]
//["abc","def","ace","bdf"]
// ["cab","tin","pew","duh","may","ill","buy","bar","max","doc"]
        String[] strArr = new String[]{"eat","tea","tan","ate","nat","bat"};
        System.out.println(new CountElements().countElements(arr));
        System.out.println(new CountElements().groupAnagrams(strArr));

    }

    //    public int countElements(int[] arr) {
//        int count = 0;
//        HashMap<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < arr.length; i++) {
//
//
//            if (map.containsKey(arr[i])) {
//
//                int value = map.get(arr[i]);
//                System.out.println(arr[i] + "-->" + (value + 1));
//                map.put(arr[i], value + 1);
//            } else {
//                System.out.println(arr[i] + "--> " + 1);
//                map.put(arr[i], 1);
//            }
//            if (map.containsKey(arr[i] - 1)) {
//                count += map.get(arr[i] - 1);
//
//            }
//        }
//
//        return count;
//    }
    public int countElements(int[] arr) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int val = arr[i];
            System.out.println("**" + val + "**");
            if (!map.containsKey(val) && map.containsKey(val - 1)) {
                System.out.println(val + " not in map && " + (val - 1) + " in map");
                count += map.get(val - 1);
                System.out.println("count=" + count);
            }
            if (map.containsKey(val + 1)) {
                System.out.println((val + 1) + " in map");
                count++;
                System.out.println("count=" + count);
            }

            if (map.containsKey(val)) {

                System.out.println("map[" + val + "] = " + (map.get(val) + 1));
                map.put(val, map.get(val) + 1);
            } else {
                System.out.println("map[" + val + "] = 1");
                map.put(val, 1);
            }
        }
        return count;
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<HashMap<Character, Integer>, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            boolean[] a = new boolean[26];
            HashMap<Character, Integer> countMap = new HashMap<>();
            String val = strs[i];

            for (int c = 0; c < val.length(); c++) {
                char valChar = val.charAt(c);
                if (countMap.containsKey(valChar)) {
                    countMap.put(valChar, countMap.get(valChar) + 1);
                } else {
                    countMap.put(valChar, 1);
                }
            }
            if (map.containsKey(countMap)) {
                map.get(countMap).add(val);
            } else {
                List<String> list = new ArrayList<>();
                list.add(val);
                map.put(countMap, list);
            }
        }
        //System.out.println(map);
        List<List<String>> ans = new ArrayList<>();
        for (List<String> li : map.values()) {
            ans.add(li);
        }
        return ans;
    }
}
////
/*

    public static int stockPairs(List<Integer> stocksProfit, long target) {
    // Write your code here
        // Set<Long> set = new HashSet<>();
        // int ans = 0;

        // for(Integer num : stocksProfit) {
        //     set.add(num.longValue());
        // }

        // for(Integer num : stocksProfit) {
        //     Long diff = target - num;
        //     if(set.contains(diff)) {
        //         ans++;
        //         set.remove(num.longValue());
        //         set.remove(diff);
        //     }
        // }
        // return ans;

        Set<Long> set = new HashSet<>();
        Set<Long> visited = new HashSet<>();

        int ans = 0;

        for(Integer num : stocksProfit) {
            if(visited.contains(target - num.longValue()) && !set.contains(num.longValue())) {
                ans++;
                set.add(num.longValue());
                set.add(target-num.longValue());
            }
            visited.add(num.longValue());

        }
        return ans;
    }

}
 */