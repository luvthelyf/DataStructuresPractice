package ds.program.lc.medium;

/**
 * 238. Product of Array Except Self
 * Medium
 *
 * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
 *
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,4]
 * Output: [24,12,8,6]
 * Example 2:
 *
 * Input: nums = [-1,1,0,-3,3]
 * Output: [0,0,9,0,0]
 *
 *
 * Constraints:
 *
 * 2 <= nums.length <= 105
 * -30 <= nums[i] <= 30
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 *
 *
 * Follow up:
 *
 * Could you solve it in O(n) time complexity and without using division?
 * Could you solve it with O(1) constant space complexity? (The output array does not count as extra space for space complexity analysis.)
 */
public class ProductOfArrayThanSelf {
    public int[] productExceptSelf(int[] nums) {

        int[] ans = new int[nums.length];

        ans[0] = 1;

        for(int i = 1; i < nums.length; i++) {
            ans[i] = ans[i - 1] * nums[i - 1];
        }

        int end = 1;

        for(int i = nums.length - 1; i >= 0; i--) {
            ans[i] = ans[i] * end;
            end *= nums[i];
        }
        return ans;
    }
}
