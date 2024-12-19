class Solution {
    public int maxChunksToSorted(int[] arr) {
                int chunks = 0;

        int n = arr.length;
        int[] prefixMax = Arrays.copyOf(arr, n);
        int[] suffixMin = Arrays.copyOf(arr, n);

        for(int i = 1; i < n; ++i) {
            prefixMax[i] = Math.max(prefixMax[i], prefixMax[i - 1]);
        }

        for(int i = n - 2; i >= 0; --i) {
            suffixMin[i] = Math.min(suffixMin[i], suffixMin[i + 1]);
        }

        for(int i = 0; i < n; ++i) {
            int previousMaxToI = i > 0 ? prefixMax[i - 1] : -1;
            int suffixMinFromI = suffixMin[i];

            if(previousMaxToI < suffixMinFromI) {
                chunks++;
            }
        }

        return chunks;
    }
}