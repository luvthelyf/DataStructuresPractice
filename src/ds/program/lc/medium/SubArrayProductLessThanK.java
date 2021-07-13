package ds.program.lc.medium;

/**
 * 713. Subarray Product Less Than K
 * Medium
 * <p>
 * Your are given an array of positive integers nums.
 * <p>
 * Count and print the number of (contiguous) subarrays where the product of all the elements in the subarray is less than k.
 * <p>
 * Example 1:
 * Input: nums = [10, 5, 2, 6], k = 100
 * Output: 8
 * Explanation: The 8 subarrays that have product less than 100 are: [10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6].
 * Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.
 * Note:
 * <p>
 * 0 < nums.length <= 50000.
 * 0 < nums[i] < 1000.
 * 0 <= k < 10^6.
 */
public class SubArrayProductLessThanK {
    public static void main(String[] args) {
        System.out.println(new SubArrayProductLessThanK().numSubarrayProductLessThanK(new int[]{10, 5, 2, 6}, 100));
    }

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;

        int prod = 1;
        int start = 0;
        int ans = 0;

        for (int end = 0; end < nums.length; end++) {
            prod *= nums[end];

            while (prod >= k) {
                prod /= nums[start];
                start++;
            }
            ans += (end - start + 1);
        }
        return ans;
    }
}
