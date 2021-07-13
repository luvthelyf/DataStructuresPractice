package ds.program.trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
1065. Index Pairs of a String
Given a text string and words (a list of strings), return all index pairs [i, j] so that the substring text[i]...text[j] is in the list of words.



Example 1:

Input: text = "thestoryofleetcodeandme", words = ["story","fleet","leetcode"]
Output: [[3,7],[9,13],[10,17]]
Example 2:

Input: text = "ababa", words = ["aba","ab"]
Output: [[0,1],[0,2],[2,3],[2,4]]
Explanation:
Notice that matches can overlap, see "aba" is found in [0,2] and [2,4].


Note:

All strings contains only lowercase English letters.
It's guaranteed that all strings in words are different.
1 <= text.length <= 100
1 <= words.length <= 20
1 <= words[i].length <= 50
Return the pairs [i,j] in sorted order (i.e. sort them by their first coordinate in case of ties sort them by their second coordinate).
 */
public class IndexPairOfAString {
    private static class Trie {
        Trie[] children = new Trie[26];
        boolean isWord;
    }

    public int[][] indexPairs(String text, String[] words) {
        Trie root = new Trie();
        List<int[]> resultList = new ArrayList<>();

        for (String word : words) {
            insert(root, word);
        }

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            Trie temp = root;
            if (temp.children[c - 'a'] != null) {

                for (int j = i; j < text.length(); j++) {
                    Trie node = temp.children[text.charAt(j) - 'a'];
                    if (node == null) break;
                    temp = node;
                    if (temp.isWord) {
                        resultList.add(new int[]{i, j});
                    }
                }
            }
        }
        int[][] result = new int[resultList.size()][2];
        int i = 0;
        for (int[] res : resultList) {
            result[i] = res;
            i++;
        }

        return result;
    }

    void insert(Trie root, String word) {
        Trie temp = root;
        for (char c : word.toCharArray()) {
            if (temp.children[c - 'a'] == null) {
                temp.children[c - 'a'] = new Trie();
            }
            temp = temp.children[c - 'a'];
        }
        temp.isWord = true;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString((new IndexPairOfAString()).indexPairs("thestoryofleetcodeandme", new String[]{"story", "fleet", "leetcode"})));
    }
}
