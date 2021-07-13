package ds;

import java.util.HashMap;

public class JewelsAndStones {
    public static void main(String[] args) {
        int arr[] = new int[] {555,901,482,1771};
        System.out.println(new JewelsAndStones().numJewelsInStones("aA", "aAAbbbb"));
    }
    public int numJewelsInStones(String jewels, String stones) {
        HashMap<Character, Integer> map = new HashMap<>();
        int ans = 0;

        for(int i = 0; i < jewels.length(); i++) {
            map.put(jewels.charAt(i), map.getOrDefault(jewels.charAt(i), 0) + 1);
        }

        for(int i = 0; i < stones.length(); i++) {
            if(map.containsKey(stones.charAt(i))) {
                ans++;
            }
        }
        return ans;
    }

}
