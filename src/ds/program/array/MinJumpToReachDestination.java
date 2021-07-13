package ds.program.array;

import java.util.Scanner;

public class MinJumpToReachDestination {
    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            MinJumpToReachDestination obj = new MinJumpToReachDestination();
            System.out.println("Case #" + (t + 1) + ": " + obj.minJump(arr));
        }
    }

    public boolean minJump(int[] arr) {
        if (arr.length == 0) return false;
        int maxReach = arr[0];
        int step = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (i == arr.length - 1) return true;

            maxReach = Math.max(maxReach, i + arr[i]);

            step--;
            if (step == 0) {
                if (i >= maxReach) return false;
                step = maxReach - i;

            }
        }

        return false;
    }
}