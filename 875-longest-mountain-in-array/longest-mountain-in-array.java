class Solution {
    public int longestMountain(int[] arr) {

        int n = arr.length;
        if(n < 3) return 0; // no mountain subarray for n < 3
        int longestLen = 0;

        for(int i = 1; i < n - 1;) {
            // find the peek element first
            if(arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                int j = i; // copyint its index for back traversal
                int count = 0;

                while(j > 0 && arr[j] > arr[j - 1]) {
                    count++;
                    j--;
                }

                while(i <= n - 2 && arr[i] > arr[i + 1]) {
                    count++;
                    i++;
                }

                longestLen = Math.max(longestLen, count);
            } else {
                i++;
            }
        }

        if(longestLen > 0) return longestLen + 1; 
        return longestLen;
    }
}