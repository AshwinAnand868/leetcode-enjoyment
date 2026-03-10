class Solution {
    public int longestConsecutive(int[] arr) {
        int n = arr.length;
        if(n == 0) return 0;

        Arrays.sort(arr);
        int lastSmaller = Integer.MIN_VALUE;
        int currCount = 0; 
        int longestCount = 1;

        for(int i = 0; i < n; ++i) {
            if(arr[i] - 1 == lastSmaller) {
                currCount += 1;
            } else if(arr[i] != lastSmaller) {
                currCount = 1;
            }
            lastSmaller = arr[i];
            longestCount = Math.max(longestCount, currCount);
        }

        return longestCount;
    }
}