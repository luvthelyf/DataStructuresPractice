package ds.program.dp;

public class CollectMaxApplesInTwoGrpNonOverlapping {

    public static void main(String[] args) {
        int[] arr = new int[]{6, 1, 4, 6, 3, 2, 7, 4}/*{10, 19, 15}*/;

        System.out.println((new CollectMaxApplesInTwoGrpNonOverlapping()).maxApplesCollectedForBoth(arr, 3, 2));
    }

    void applesSumCount(int k, int[] allsum, int[] data) {

        int sum = 0, index = 0, i = 0, j = 0;

        while (j < data.length && i <= j) {
            if (j - i + 1 == k) {
                sum += data[j++];
                allsum[index++] = sum;
                sum -= data[i];
                i++;
            } else {
                sum += data[j++];
            }
        }

        for (int value : allsum) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public int maxApplesCollectedForBoth(int[] arr, int K, int L) {
        int[] kApples = new int[arr.length - K + 1];
        int[] lApples = new int[arr.length - L + 1];
        applesSumCount(K, kApples, arr);
        applesSumCount(L, lApples, arr);
        int max = Integer.MIN_VALUE;
        boolean flag;
        for (int i = 0; i < kApples.length; i++) {
            flag = true;
            System.out.println("****************** i = " + i+" *******************");
            for (int j = i + K; j < lApples.length; j++) {
                flag = false;
                System.out.println(kApples[i]+ " + "+lApples[j]);
                if (kApples[i] + lApples[j] > max)
                    max = kApples[i] + lApples[j];
            }
            System.out.println();

            if (flag)
                break;
        }
        for (int i = 0; i < lApples.length; i++) {
            flag = true;
            for (int j = i + L; j < kApples.length; j++) {
                flag = false;
                if (kApples[j] + lApples[i] > max)
                    max = kApples[j] + lApples[i];
            }
            if (flag)
                break;
        }
        if(max == Integer.MIN_VALUE) return -1;
        return max;
    }



//
//    private int nonOverlappingSubsequence(int[] arr, int K, int L) {
//        int res = 0, n = arr.length, kMax = 0, lMax = 0;
//        for (int i = 1; i < n; i++)
//            arr[i] += arr[i - 1];
//        for (int i = K + L - 1; i < n; i++) {
//            kMax = Math.max(kMax, arr[i - L] - ((i == K + L - 1) ? 0 : arr[i - K - L]));
//            lMax = arr[i] - arr[i - L];
//            res = Math.max(res, kMax + lMax);
//        }
//        lMax = arr[L - 1];
//        kMax = arr[K + L - 1] - arr[L - 1];
//        for (int i = K + L - 1; i < n; i++) {
//            lMax = Math.max(lMax, arr[i - K] - ((i - L - K + 1 == 0) ? 0 : arr[i - K - L]));
//            kMax = arr[i] - arr[i - K];
//            res = Math.max(res, kMax + lMax);
//        }
//        return res;
//    }
}
