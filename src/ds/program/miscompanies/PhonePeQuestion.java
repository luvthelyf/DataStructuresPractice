package ds.program.miscompanies;

import java.util.Arrays;

public class PhonePeQuestion {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new PhonePeQuestion().findMaxHead("THT")));
        System.out.println(Arrays.toString(new PhonePeQuestion().findMaxHead("HHH")));
        System.out.println(Arrays.toString(new PhonePeQuestion().findMaxHead("TTTHHTH")));
        System.out.println(Arrays.toString(new PhonePeQuestion().findMaxHead("HTHTHTHT")));
        System.out.println(Arrays.toString(new PhonePeQuestion().findMaxHead("TTTHHTH")));
        System.out.println(Arrays.toString(new PhonePeQuestion().findMaxHead("T")));
        System.out.println(Arrays.toString(new PhonePeQuestion().findMaxHeadFlip("THHHTHHTTTHTHTHHHTHTHTTTTTTTHHTTHHHHHHHHHTTHTHHHHHTTHTHTTTTTTHTTTTTHHHHHTHTTHHHHTHTHHHTTTHTHHTTHHTHHHHTTHHHHTTTHTTHTTTHHHHHHHTTTTHTHHTTHHHHHTHHTTHHHHHHHHTTHHTTHTHHHTTHTHHTHTTHTHTHHHTTHHTTHTTHHHTTTHHHHHHHHTTTHTHTHHTHTTTHTTTHHTHTHHHHHHHHTTTTHHTHHTHTTTT")));
//        System.out.println(new PhonePeQuestion().maxChocolate(new int[] {4, 3, 6, 10,5}));
    }

    private int[] findMaxHeadFlip(String str) {
        int[] arr = new int[str.length()];

        for(int i = 0; i < str.length(); i++) {
            arr[i] = str.charAt(i) == 'T'? 1 : -1;
        }
        int max_so_far = 0;
        int max_ending_here = 0;
        int start = 0, end = 0;
        int beg = 0;
        for (int i = 0; i < arr.length; i++) {
            max_ending_here = max_ending_here + arr[i];
            if (max_ending_here < 0) {
                max_ending_here = 0;
                beg = i + 1;
            }
            if (max_so_far < max_ending_here) {
                max_so_far = max_ending_here;
                start = beg + 1;
                end = i + 1;
            }
        }
        return new int[]{start, end};
    }

    private int[] findMaxHead(String str) {
        int[] ans = new int[2];
        boolean isTExists = false;
        int max = 0;
        int s = -1;
        int count = 0;
        char[] arr = str.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 'T') {
                isTExists = true;
                if (s == -1) {
                    s = i;
                }
                count++;
            } else {
                if (max < count) {
                    max = count;
                    ans = new int[]{s + 1, i};
                }
                s = -1;
                count = 0;
            }
        }
        if (!isTExists) return new int[]{0, 0};
        else if (max < count) ans = new int[]{s + 1, arr.length};
        return ans;

    }

    public int maxChocolate(int[] arr) {
        int n = arr.length;
        int value1 = arr[0];
        if (n == 1)
            return value1;

        int value2 = Math.max(arr[0], arr[1]);
        if (n == 2)
            return value2;

        int max_val = 0;

        for (int i = 2; i < n; i++) {
            max_val = Math.max(arr[i] + value1, value2);
            value1 = value2;
            value2 = max_val;
        }

        return max_val;

    }
}
