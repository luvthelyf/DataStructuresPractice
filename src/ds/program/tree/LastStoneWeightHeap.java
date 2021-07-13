package ds.program.tree;

import java.util.*;

public class LastStoneWeightHeap {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            System.out.println("*******************************************************************");
            System.out.println((new LastStoneWeightHeap()).lastStoneWeightFastestMethod(arr));
            System.out.println((new LastStoneWeightHeap()).lastStoneWeightTryMethod(arr));
            System.out.println("*******************************************************************");
        }
    }

    public int lastStoneWeight(int[] stones) {
        if (stones.length == 1) return stones[0];
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(Collections.reverseOrder());
        for (Integer stone : stones) {
            queue.add(stone);
        }

        while (queue.size() > 1) {
            Integer a = queue.poll();
            Integer b = queue.poll();

            int nextNum = Math.abs(a - b);
            if (nextNum != 0)
                queue.add(nextNum);
        }
        Integer result = queue.peek();
        return result != null ? result : 0;
    }

    public int lastStoneWeightFastestMethod(int[] stones) {

        // Set up the bucket array.
        int maxWeight = stones[0];
        for (int stone : stones) {
            maxWeight = Math.max(maxWeight, stone);
        }
        int[] buckets = new int[maxWeight + 1];

        // Bucket sort.
        for (int weight : stones) {
            buckets[weight]++;
        }

        // Scan through the buckets.
        int biggestWeight = 0;
        int currentWeight = maxWeight;
        while (currentWeight > 0) {
            if (buckets[currentWeight] == 0) {
                currentWeight--;
            } else if (biggestWeight == 0) {
                buckets[currentWeight] %= 2;
                if (buckets[currentWeight] == 1) {
                    biggestWeight = currentWeight;
                }
                currentWeight--;
            } else {
                buckets[currentWeight]--;
                if (biggestWeight - currentWeight <= currentWeight) {
                    buckets[biggestWeight - currentWeight]++;
                    biggestWeight = 0;
                } else {
                    biggestWeight -= currentWeight;
                }
            }
        }
        return biggestWeight;
    }


    public int lastStoneWeightTryMethod(int[] stones) {
        int maxVal = stones[0];
        for (int stone : stones) {
            maxVal = (Math.max(maxVal, stone));
        }

        int[] bucket = new int[maxVal + 1];

        for (int stone : stones)
            bucket[stone]++;

        int current = maxVal;
        maxVal = 0;


        while (current > 0) {
            if (bucket[current] == 0) {
                current--;
            } else {

                while (maxVal > current && bucket[current] > 0) {
                    if (maxVal - current <= current) {
                        bucket[maxVal - current]++;
                    }
                    maxVal -= current;
                    bucket[current]--;
                }
                if (bucket[current] % 2 == 1) {
                    maxVal = current;
                }
                else if(maxVal <= current) {
                    maxVal = 0;
                }
                current--;
            }
        }
        return maxVal;
    }
}
