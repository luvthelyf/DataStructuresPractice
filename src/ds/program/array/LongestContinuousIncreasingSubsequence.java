package ds.program.array;

public class LongestContinuousIncreasingSubsequence {
    public static void main(String[] args) {
        System.out.println(new LongestContinuousIncreasingSubsequence().lcis(new int[]{1, 3, 5, 4, 7}));
    }

    private int lcis(int[] arr) {
        if(arr.length == 0) return 0;
        int count = 1;
//        int start = 0;
        int sum = 1;
        for(int end = 0; end < arr.length - 1; end++) {
//             if(nums[end] >= nums[end + 1]) start = end + 1;

//             if(count < end - start + 2) {
//                 count = end - start + 2;
//             }

            if(arr[end] >= arr[end + 1]) sum = 1;
            else sum++;

            if(count < sum) {
                count = sum;
            }
        }

        return count;
    }
}
