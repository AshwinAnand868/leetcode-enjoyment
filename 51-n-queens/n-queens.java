class Solution {

    public boolean isValid(int row, int col, List<String> board) {
        // check if Q is present in the same column
        for(int i = row; i >= 0; --i) {
            if(board.get(i).charAt(col) == 'Q') {
                return false;
            }
        }

        // check if Q is in the left upwards
        for(int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if(board.get(i).charAt(j) == 'Q') {
                return false;
            }
        }

        // check if Q is in the right upwards
        int n = board.size();
        for(int i = row, j = col; i >= 0 && j < n; i--, j++) {
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

        // keeping row as fix and changing cols
        for(int col = 0; col < board.size(); ++col) {
            if(isValid(row, col, board)) { // if the queen can be placed at current row and col
                StringBuilder sb = new StringBuilder(board.get(row));
                sb.setCharAt(col, 'Q');
                board.set(row, sb.toString());

                // moving to the next row
                solve(result, board, row + 1);

                // resetting data
                sb.setCharAt(col, '.');
                board.set(row, sb.toString());
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


        solve(result, board, 0);

        return result;

    }
}