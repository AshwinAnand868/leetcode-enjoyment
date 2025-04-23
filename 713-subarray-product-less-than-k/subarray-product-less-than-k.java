class Solution {
    public int numSubarrayProductLessThanK(int[] arr, int k) {
        int count = 0;
        int n = arr.length;
        long product = 1;
        int j = 0, i = 0;

        while(j < n) {
            product *= arr[j];

            while(product >= k && i <= j) {
                product /= arr[i];
                i++;
            }

            count += j - i + 1;
            j++;
        }

        return count;
    }
}