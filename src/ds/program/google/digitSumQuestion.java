package ds.program.google;

import java.util.Arrays;
import java.util.HashMap;

public class digitSumQuestion {
    HashMap<Integer, Integer> map = new HashMap<>();

    void findNdigitNums(char[] res, int index, int n, int sum) {
        // if number is less than N-digit and its sum of digits is
        // less than the given sum
        if (index < n && sum >= 0) {
            char d = '0';

            // special case - number can't start from 0
            if (index == 0) {
                d = '1';
            }

            // consider every valid digit and put it in the current
            // index and recur for next index
            while (d <= '9') {
                res[index] = d;
                int digit = (d - '0');
                findNdigitNums(res, index + 1, n, sum - digit);
                d++;
            }
        }

        // if number becomes N-digit and its sum of digits is
        // equal to given sum, print it

        else if (index == n && sum == 0) {
            StringBuilder sb = new StringBuilder("");
            sb.append(res[0]).append(res[1]).append(res[2]);
            System.out.println(sb.toString());
            int x = Integer.parseInt(sb.toString());
            prev = x;
            map.put(sum, x);
        }
    }
    int prev;
    public static void main(String[] args) {
        int N = 5;
        int[] arr = new int[N];
        char[] c = new char[]{'0', '0', '0'};
        digitSumQuestion ds = new digitSumQuestion();

        for (int j = 0; j < N; j++) {
            ds.prev = 1;
            for (int i = ds.prev; i <= 1000; i++) {
                int digit = findNumberOfDigits(arr[j]);
                ds.findNdigitNums(c, 0, digit, arr[j]);
            }
        }
    }

    private static int findNumberOfDigits(int num) {
        int count = 0;

        while (num != 0) {
            num /= 10;
            count++;
        }
        return count;
    }
}
