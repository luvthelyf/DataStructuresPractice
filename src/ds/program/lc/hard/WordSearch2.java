package ds.program.lc.hard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Given an m x n board of characters and a list of strings words, return all words on the board.
 *
 * Each word must be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]], words = ["oath","pea","eat","rain"]
 * Output: ["eat","oath"]
 * Example 2:
 *
 *
 * Input: board = [["a","b"],["c","d"]], words = ["abcb"]
 * Output: []
 *
 *
 * Constraints:
 *
 * m == board.length
 * n == board[i].length
 * 1 <= m, n <= 12
 * board[i][j] is a lowercase English letter.
 * 1 <= words.length <= 3 * 104
 * 1 <= words[i].length <= 10
 * words[i] consists of lowercase English letters.
 * All the strings of words are unique.
 */
public class WordSearch2 {
    private static class TrieNode{
        TrieNode[] children;
        String word;

        public TrieNode(){
            this.children = new TrieNode[26];
            this.word = null;
        }
    }

    TrieNode root = new TrieNode();

    private void addWords(String word) {
        TrieNode temp = root;

        for(char c : word.toCharArray()) {
            if(temp.children[c - 'a'] == null) {
                temp.children[c - 'a'] = new TrieNode();
            }
            temp = temp.children[c - 'a'];
        }
        temp.word = word;
    }

    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};
    HashSet<String> answer = new HashSet<>();
    public List<String> findWords(char[][] board, String[] words) {


        for(String word : words) addWords(word);

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                findWordsUtil(i, j, board, root);
            }
        }
        return new ArrayList<>(answer);
    }

    private void findWordsUtil(int x, int y, char[][] board, TrieNode node) {

        char currChar = board[x][y];
        if(node.children[currChar - 'a'] == null) return;

        node = node.children[currChar - 'a'];

        if(node.word != null) answer.add(node.word);

        char temp = board[x][y];
        board[x][y] = '#';
        for(int i = 0; i < 4; i++) {
            int r = x + dx[i];
            int c = y + dy[i];

            if(r < 0 || r >= board.length || c < 0 || c >= board[0].length) continue;

            if(board[r][c] == '#') continue;

            findWordsUtil(r, c, board, node);
        }

        board[x][y] = temp;

    }
}
