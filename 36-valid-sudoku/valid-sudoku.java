class Solution {
    // pure brute force
    public boolean isValidSudoku(char[][] board) {

        Set<String> seen = new HashSet<>();

        for(int i = 0; i < 9; ++i) {
            for(int j = 0; j < 9; ++j) {
                char current = board[i][j];

                if (current == '.') continue;

                String rowKey = current + " is in row " + i;
                String colKey = current + " is in col " + j;
                String boxKey = current + " is in box " + (i / 3) + "-" + (j / 3);

                if(!seen.add(rowKey) || !seen.add(colKey) || !seen.add(boxKey)) {
                    return false;
                }

            }

            
        }

        return true;


        // for(int i = 0; i < 9; ++i) {
        //     for(int j = 0; j < 9; ++j) {
        //         char current = board[i][j];

        //         if(current == '.') continue;

        //         // check current row
        //         for(int col = 0; col < 9; ++col) {
        //             if(col != j && board[i][col] == current) {
        //                 return false;
        //             }
        //         }

        //         for(int row = 0; row < 9; ++row) {
        //             if(row != i && board[row][j] == current) {
        //                 return false;
        //             }
        //         }
                
        //         int blockRow = (i / 3) * 3;
        //         int blockCol = (j / 3) * 3;

        //         for(int row = blockRow; row < blockRow + 3; ++row) {
        //             for(int col = blockCol; col < blockCol + 3; ++col) {
        //                 if((i != row || j != col) && board[row][col] == current) {
        //                     return false;
        //                 }
        //             }
        //         }
        //     }
        // }

        // return true;
    }
}