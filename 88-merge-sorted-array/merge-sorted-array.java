class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] tempArray = new int[m];

        for(int i = 0; i < m; ++i) {
            tempArray[i] = nums1[i];
        }

        int i = 0;
        int j = 0;
        int indx = 0;

        while(i < m && j < n) {
            if(tempArray[i] < nums2[j]) {
                nums1[indx] = tempArray[i];
                i++;
            } else {
                nums1[indx] = nums2[j];
                j++;
            }
            indx++;
        }

        // leftover lements
        for(int k = i; k < m; k++) {
            nums1[indx++] = tempArray[k];
        }

        for(int k = j; k < n; k++) {
            nums1[indx++] = nums2[k];
        }


        // int mIndex = m - 1;
        // int nIndex = n - 1;
        // int r = m + n - 1;

        // while(nIndex >= 0) {
        //     if(mIndex >= 0 && nums1[mIndex] >= nums2[nIndex]) {
        //         nums1[r] = nums1[mIndex];
        //         mIndex--;
        //     } else {
        //         nums1[r] = nums2[nIndex];
        //         nIndex--;
        //     }

        //     r--;
        // }

        // for (int j = 0, i = m; j < n; j++) {
        //     nums1[i] = nums2[j];
        //     i++;
        // }
        // Arrays.sort(nums1);

    }
}