package ds.program.lc.hard;

/**
 * 42. Trapping Rain Water
 * Hard

 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 * Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
 * Example 2:
 *
 * Input: height = [4,2,0,3,2,5]
 * Output: 9
 *
 *
 * Constraints:
 *
 * n == height.length
 * 0 <= n <= 3 * 104
 * 0 <= height[i] <= 105
 */
public class TrappingRainWater {
    public int trap(int[] height) {
        if(height.length == 0) return 0;
        int maxIndex = 0;

        for(int i = 0; i < height.length; i++) {
            if(height[maxIndex] < height[i])
                maxIndex = i;
        }

        int ans = 0;
        int leftMaxIndex = 0;

        for(int i = 0; i < maxIndex; i++) {
            if(height[i] < height[leftMaxIndex]) {
                ans += (height[leftMaxIndex] - height[i]);
            } else
                leftMaxIndex = i;
        }

        int rightMaxIndex = height.length - 1;

        for(int i = rightMaxIndex; i > maxIndex; i--) {
            if(height[i] < height[rightMaxIndex]) {
                ans += (height[rightMaxIndex] - height[i]);
            } else
                rightMaxIndex = i;
        }

        return ans;
    }
}
