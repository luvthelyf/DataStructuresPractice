package ds.program.google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TextJustification {
    public static void main(String[] args) {
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        int maxWidth = 16;
        System.out.println((new TextJustification()).fullJustify(words, maxWidth));
    }
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int i = 0;
        while (i < words.length) {
            int wordLength = words[i].length();
            int j = i + 1;
            while (j < words.length
                    && wordLength + words[j].length() + j - i - 1 < maxWidth) {
                wordLength += words[j].length();
                j++;
            }
            int spacesLeft = maxWidth - wordLength;
            int wordsInALine = j - i;

            if (wordsInALine == 1 || j >= words.length) {

                int spacesBetweenWords = spacesLeft - (j - i - 1);

                StringBuilder sb = new StringBuilder(words[i]);
                for (int k = i + 1 ; k < j; k++) {
                    sb.append(" ").append(words[k]);
                }
                int s = 0;
                while(s++ < spacesBetweenWords) sb.append(" ");
                result.add(sb.toString());
            } else {

                int spacesBetweenWords = j - i - 1;
                int spaces = spacesLeft / spacesBetweenWords;
                int  remainingSpaces = spacesLeft % spacesBetweenWords;
                StringBuilder sb = new StringBuilder(words[i]);
                for(int k = i + 1; k < j; k++) {
                    int spaceActual = spaces + (remainingSpaces-- > 0 ? 1 : 0);
                    int s = 0;
                    while(s++ < spaceActual) sb.append(" ");
                    sb.append(words[k]);
                }

                result.add(sb.toString());
            }
            i = j;
        }
        return result;
    }
}
