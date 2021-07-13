package ds.program;

public class MinChangeToConvertToAnagram {
    public static void main(String[] args) {
        System.out.println(new MinChangeToConvertToAnagram().minConversion("bab", "aba"));
        System.out.println(new MinChangeToConvertToAnagram().minConversion("leetcode", "practice"));
        System.out.println(new MinChangeToConvertToAnagram().minConversion("anagram", "mangaar"));
        System.out.println(new MinChangeToConvertToAnagram().minConversion("friend", "family"));
        System.out.println(new MinChangeToConvertToAnagram().minConversion("xxyyzz", "xxyyzz"));
    }

    private int minConversion(String S, String T) {

        int min = 0;
        char[] arr = S.toCharArray();
        int[] count = new int[26];
        for(char c : arr) {
            count[c - 'a']++; // a - 1 b-2
        }
        for(char c : T.toCharArray()) { //  a- 2 b - 1
            count[c - 'a']--;           // a - -1 b - 1
        }
        for(int i = 0; i < 26; i++) {
            min += Math.abs(count[i]);
        }
//
        return min / 2;
    }
}
