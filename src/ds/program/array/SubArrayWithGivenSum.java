package ds.program.array;

import java.util.HashMap;

public class SubArrayWithGivenSum {
    private void subArraySum(int[] arr, int sum, int n) {
        int start = 0;
        int currentSum = arr[0];
        for (int i = 1; i < n; i++) {
            while (currentSum > sum && start < i) {
                currentSum -= arr[start];
                start++;
            }
            if (currentSum == sum) {
                System.out.println("subarray with sum = " + sum + " is between position " + (start + 1) + " to " + (i));
                break;
            }
            currentSum += arr[i];
        }

    }

    public static void main(String[] args) {
        int arr[] = {15, 2, 4, 8, 9, 5, 10, 23};
        int n = arr.length;
        int sum = 23;
        for (int i = 0; i < n; i++) System.out.print(arr[i] + " ");
        System.out.println();
        (new SubArrayWithGivenSum()).subArraySum(arr, sum, n);
        int[] arr1 = {10, 2, -2, -20, 10};
        n = arr1.length;
        sum = -10;
        for (int i = 0; i < n; i++) System.out.print(arr1[i] + " ");
        System.out.println();
        (new SubArrayWithGivenSum()).subArraySumWithHashmap(arr1, sum, n);
    }

    private void subArraySumWithHashmap(int[] arr, int sum, int n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int currentSum = 0;
        int start = 0;
        int end = -1;
        for (int i = 0; i < n; i++) {
            currentSum += arr[i];
            if (currentSum - sum == 0) {
                end = i;
                break;
            }
            if (map.containsKey(currentSum - sum)) {
                start = map.get(currentSum - sum);
                end = i;
                break;
            }
            map.put(currentSum, i);
        }
        if (end == -1) System.out.println("No subarray present with sum = " + sum);
        System.out.println("subarray with sum = " + sum + " is between position " + (start + 1) + " to " + (end));

    }

}
