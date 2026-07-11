class Solution {
    public int maxDistance(int[] position, int m) {

        Arrays.sort(position);

        int n = position.length;

        int low = 1;
        int high = position[n - 1] - position[0];

        int ans = 0;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (canPlace(position, mid, m)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }

    private boolean canPlace(int[] position, int mid, int m) {

        int ballsPlaced = 1;
        int lastPosition = position[0];
        int n = position.length;

        for (int i = 1; i < n; i++) {

            if (position[i] - lastPosition >= mid) {
                ballsPlaced++;
                lastPosition = position[i];

                if (ballsPlaced == m)
                    return true;
            }
        }

        return false;
    }
}