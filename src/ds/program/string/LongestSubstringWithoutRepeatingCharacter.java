package ds.program.string;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacter {
    public static void main(String[] args) {
        System.out.println((new LongestSubstringWithoutRepeatingCharacter()).lengthOfLongestSubstring1("abcabcbb"));
        System.out.println((new LongestSubstringWithoutRepeatingCharacter()).lengthOfLongestSubstring1("pwwkew"));
        System.out.println((new LongestSubstringWithoutRepeatingCharacter()).lengthOfLongestSubstring1("dvdg"));
    }

    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0, j = 0; j < s.length(); j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(i, map.get(s.charAt(j)));
            }
            res = Math.max(res, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return res;
    }

    public int lengthOfLongestSubstring1(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        int currentMax = 0;
        for (int i = 0; i < s.length(); i += 1) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                int indexOfOffender = map.get(c);
                if (indexOfOffender < i - currentMax) {
                    currentMax += 1;
                    max = Math.max(max, currentMax);
                } else {
                    currentMax = i - indexOfOffender;
                }
                map.put(c, i);
            } else {
                map.put(c, i);
                currentMax += 1;
                max = Math.max(max, currentMax);
            }
        }
        return max;
    }

}
