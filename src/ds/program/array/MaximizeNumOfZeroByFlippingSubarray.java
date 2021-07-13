package ds.program.array;

public class MaximizeNumOfZeroByFlippingSubarray {
    public static void main(String[] args) {
        int[] arr = new int[]{0,1,0,0,1,1,0};
//        System.out.println((new MaximizeNumOfZeroByFlippingSubarray()).maxNumOfZero(arr));
        System.out.println((new MaximizeNumOfZeroByFlippingSubarray()).maxNumOfHeads("THT"));
    }

    private int maxNumOfZero(int[] arr) {
        int zeroCount = 0;
        int ans = 0;
        int currMax = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) zeroCount++;
            int tempVal = arr[i] == 1 ? 1 : -1;
            currMax = Math.max(tempVal, tempVal + currMax);
            ans = Math.max(ans, currMax);

            System.out.println(i+" "+arr[i]+" "+currMax + " "+ans);
        }
        return ans + zeroCount;
    }
    private int maxNumOfHeads(String str) {
        char[] arr = str.toCharArray();
        int headCount = 0;
        int ans = 0;
        int currMax = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 'T') headCount++;
            int tempVal = arr[i] == 'H' ? 1 : -1;
            currMax = Math.max(tempVal, tempVal + currMax);
            ans = Math.max(ans, currMax);

            System.out.println(i+" "+arr[i]+" "+currMax + " "+ans);
        }
        return ans + headCount;
    }
}
