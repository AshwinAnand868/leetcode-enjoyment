class Solution {

    public void dfs(boolean[][] visited, char[][] board, String word, int r, int c, int i, int m, int n, boolean[] exist) {
        if (i == word.length()) {
            exist[0] = true;
            return;
        }

        // bounds and visited check
        if (r < 0 || r >= m || c < 0 || c >= n || visited[r][c] || board[r][c] != word.charAt(i)) {
            return;
        }

        visited[r][c] = true;

        dfs(visited, board, word, r - 1, c, i + 1, m, n, exist);
        dfs(visited, board, word, r + 1, c, i + 1, m, n, exist);
        dfs(visited, board, word, r, c - 1, i + 1, m, n, exist);
        dfs(visited, board, word, r, c + 1, i + 1, m, n, exist);

        visited[r][c] = false;  // backtrack
    }

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        boolean[] exist = new boolean[1];  // use array to mutate in recursion

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    dfs(visited, board, word, i, j, 0, m, n, exist);
                    if (exist[0]) return true;
                }
            }
        }

        return false;
    }
}
