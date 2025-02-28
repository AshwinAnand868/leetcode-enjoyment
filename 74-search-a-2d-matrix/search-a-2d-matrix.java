class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        /*
            Based on the given properties of the array, we can imagine
            the given array as a 1d sorted array. Guessing the binary search
            part is easy, but the main crux of the problem lies in the index 
            manipulation part.

            Initally, we keep the start at 0 and end at m * n - 1 (where
            m is the # rows and n is # cols). If we calculate mid, and 
            for example let's say it comes as 5, then we can calculate
            its index in the 2d array using the below formula:

            [mid/n][mid%n] (n is the no of cols)

            If our mid is 5 and n is 4 as in the first example
            , then matrix[1][1] will be location of that mid.
        */

        int m = matrix.length;
        int n = matrix[0].length;

        int start = 0;
        int end = (m * n) - 1;

        while(start <= end) {
            int mid = (start+ end) / 2;

            if(matrix[mid/n][mid%n] > target) {
                end = mid - 1;
            } else if(matrix[mid/n][mid%n] < target) {
                start = mid + 1;
            } else {
                return true;
            }
        }

        return false;


        // TC : O(m + n)
        // int m = matrix.length;
        // int n = matrix[0].length;

        // int i = 0, j = n - 1;

        // // if both the row and col pointer is in bounds
        // while(i < m && j >= 0) {
        //     if(matrix[i][j] > target) {
        //         j--;
        //     } else if(matrix[i][j] < target) {
        //         i++;
        //     } else {
        //         return true;
        //     }
        // }

        // return false;
    }
}