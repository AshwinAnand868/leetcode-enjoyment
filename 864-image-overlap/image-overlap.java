class Solution {
    public int largestOverlap(int[][] A, int[][] B) {
        // let's first get the offsets ready
        int n = A.length;
        int maxOverlap = 0;

        for(int rowOffset = -n + 1; rowOffset < n; ++rowOffset) {
            // for each row offset, there are three column offset
            for(int colOffset = - n + 1; colOffset < n; ++colOffset) {
                maxOverlap = Math.max(maxOverlap, countOverlaps(A, B, rowOffset, colOffset));
            }
        }

        return maxOverlap;
    }

    private int countOverlaps(int[][] A, int[][] B, int rowOffset, int colOffset) {
        int n = A.length;

        int count = 0;

        for(int i = 0; i < n; ++i) {
            for(int j = 0; j < n; ++j) {
                int B_i = rowOffset + i;
                int B_j = colOffset + j;

                if(B_i < 0 || B_i >= n || B_j < 0 || B_j >= n) {
                    continue; // skip this because of invalid indices
                }

                count += A[i][j] * B[B_i][B_j];
            }
        }

        return count;
    }
}