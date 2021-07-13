package ds.program.array;

import java.util.HashMap;

public class SubarrayWithExactlyKDistinctNumbers {

    public static void main(String[] args) {
        output("323","1253234");
        System.out.println(new SubarrayWithExactlyKDistinctNumbers().subarraysWithKDistinct(new int[]{1, 2, 1, 2, 3}, 2));
    }

    private static void output(String s2, String s1) {
        int m = s2.length();
        int n = s1.length();

        for(int i = 0; i <= n-m; i++) {
            int j;
            for(j = 0; j < m; j++) {
                if(s1.charAt(i+j) != s2.charAt(j)) {
                    break;
                }
            }
            if(j == m) {
                System.out.println(i);
            }
        }
    }

    public int subarraysWithKDistinct(int[] A, int K) {
        return subArraysWithAtMostKDistinct(A, K) - subArraysWithAtMostKDistinct(A, K - 1);
    }

    private int subArraysWithAtMostKDistinct(int[] arr, int k) {
        int left = 0;
        int ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int right = 0; right < arr.length; right++) {
            int num = arr[right];

            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
            while (map.size() > k) {
                int leftNum = arr[left];
                num = map.get(leftNum);
                map.put(leftNum, num - 1);

                if (num == 1) {
                    map.remove(leftNum);
                }
                left++;
            }

            ans += (right - left + 1);
        }
        return ans;
    }
}
