package ds.program.google;

import java.util.*;

/*

Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

Only one letter can be changed at a time.
Each transformed word must exist in the word list.
Note:

Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
You may assume no duplicates in the word list.
You may assume beginWord and endWord are non-empty and are not the same.
Example 1:

Input:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

Output: 5

Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.
Example 2:

Input:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]

Output: 0

Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.


"hot"
"dog"
["hot","dog"]


"hit"
"cog"
["hot","dot","tog","cog"]
 */
public class WordLadder {
    public static void main(String... arg) {
        String startWord = "hit";
        String endWord = "cog";
        List<String> words = new ArrayList<>();
        words.add("hot");
        words.add("dot");
        words.add("tog");
        words.add("cog");
//        String startWord = "hot";
//        String endWord = "dog";
//        List<String> words = new ArrayList<>();
//        words.add("hot");
//        words.add("dog");
        System.out.println((new WordLadder()).ladder(startWord, endWord, words));
    }

    public int ladder(String beginWord, String endWord, List<String> wordList) {

        HashSet<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord)) return 0;
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        int level = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String word = q.remove();
                for (int c = 0; c < word.length(); c++) {
                    for (char a = 'a'; a <= 'z'; a++) {
                        if(word.charAt(c) == a) continue;
                        StringBuilder sb = new StringBuilder(word);
                        sb.setCharAt(c, a);
                        String newWord = sb.toString();
                        if (newWord.equals(endWord)) {
                            System.out.println(newWord);
                            return level + 1;
                        }

                        if (set.contains(newWord)) {
                            System.out.println(newWord + " " + level);
                            q.add(newWord);
                            set.remove(newWord);
                        }
                    }
                }
            }
            level++;
        }

//
//            String word = q.remove();
//            level++;
//            for (int i = 0; i < word.length(); i++) {
//                for (char a = 'a'; a < 'z'; a++) {
//                    StringBuilder sb = new StringBuilder(word);
//                    sb.setCharAt(i, a);
//                    String newWord = sb.toString();
//                    if (newWord.equals(endWord)){
//                        return level + 1;
//                    }
//                    if (set.contains(newWord)) {
//                        q.add(newWord);
//                    }
//                }
//            }
//        }
        return 0;
    }
}
