class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int maxUnits = 0;
        int m = boxTypes.length;
        int n = boxTypes[0].length;

        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);

        for(int i = 0; i < m && truckSize > 0; ++i) {
            // for(int j = 0; j < n; ++j) {
                if(truckSize >= boxTypes[i][0]) {
                    maxUnits += boxTypes[i][0] * boxTypes[i][1];
                    truckSize -= boxTypes[i][0];
                } else {
                    maxUnits += truckSize * boxTypes[i][1];
                    truckSize -= truckSize;
                }
            // }
        }

        return maxUnits;
    }
}