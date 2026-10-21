class Solution {

    public static boolean find(char[][] board, int r, int c, int j, String word) {

        int n = board.length;
        int m = board[0].length;

        if (r < 0 || c < 0 || r >= n || c >= m) {
            return false;
        }

        if (board[r][c] != word.charAt(j)) {
            return false;
        }

        if (j == word.length() - 1) {
            return true;
        }

        char ch = board[r][c];
        board[r][c] = '#';

        boolean res =
                find(board, r + 1, c, j + 1, word) ||
                find(board, r - 1, c, j + 1, word) ||
                find(board, r, c + 1, j + 1, word) ||
                find(board, r, c - 1, j + 1, word);

        board[r][c] = ch;

        return res;
    }

    public boolean exist(char[][] board, String word) {

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {

                if (find(board, r, c, 0, word)) {
                    return true;
                }
            }
        }

        return false;
    }
}