class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // binary search on smaller array
        if(nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int n = nums1.length;
        int m = nums2.length;

        int low = 0;
        int high = n; // taking n because these are partition based
        // we are not searching here for an element, we are searching
        // for partition position

        while(low <= high) {
            int partition1 = low + (high - low) / 2;
            int partition2 = (m + n + 1) / 2 - partition1;

            int left1 = (partition1 == 0) ? Integer.MIN_VALUE : nums1[partition1 - 1];
            int right1 = (partition1 == n) ? Integer.MAX_VALUE : nums1[partition1];

            int left2 = (partition2 == 0) ? Integer.MIN_VALUE : nums2[partition2 - 1];
            int right2 = (partition2 == m) ? Integer.MAX_VALUE : nums2[partition2];

            if(left1 <= right2 && left2 <= right1) {
                // Even number of elements
                if ((n + m) % 2 == 0) {
                    return (Math.max(left1, left2) + Math.min(right1, right2)) / 2.0;
                }

                return Math.max(left1, left2);
            }


            if(left1 > right2) {
                high = partition1 - 1;
            } else {
                low = partition1 + 1;
            }
        }

        return 0.0;
    }
}