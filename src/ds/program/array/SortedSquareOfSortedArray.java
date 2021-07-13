package ds.program.array;

public class SortedSquareOfSortedArray {
    public int[] sortedSquares(int[] nums) {

        int[] ans = new int[nums.length];


        int negativeIndex = 0;
        int positiveIndex = 0;

        for (int i = 0; i < nums.length && nums[i] < 0; i++) {
            negativeIndex++;
        }

        positiveIndex = negativeIndex + 1;

        int ansIndex = 0;

        while (negativeIndex >= 0 && positiveIndex < nums.length) {
            int positiveNum = nums[positiveIndex];
            int negativeNum = nums[negativeIndex];

            if(positiveNum * positiveNum < negativeNum * negativeNum) {
                ans[ansIndex] = positiveNum * positiveNum;
                ansIndex++;
                positiveIndex++;
            } else {
                ans[ansIndex] = negativeNum * negativeNum;
                ansIndex++;
                negativeIndex--;
            }
        }



        while(negativeIndex >= 0) {
            ans[ansIndex++] = nums[negativeIndex] * nums[negativeIndex];
            negativeIndex--;
        }

        while(positiveIndex < nums.length) {
            ans[ansIndex++] = nums[positiveIndex] * nums[positiveIndex];
            positiveIndex++;
        }

        return ans;
    }


    public static void main(String[] args) {

    }
}
