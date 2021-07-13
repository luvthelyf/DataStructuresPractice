package ds.program.string;

import java.util.*;

/**
 * You're given strings J representing the types of stones that are jewels, and S representing the stones you have.
 * Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.
 * <p>
 * The letters in J are guaranteed distinct, and all characters in J and S are letters. Letters are case sensitive,
 * so "a" is considered a different type of stone from "A".
 * <p>
 * Example 1:
 * <p>
 * Input: J = "aA", S = "aAAbbbb"
 * Output: 3
 * Example 2:
 * <p>
 * Input: J = "z", S = "ZZ"
 * Output: 0
 * Note:
 * <p>
 * S and J will consist of letters and have length at most 50.
 * The characters in J are distinct.
 */
public class JewelsAndStones {
    public static void main(String[] args) {
        System.out.println(new JewelsAndStones().numJewelsInStones("aA", "aAAbbbb"));
//        System.out.println(new JewelsAndStones().solution(6));
//        System.out.println("#" + new JewelsAndStones().largestMAlignedSubset(new int[]{-3, -2, -10, 0, 8, 7, 1}, 3));
//        System.out.println("#" + new JewelsAndStones().largestMAlignedSubset(new int[]{7, 1, 11, 8, 4, 10}, 8));
    }
    int largestMAlignedSubset(int[] A, int M) {
        if (M == 1) return A.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int j : A) {
            int rem = j < 0 ? j % M + M : j % M;
            System.out.println(rem);
            map.put(rem, map.getOrDefault(rem, 0) + 1);
        }
        int res  = 0;
        for (int rem : map.keySet()) {
            res = Math.max(res, map.get(rem));
        }
        return res;
    }
    int solution(int n) {
        int[] d = new int[30];
        int l = 0;
        int p;
        while (n > 0) {
            d[l] = n % 2;
            n /= 2;
            l++;
        }
        for (p = 1; p < l; ++p) {
            int i;
            boolean ok = true;
            for (i = 0; i < l - p; ++i) {
                if (d[i] != d[i + p]) {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                return p;
            }
        }
        return -1;
    }
    public int numJewelsInStones(String J, String S) {
        List<Integer> l = new ArrayList<>();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < J.length(); i++) {
            set.add(J.charAt(i));
        }

        int count = 0;
        for(int i = 0; i < S.length(); i++) {
            if(set.contains(S.charAt(i))) count++;
        }
        return count;
    }
}
