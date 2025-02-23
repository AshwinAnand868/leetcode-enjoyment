class Solution {
    public int maxDistToClosest(int[] seats) {
        int maxDistance = 0;
        int lastOnePos = -1;
        int n = seats.length;

        for (int i = 0; i < n; i++) {
            if (seats[i] == 1) {
                if (lastOnePos == -1) {
                    // First occupied seat case
                    maxDistance = i;
                } else {
                    // Middle seats case
                    maxDistance = Math.max(maxDistance, (i - lastOnePos) / 2);
                }
                lastOnePos = i;
            }
        }

        // Handling trailing empty seats
        maxDistance = Math.max(maxDistance, n - 1 - lastOnePos);

        return maxDistance;
    }
}