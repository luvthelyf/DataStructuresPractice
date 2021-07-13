package ds.program.lc.medium;

/**
 * 152. Maximum Product Subarray
 * Medium

 * Given an integer array nums, find a contiguous non-empty subarray within the array that has the largest product, and return the product.
 *
 * It is guaranteed that the answer will fit in a 32-bit integer.
 *
 * A subarray is a contiguous subsequence of the array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 * Example 2:
 *
 * Input: nums = [-2,0,-1]
 * Output: 0
 * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 2 * 104
 * -10 <= nums[i] <= 10
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 */
public class MaximumProductSubarray {
    public static void main(String[] args) {
        System.out.println(new MaximumProductSubarray().maxProduct(new int[]{2, 3, -2, 4}));
    }

    public int maxProduct(int[] nums) {

        int currentMaxProd = nums[0];
        int currentMinProd = nums[0];

        int ans = currentMaxProd;

        for (int i = 1; i < nums.length; i++) {
            currentMaxProd = Math.max(nums[i], Math.max(currentMaxProd * nums[i], currentMinProd * nums[i]));
            currentMinProd = Math.min(nums[i], Math.min(currentMaxProd * nums[i], currentMinProd * nums[i]));

            ans = Math.max(ans, currentMaxProd);
        }
        return ans;
    }
}
