class Solution {
    public int maxChunksToSorted(int[] arr) {
        
        // using max comparison with indices
        int chunks = 0;
        int n = arr.length;
        int max = 0;
        
        for(int i = 0; i < n; ++i) {
            max = Math.max(max, arr[i]);
            
            if(max == i) {
                chunks++;
            }
        }
        
        return chunks;
        
// using cumulative sum approach
//         int cummSum = 0;
//         int indicesSum = 0;
//         int chunks = 0;
//         int n = arr.length;
        
//         for(int i = 0; i < n; ++i) {
//             cummSum += arr[i]; // cummulative sum till now
//             indicesSum += i;
            
//             if(indicesSum == cummSum) {
//                 chunks++;
//             }
//         }
        
//         return chunks;
       
// using prefix and suffix arrays
        
//         int chunks = 0;

//         int n = arr.length;
//         int[] prefixMax = Arrays.copyOf(arr, n);
//         int[] suffixMin = Arrays.copyOf(arr, n);

//         for(int i = 1; i < n; ++i) {
//             prefixMax[i] = Math.max(prefixMax[i], prefixMax[i - 1]);
//         }

//         for(int i = n - 2; i >= 0; --i) {
//             suffixMin[i] = Math.min(suffixMin[i], suffixMin[i + 1]);
//         }

//         for(int i = 0; i < n; ++i) {
//             int previousMaxToI = i > 0 ? prefixMax[i - 1] : -1;
//             int suffixMinFromI = suffixMin[i];

//             if(previousMaxToI < suffixMinFromI) {
//                 chunks++;
//             }
//         }

//         return chunks;
    }
}