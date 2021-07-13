package ds.program.google;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class GQestions {
    private class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String str = null;
    }
    int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {-1, 1}, {1, -1}, {-1, -1}};
    HashSet<String> ans = new HashSet<>();

    TrieNode root = new TrieNode();

    private void add(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (curr.children[index] == null) curr.children[index] = new TrieNode();
            curr = curr.children[index];
        }
        curr.str = word;
    }
    public List<String> findWords(char[][] board, String[] words) {
        for (String word : words) add(word);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                backtracking(board, i, j, root, new HashSet<>());
            }
        }
        return new ArrayList<>(ans);
    }

    private void backtracking(char[][] board, int x, int y, TrieNode curr, HashSet<String> seen) {
        if (x < 0 || x >= board.length) return;
        if (y < 0 || y >= board[0].length) return;

        if (curr.children[board[x][y] - 'a'] == null) return;
        if (seen.contains(x + " " + y)) return;

        seen.add(x + " " + y);
        curr = curr.children[board[x][y] - 'a'];
        if (curr.str != null) ans.add(curr.str);

        for (int i = 0; i < 8; i++) {
            int newX = x + dir[i][0];
            int newY = y + dir[i][1];
            backtracking(board, newX, newY, curr, seen);
        }
        seen.remove(x + " " + y);

    }
}





//    private void backtracking(int row, int col, TrieNode parent) {
//        Character letter = this.boardMatrix[row][col];
//        TrieNode currNode = parent.children.get(letter);
//
//        // check if there is any match
//        if (currNode.word != null) {
//            this.answer.add(currNode.word);
//            currNode.word = null;
//        }
//
//        this.boardMatrix[row][col] = '#';
//
//        int[] rowOffset = {-1, 0, 1, 0, -1, 1, -1, 1};
//        int[] colOffset = {0, 1, 0, -1, 1, -1, -1, 1};
//        for (int i = 0; i < 4; ++i) {
//            int newRow = row + rowOffset[i];
//            int newCol = col + colOffset[i];
//            if (newRow < 0 || newRow >= this.boardMatrix.length || newCol < 0
//                    || newCol >= this.boardMatrix[0].length) {
//                continue;
//            }
//            if (currNode.children.containsKey(this.boardMatrix[newRow][newCol])) {
//                backtracking(newRow, newCol, currNode);
//            }
//        }
//
//        this.boardMatrix[row][col] = letter;
//
//        if (currNode.children.isEmpty()) {
//            parent.children.remove(letter);
//        }
//    }

//}
