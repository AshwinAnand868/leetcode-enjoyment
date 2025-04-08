class Solution {

    public boolean isValid(int row, int col, List<String> board) {
        for(int i = row; i >= 0; i--) {
            if(board.get(i).charAt(col) == 'Q') {
                return false;
            }
        }

        // left upward for diagonals
        for(int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if(board.get(i).charAt(j) == 'Q') {
                return false;
            }
        }

        // check right diagonals upwards
        for(int i = row, j = col; i >= 0 && j < board.size(); i--, j++) {
            if(board.get(i).charAt(j) == 'Q') {
                return false;
            }
        }

        return true;
    }

    public void solve(List<List<String>> result, List<String> board, int row) {
        if(row == board.size()) {
            result.add(new ArrayList<>(board));
            return;
        }

        for(int col = 0; col < board.size(); ++col) {
            if(isValid(row, col, board)) {
                StringBuilder newRow = new StringBuilder(board.get(row));
                newRow.setCharAt(col, 'Q');
                board.set(row, newRow.toString());

                solve(result, board, row + 1);

                newRow.setCharAt(col, '.');
                board.set(row, newRow.toString());
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();

        List<String> board = new ArrayList<>();

        for(int i = 0; i < n; ++i) {
            StringBuilder row = new StringBuilder();

            for(int j = 0; j < n; ++j) {
                row.append(".");
            }

            board.add(row.toString());
        }

        // for n = 3, we get {"...", "...", "..."} as board

        solve(result, board, 0);

        return result;
    }
}