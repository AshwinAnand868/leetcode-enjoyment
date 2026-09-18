class Solution {

    int count = 0;

    private void countInversion(int[] nums, int low, int mid, int high) {
        int right = mid + 1;

        for(int i = low; i <= mid; ++i) {
            while(right <= high && (long) nums[i] > (long) 2 * nums[right]) {
                right++;
            }

            count += (right - (mid + 1));
        }
    }
    
    private void merge(int[] nums, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];

        int i = low;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= high) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = nums[i++];
        }

        while (j <= high) {
            temp[k++] = nums[j++];
        }

        for (int x = 0; x < temp.length; x++) {
            nums[low + x] = temp[x];
        }
    }

    public void mergeSort(int[] nums, int low, int high) {
        if (low >= high) {
            return;
        }

        int mid = low + (high - low) / 2;

        mergeSort(nums, low, mid);
        mergeSort(nums, mid + 1, high);
        countInversion(nums, low, mid, high);
        merge(nums, low, mid, high);
    }

    public int reversePairs(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return count;
    }
}