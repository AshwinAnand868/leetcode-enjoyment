class Solution {
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int count = 0;
        for(int i = 0; i <= arr.length - 3; ++i) {
            for(int j = i + 1; j <= arr.length - 2; ++j) {
                for(int k = j + 1; k <= arr.length - 1; ++k) {
                    int diffA = Math.abs(arr[i] - arr[j]);
                    int diffB = Math.abs(arr[j] - arr[k]);
                    int diffC = Math.abs(arr[i] - arr[k]);

                    if(diffA <= a && diffB <= b && diffC <= c) {
                        count++;
                    }
                }
            }
        }

        return count;
    }
}