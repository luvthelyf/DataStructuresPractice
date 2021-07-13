package ds.program.array;

public class LongestSubstringWithoutRepetition {
    public int lengthOfLongestSubstring(String s) {

        if(s == null || s.isEmpty()) return 0;
        int[] prevOccur = new int[256];
        int prev_index;
        int curr_len = 1;
        int max_len = 1;

        for(int i = 0; i < 256; i++){
            prevOccur[i] = -1;
        }

        prevOccur[s.charAt(0)] = 0;
        int len = s.length();
        for(int i = 1; i < len; i++){
            int currentChar = s.charAt(i);
            prev_index = prevOccur[currentChar];

            if(prev_index == -1 || i - curr_len > prev_index)
                curr_len++;
            else {
                if(curr_len > max_len)
                    max_len = curr_len;
                curr_len = i - prev_index;
            }
            prevOccur[currentChar] = i;
        }

        if(curr_len > max_len)
            max_len = curr_len;
        return max_len;
    }

    public static void main(String[] args) {
        System.out.println((new LongestSubstringWithoutRepetition()).lengthOfLongestSubstring("cccc")); // "au" "abcd" "abcdabc
    }
}
