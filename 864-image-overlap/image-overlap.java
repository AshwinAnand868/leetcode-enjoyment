class Solution {

    public int countOverlaps(int[][] img1, int[][] img2, int rowOff, int colOff) {
        int n = img1.length;
        int count = 0;

        for(int row = 0; row < n; row++) {
            for(int col = 0; col < n; col++) {
                if(row + rowOff < 0 || row + rowOff >= n || col + colOff < 0 || col + colOff >= n) {
                    continue;
                }

                count += img1[row][col] * img2[row + rowOff][col + colOff];
            }
        }

        return count;
    }

    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
        int maxCount = 0;

        for(int rowOff = - n + 1; rowOff < n; ++rowOff) {
            for(int colOff = -n + 1; colOff < n; ++colOff) {
                maxCount = Math.max(maxCount, countOverlaps(img1, img2, rowOff, colOff));
            }
        }

        return maxCount;
    }
}