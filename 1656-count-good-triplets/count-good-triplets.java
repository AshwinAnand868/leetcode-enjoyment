class Solution {
    public int countGoodTriplets(int[] arr, int a, int b, int c) {

        int n = arr.length;
        int count = 0;

        int[] freq = new int[1001];
        
        for(int j = 0; j < n; ++j) {
            int[] sum = new int[1001];

            sum[0] = freq[0];
            for(int i = 1; i <= 1000; ++i) {
                sum[i] = sum[i - 1] + freq[i];
            }

            for(int k = j + 1; k < n; ++k) {
                if (Math.abs(arr[j] - arr[k]) <= b) {
                    int lj = arr[j] - a, rj = arr[j] + a;
                    int lk = arr[k] - c, rk = arr[k] + c;

                    int l = Math.max(0, Math.max(lj, lk));
                    int r = Math.min(1000, Math.min(rj, rk));

                    if (l <= r) {
                        count += (l == 0) ? sum[r] : (sum[r] - sum[l - 1]);
                    }
                }
            }

            freq[arr[j]]++;
        }

        return count;

        // A little optimized
        // int count = 0;
        // for(int j = 1; j < arr.length - 1; ++j) {
        //     for(int i = 0; i < j; ++i) {
        //         int diffA = Math.abs(arr[i] - arr[j]);
        //         if(diffA > a) continue;
        //         for(int k = j + 1; k < arr.length; ++k) {
        //             int diffB = Math.abs(arr[j] - arr[k]);
        //             int diffC = Math.abs(arr[i] - arr[k]);

        //             if(diffB <= b && diffC <= c) {
        //                 count++;
        //             }
        //         }
        //     }
        // }

        // return count;

        // Brute Force
        //  int count = 0;
        // for(int i = 0; i <= arr.length - 3; ++i) {
        //     for(int j = i + 1; j <= arr.length - 2; ++j) {
        //         for(int k = j + 1; k <= arr.length - 1; ++k) {
        //             int diffA = Math.abs(arr[i] - arr[j]);
        //             int diffB = Math.abs(arr[j] - arr[k]);
        //             int diffC = Math.abs(arr[i] - arr[k]);

        //             if(diffA <= a && diffB <= b && diffC <= c) {
        //                 count++;
        //             }
        //         }
        //     }
        // }

        // return count;
    }

    private boolean isGood(int[] arr, int i, int j, int k, int a, int b, int c) {
        return Math.abs(arr[i] - arr[j]) <= a &&
                Math.abs(arr[j] - arr[k]) <= b &&
                Math.abs(arr[i] - arr[k]) <= c;
    }

    private int bruteForceCount(int[] arr, int a, int b, int c) {
        int count = 0;
        for (int i = 0; i < arr.length - 2; ++i) {
            for (int j = i + 1; j < arr.length - 1; ++j) {
                for (int k = j + 1; k < arr.length; ++k) {
                    if (isGood(arr, i, j, k, a, b, c))
                        count++;
                }
            }
        }
        return count;
    }

}