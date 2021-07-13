package ds.program.google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ExpressiveWords {
    private class Pair {
        char c;
        int count;
    }
    public int expressiveWords(String S, String[] words) {
        HashMap<Character, Integer> mapToCompare = new HashMap<>();
        for(char c : S.toCharArray()) {
            mapToCompare.put(c, mapToCompare.getOrDefault(c, 0) + 1);
        }

        List<Pair> matchList = new ArrayList<>();

        System.out.println(matchList);

        for(String word : words) {

        }
        return 0;
    }
}
