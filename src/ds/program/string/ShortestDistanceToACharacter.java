package ds.program.string;

import java.util.Arrays;

public class ShortestDistanceToACharacter {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new ShortestDistanceToACharacter().shortestToChar("loveleetcode", 'e')));
    }

    public int[] shortestToChar(String str, char c) {
        int[] result = new int[str.length()];

        int dist = str.length();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == c) {
                int pos = i - 1;
                while (pos >= 0 && i - pos < result[pos]) {
                    result[pos] = i - pos;
                    pos--;
                }
                dist = 0;
            }
            result[i] = dist++;
        }


        return result;
    }
}
