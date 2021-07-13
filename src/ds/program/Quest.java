package ds.program;

public class Quest {

    public static void main(String[] args) {
        System.out.println(new Quest().minTargetSumLength(new int[]{1, 2, 3, 4, 5}, 9));
    }

    public int minTargetSumLength(int[] arr, int target) {
        int ans = Integer.MAX_VALUE;
        int sum = 0;
        int start = 0;

        for (int end = 0; end < arr.length; end++) {
            sum += arr[end];
            while (sum > target) {
                sum -= arr[start];
                start++;
            }
            if (sum == target) {
                ans = Math.min(ans, end - start + 1);
            }
        }


        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
