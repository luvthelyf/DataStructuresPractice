package ds.program.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class MinWindowContainingAllCharOfItself {
    public static void main(String[] args) {
        System.out.println(new MinWindowContainingAllCharOfItself().findSubString(
//                "AABBBCBBAC"
//                "aaab"
//                "GEEKSGEEKSFOR"
                "aabcbcdbca"  // abcd
        ));
    }

    public String findSubString(String str) {
        // Your code goes here
        HashSet<Character> set = new HashSet<>();
        HashMap<Character, Integer> map = new HashMap<>();

        int start = 0;
        int len = str.length();
        char[] arr = str.toCharArray();

        for (int i = 0; i < len; i++) {
            set.add(str.charAt(i));
        }

        int count = set.size();
        int ans = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;

        for (int end = 0; end < len; end++) {
            map.put(arr[end], map.getOrDefault(arr[end], 0) + 1);

            while (map.size() >= count) {
                map.put(arr[start], map.get(arr[start]) - 1);
                if (map.get(arr[start]) == 0) {
                    map.remove(arr[start]);
                }
                if (ans > (end - start + 1)) {
                    ans = end - start + 1;
                    left = start;
                    right = end;
                }
                start++;
            }
        }
        return str.substring(left, right + 1);

    }

    public int aestheticArrangement(int[] arr) {
        boolean isAlreadyAesthetic = false;
        LinkedList<Integer> list = new LinkedList<>();

        for (int i : arr) {
            list.add(i);
        }

        for (int i = 0; i < list.size() - 2; i++) {
            if(isAestheticallyIncreasing(list,i)) {
                isAlreadyAesthetic = true;
            } else if(isAestheticallyDecreasing(list, i)) {
                isAlreadyAesthetic = true;
            } else {
                isAlreadyAesthetic = false;
                break;
            }

        }

        if(isAlreadyAesthetic) return 0;
        int count = 0;
        LinkedList<Integer> ab = new LinkedList<>();

        for (int i = 0; i < arr.length; i++) {
            ab.clear();
            ab.addAll(list);
            ab.remove(i);
            int f = 0;
            boolean okay = false;
            while (f < arr.length - 3) {
                if (!okay && f != 0) {
                    break;
                }
                if (isAestheticallyIncreasing(ab, f)) {
                    okay = true;
                } else if (isAestheticallyDecreasing(ab, f)) {
                    okay = true;
                } else {
                    okay = false;
                }
                f++;
            }
            if (okay) {
                count++;
            }
        }
        if (count == 0)
            count = -1;

        return count;
    }

    private boolean isAestheticallyIncreasing(LinkedList<Integer> list, int pos) {
        return list.get(pos) > list.get(pos + 1) && list.get(pos + 1) < list.get(pos + 2);
    }

    private boolean isAestheticallyDecreasing(LinkedList<Integer> list, int pos) {
        return list.get(pos) < list.get(pos + 1)  && list.get(pos + 1) > list.get(pos + 2);
    }
}
