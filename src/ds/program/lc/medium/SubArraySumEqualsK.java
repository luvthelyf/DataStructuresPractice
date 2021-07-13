package ds.program.lc.medium;

import java.util.HashMap;

/**
 * 560. Subarray Sum Equals K
 * Medium
 * Given an array of integers nums and an integer k, return the total number of continuous subarrays whose sum equals to k.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,1,1], k = 2
 * Output: 2
 * Example 2:
 *
 * Input: nums = [1,2,3], k = 3
 * Output: 2
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 2 * 104
 * -1000 <= nums[i] <= 1000
 * -107 <= k <= 107
 */
public class SubArraySumEqualsK {
    public int subarraySum(int[] nums, int k) {

        int sum = 0;
        int ans = 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for(int end = 0; end < nums.length; end++) {
            sum += nums[end];

            int key = sum - k;
            if(map.containsKey(key))
                ans += map.get(key);

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }
}
