package ds.program.array;

import java.util.Scanner;

public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int t = 0; t < T; t++) {
            int n = sc.nextInt();
            int nums[] = new int[n];
            for(int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
            }

            System.out.println((new ProductOfArrayExceptSelf()).productExceptSelf(nums));
        }
    }
    public int[] productExceptSelf(int[] nums) {

        int result[] = new int[nums.length];

        int prod = 1;
        for(int i = 0; i < nums.length; i++) {
            result[i] = prod;
            prod *= nums[i];
        }
        prod = 1;
        for(int i = nums.length - 1; i >=0; i--) {
            result[i] = prod * result[i-1];
            prod *= nums[i];
        }
        return result;
    }
}
