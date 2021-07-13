package ds.program.lc.medium;

/**
 * 79. Word Search
 * Medium
 * <p>
 * 5563
 * <p>
 * 245
 * <p>
 * Add to List
 * <p>
 * Share
 * Given an m x n grid of characters board and a string word, return true if word exists in the grid.
 * <p>
 * The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * Output: true
 * Example 2:
 * <p>
 * <p>
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
 * Output: true
 * Example 3:
 * <p>
 * <p>
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
 * Output: false
 * <p>
 * <p>
 * Constraints:
 * <p>
 * m == board.length
 * n = board[i].length
 * 1 <= m, n <= 6
 * 1 <= word.length <= 15
 * board and word consists of only lowercase and uppercase English letters.
 * <p>
 * <p>
 * Follow up: Could you use search pruning to make your solution faster with a larger board?
 */
public class WordSearch {

    public boolean exist(char[][] board, String word) {

        char[] arr = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                boolean isWordFound = backtracking(i, j, board, arr, 0);
                if (isWordFound) return true;
            }
        }
        return false;
    }

    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};

    private boolean backtracking(int x, int y, char[][] board, char[] arr, int pos) {

        if (pos >= arr.length || board[x][y] != arr[pos]) return false;

        if (board[x][y] == arr[pos] && pos == arr.length - 1) {
            return true;
        }

        char temp = board[x][y];
        board[x][y] = '#';

        boolean isWordFound = false;
        for (int i = 0; i < 4; i++) {
            int r = x + dx[i];
            int c = y + dy[i];

            if (r < 0 || r >= board.length || c < 0 || c >= board[0].length) continue;

            if (board[r][c] == '#') continue;

            isWordFound = backtracking(r, c, board, arr, pos + 1);
            if (isWordFound) return true;
        }

        board[x][y] = temp;
        return isWordFound;
    }
}
