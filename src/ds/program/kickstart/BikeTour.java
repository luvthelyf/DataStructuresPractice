package ds.program.kickstart;

import java.util.Scanner;


public class BikeTour {
    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            System.out.println("Case #" + (t + 1) + ": " + bikeTour(arr, n));
        }
    }

    public static int bikeTour(int arr[], int n) {

        int count = 0;
        for (int i = 1; i < n - 1; i++) {
            if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1])
                count++;
        }
        return count;

    }
}