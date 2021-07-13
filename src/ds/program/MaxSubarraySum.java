package ds.program;

public class MaxSubarraySum {

    private static void maximumSum(int[] arr) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        int anotherSum = 0;

        boolean isChangedOnce = false;

        for (int i = 0; i < arr.length; i++) {
            sum = Math.max(arr[i], sum + arr[i]);
            if(sum > 0) {
                sum += arr[i];
                if(!isChangedOnce) {
                    anotherSum = sum + Math.abs(arr[i]);
                    isChangedOnce = true;
                }
            } else {
                sum = arr[i];
                anotherSum = arr[i];
                isChangedOnce = false;
            }
            max = Math.max(max, sum);
            max = Math.max(max, anotherSum);
        }

        System.out.println(anotherSum+"*");
        System.out.println(max);
    }

    public static void main(String[] args) {
//        int[] ans = new MaxSubarraySum().maximumSumarraySum(new int[] {-1,-2,-3,-4,-6});

//        MaxSubarraySum.maximumSum(new int[]{-5, 6, -1, -2, 3, 5, -3});
//        MaxSubarraySum.maximumSum(new int[]{94, 90, -39, 16, -39, -97, -22, -74, 26, 45});

    }
}
