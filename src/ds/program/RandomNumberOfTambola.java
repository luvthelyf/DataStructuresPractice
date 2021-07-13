package ds.program;

import java.util.HashMap;
import java.util.Random;

public class RandomNumberOfTambola {

    public static void main(String[] args) {
        new RandomNumberOfTambola().generateNumber(100);
    }

    private int generateNumber(int n) {
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = i;
        }

        // 0 1 2 3 4 5  n = 6   randomNum = 2   output = 2
        // 0 1 5 3 4    n = 5   randomNum = 2   output = 5
        // 0 1 4 3      n = 4   randomNum = 3   output = 3
        // 0 1 4        n = 3   randomNum = 0   output = 0
        // 4 1          n = 2   randomNum = 1   output = 1
        // 4            n = 1   randomNum = 0   output = 4


        HashMap<Integer,Integer> map = new HashMap<>();
        while(n > 0) {
            int num = new Random().nextInt(n);
            System.out.print(arr[num]+ " ");
            map.put(arr[num], map.getOrDefault(arr[num], 0) + 1);
            arr[num] = arr[n-1];
            n--;
        }
    // 0 0      1 1         2 4
        // i = 0 j = 2
        System.out.println();
        System.out.println("size of map = " + map.size());
        return 0;
    }
}
