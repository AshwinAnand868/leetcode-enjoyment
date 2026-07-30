class Solution {
    public int findKthPositive(int[] arr, int k) {
        int i = 0;
        int current = 1;
        int missing = 0;

        while (missing < k) {
            if (i < arr.length && arr[i] == current) {
                i++;
            } else {
                missing++;
            }
            if (missing == k)
                return current;

            current++;
        }

        return -1; // dummy return statement
    }
}