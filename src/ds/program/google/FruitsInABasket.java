package ds.program.google;

import java.util.Arrays;
import java.util.HashMap;

public class FruitsInABasket {
    public static void main(String[] args) {
        System.out.println((new FruitsInABasket()).totalFruit(new int[] {3,3,3,1,2,1,1,2,3,3,4}));
    }
    public int totalFruit(int[] tree) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = Integer.MIN_VALUE;

        int start = 0;


        for(int i = 0; i < tree.length; i++) {
            int ele = tree[i];
            map.put(ele, map.getOrDefault(ele, 0) + 1);

            while(map.size() > 2) {
                map.put(tree[start], map.get(tree[start]) - 1);
                if(map.get(tree[start]) == 0) {
                    map.remove(tree[start]);
                }
                start++;
            }
            ans = Math.max(ans, i - start + 1);

        }
        return ans;
    }
}
