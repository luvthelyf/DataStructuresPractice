package ds.program.kickstart;


import java.util.Scanner;

public class BusRoutes {
    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            int n = sc.nextInt();
            long D = sc.nextLong();
            long[] arr = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextLong();
            }
            System.out.println("Case #" + (t + 1) + ": " + busRoutes(arr, n, D));
        }
    }

    public static long busRoutes(long arr[], int n, long D) {
        long ans = D;
        for (int i = n - 1; i >= 0; i--) {
            ans -= ans % arr[i];
        }
        return ans;
    }
}
