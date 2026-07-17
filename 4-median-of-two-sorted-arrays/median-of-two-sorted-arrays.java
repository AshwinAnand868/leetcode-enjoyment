class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int[] result = new int[n + m];

        int i = 0;
        int k = 0;
        int j = 0;


        // merge arrays without sorting
        while(i < n && j < m) {
            if(nums1[i] <= nums2[j]) {
                result[k] = nums1[i];
                i++;
                k++;
            } else {
                result[k] = nums2[j];
                k++;
                j++;
            }
        }

        while(i < n) {
            result[k++] = nums1[i++];
        }

        while(j <  m) {
            result[k++] = nums2[j++];
        }
        
        int total = n + m;
        if(total % 2 != 0) {
            // odd
            return result[total/ 2] * 1.0;
        } else {
            return (result[(total / 2)] + result[((total) / 2) - 1]) / 2.0;
        }
    }
}