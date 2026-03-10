class Solution {

    int[][] rects;
    int[] prefixSums;
    Random random;

    public Solution(int[][] rects) {
        this.rects = rects;
        this.prefixSums = new int[rects.length];
        this.random = new Random();

        int sum = 0;

        for(int i = 0; i < rects.length; ++i) {
            int[] rect = rects[i];

            int x1 = rect[0], y1 = rect[1], x2 = rect[2], y2 = rect[3];
            int integerPoints = (x2 - x1 + 1) * (y2 - y1 + 1);

            sum += integerPoints;
            prefixSums[i] = sum;
        }
    }
    
    public int[] pick() {
        int totalPoints = prefixSums[prefixSums.length - 1];
        int randPoint = random.nextInt(totalPoints) + 1; // add 1 to get upto last point

        int chosenRectIndex = binarySearch(this.prefixSums, this.prefixSums.length, randPoint);

        int[] rect = rects[chosenRectIndex];

        int x1 = rect[0], y1 = rect[1], x2 = rect[2], y2 = rect[3];

        int x = x1 + random.nextInt(x2 - x1 + 1);
        int y = y1 + random.nextInt(y2 - y1 + 1);
        
        return new int[]{x, y};
    }

    public int binarySearch(int[] arr, int n, int x) {
        int low = 0, high = n - 1;
        int ans = n;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] >= x) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(rects);
 * int[] param_1 = obj.pick();
 */