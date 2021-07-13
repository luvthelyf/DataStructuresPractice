package ds.program.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class LongestIncreasingSubsequenceInNCopyOfArrayNLen {
    public static void main(String[] args) {
//        System.out.println(new LongestIncreasingSubsequenceInNCopyOfArrayNLen().largeNum(268));
//        System.out.println(new LongestIncreasingSubsequenceInNCopyOfArrayNLen().largeNum(670));
//        (new LongestIncreasingSubsequenceInNCopyOfArrayNLen()).longestIncreasingSubsequence();
        System.out.println(new LongestIncreasingSubsequenceInNCopyOfArrayNLen().sumToZero(new int[]{0,0,0,0,0,0}));
    }

    public int sumToZero(int[] arr) {
        HashMap<Long, Integer> map = new HashMap<>();
        long count = 0;
        int i = 0;
        long sum = 0;
//        map.put(0L, 1);

        while(i < arr.length) {
            sum += arr[i];
            if(map.containsKey(sum)) {
                count += map.get(sum);
                if(count > 1000000000) return -1;
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
            i++;
        }
        return (int)count;
    }
    private int largeNum(int num) {
        if (num == 0) {
            return 50;
        }
        int negative = num / Math.abs(num);
        num = Math.abs(num);
        int n = num;
        int maxVal = Integer.MIN_VALUE;
        int digits = 0;
        int position = 1;

        while (n > 0) {
            digits++;
            n = n / 10;
        }

        for (int i = 0; i <= digits; i++) {
            int newVal = ((num / position) * (position * 10)) + (5 * position) + (num % position);
            if (newVal * negative > maxVal) {
                maxVal = newVal * negative;
            }

            position = position * 10;
        }

        return maxVal;
    }
    private void longestIncreasingSubsequence() {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t = 0; t < T; t++){
            int n = sc.nextInt();
            int[] arr = new int[n];
            HashSet<Integer> set = new HashSet<>();
            for(int i = 0; i < n; i++){
                arr[i] = sc.nextInt();
                set.add(arr[i]);
            }

            System.out.println(set.size());

        }
    }
}
