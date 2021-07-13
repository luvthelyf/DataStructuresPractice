package ds.program.array;

import java.util.HashMap;

public class IdenticalPairCount {
    public static void main(String[] args) {

        int[] arr = new int[] {3,5,6,3,3,5};

        System.out.println((new IdenticalPairCount()).identicalPairCount(arr));
    }

    private int identicalPairCount(int[] arr) {

        int count = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int num : arr) {
            if(!map.containsKey(num)) {
                map.put(num, 0);
            } else {
                int val = map.get(num);

                if(val >= 1) {
                    count += val + 1;
                    if(count > 1000000000) return 1000000000;
                } else {
                    count++;
                    if(count > 1000000000) return 1000000000;
                }

                map.put(num, val + 1);
            }
        }
        return count;
    }


}
