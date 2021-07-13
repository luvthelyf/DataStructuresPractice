package ds.program.string;

import java.util.HashMap;



// "ADOBECODEBANC"
//"AABC" map a- 1 b 1 c 1
//"a"
//"aa"
//"aa"
//"aa"
public class MinimumWindowSubstring {
    public static void main(String[] args) {
//        System.out.println((new MinimumWindowSubstring()).minWindow("ADOBECODEBANC", "ABC"));
        System.out.println((new MinimumWindowSubstring()).minWindow("aabcbcdbca", "dcba"));
    }

    public String minWindow(String s, String t) {

        if(s.length() < t.length()) return "";
        HashMap<Character, Integer> map = new HashMap<>();

        for(char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int start = 0;
        // "ADOBECODEBANC"
        // "ABC" A-1 B-1 C-1 // 3
        int numOfDistinctCharFound = 0;
        int minSize = Integer.MAX_VALUE;
        String res = "";

        for(int end = 0; end < s.length(); end++) {
            char c = s.charAt(end);
            if(map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if(map.get(c) == 0) // use if (map.get(c) >= 0) if 2nd while loop is : while (numOfDistinctCharFound == t.length())
                    numOfDistinctCharFound++;
            }

            while(numOfDistinctCharFound == map.size()) {

                if(end - start + 1 < minSize) {
                    minSize = end - start + 1;
                    res = s.substring(start, end + 1);
                }

                char ch = s.charAt(start);
                if(map.containsKey(ch)) {
                    map.put(ch, map.get(ch) + 1);
                    if(map.get(ch) > 0) numOfDistinctCharFound--;
                }
                start++;
            }
//            System.out.println(startIndex+" : "+endIndex);
        }

        return res;
    }
}
