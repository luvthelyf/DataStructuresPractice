package ds.program.lc.medium;

import java.util.HashMap;

/**
 * 325. Maximum Size Subarray Sum Equals k
 * Medium
 *
 * Given an integer array nums and an integer k, return the maximum length of a subarray that sums to k. If there isn't one, return 0 instead.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,-1,5,-2,3], k = 3
 * Output: 4
 * Explanation: The subarray [1, -1, 5, -2] sums to 3 and is the longest.
 * Example 2:
 *
 * Input: nums = [-2,-1,2,1], k = 1
 * Output: 2
 * Explanation: The subarray [-1, 2] sums to 1 and is the longest.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * -105 <= k <= 105
 *
 *
 * Follow Up: Can you do it in O(n) time?
 */
public class MaxSizeSubarraySumEqualK {
    public static void main(String[] args) {
        System.out.println(new MaxSizeSubarraySumEqualK().maxSubArrayLen(new int[]{99, 1, -1, 5, -2, 3}, 3));
        System.out.println(new MaxSizeSubarraySumEqualK().maxSubArrayLen(new int[]{1, -1, 5, -2, 3}, 5));
    }
    public int maxSubArrayLen(int[] nums, int k) {
        int ans = 0;
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        for(int end = 0; end < nums.length; end++) {
            sum += nums[end];           // 99    100      99    104     102

            int key = sum - k;
            if(map.containsKey(key))    // 96     97      96    101      99
                ans = Math.max(ans, end - map.get(key));

            if(!map.containsKey(sum)) { // 99: 0   100:1        101:3    4 - 0
                map.put(sum, end);
            }

        }
        return ans;
    }
}
