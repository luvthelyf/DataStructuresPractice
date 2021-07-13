package ds.program.array;

public class SubsetWithSumGreaterThanK {

    public static void main(String[] args) {
        System.out.println((new SubsetWithSumGreaterThanK()).findSubsetWithGivenSumGreaterThanK(new int[]{25, 13, 40}, 50));
    }

    int[][] dp;
    private int findSubsetWithGivenSumGreaterThanK(int[] arr, int K) {
        dp = new int[arr.length][K + 1];
        return (int)Math.pow(2, arr.length) - findSubsetWithGivenSumLessThanOrEqualToK(arr, 0, K) ;
    }

    private int findSubsetWithGivenSumLessThanOrEqualToK(int[] arr, int pos, int sum) {

        if(pos >= arr.length) return 1;

        if(dp[pos][sum] != 0) {
            return dp[pos][sum];
        }

        if(arr[pos] <= sum) {
            dp[pos][sum] = findSubsetWithGivenSumLessThanOrEqualToK(arr, pos + 1, sum - arr[pos]) +
            findSubsetWithGivenSumLessThanOrEqualToK(arr, pos + 1, sum);
        } else {
            dp[pos][sum] = findSubsetWithGivenSumLessThanOrEqualToK(arr, pos + 1, sum);
        }
        return dp[pos][sum];
    }
}
