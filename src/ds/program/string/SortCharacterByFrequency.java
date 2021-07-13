package ds.program.string;

import java.util.*;

public class SortCharacterByFrequency {
    public static void main(String[] args) {

        System.out.println(new SortCharacterByFrequency().frequencySort("eweewewfvetree"));
    }

    class Holder {
        char character;
        int frequency;

        Holder(char character, int frequency) {
            this.character = character;
            this.frequency = frequency;
        }
    }

    public String frequencySort(String s) {

        HashMap<Character, Integer> map = new HashMap<>();
        for (Character c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Holder> queue = new PriorityQueue<>((e1, e2) -> e2.frequency - e1.frequency);
        for (Map.Entry<Character, Integer> e : map.entrySet()) {
            queue.offer(new Holder(e.getKey(), e.getValue()));
        }

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            Holder mostFrequentElement = queue.poll();
            int freq = mostFrequentElement.frequency;
            while (freq-- > 0)
                sb.append(mostFrequentElement.character);
        }
        return sb.toString();
    }

}
