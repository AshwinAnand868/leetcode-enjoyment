class Solution {
    public void nextPermutation(int[] nums) {
        int pivot = -1;
        int n = nums.length;

        for(int i = n - 1; i > 0; --i) {
            if(nums[i] > nums[i - 1]) {
                pivot = i - 1;
                break;
            }
        }

        if(pivot == -1) {
            Arrays.sort(nums); // the array is at the last permutation, so its next permutation will be the first one only
            return;
        }

        // find the next greator element than the pivot value
        for(int i = n - 1; i > pivot; --i) {
            if(nums[i] > nums[pivot]) {
                int temp = nums[i];
                nums[i] = nums[pivot];
                nums[pivot] = temp;
                break;
            }
        }

        reverse(nums, pivot + 1, n - 1);
    }

    private void reverse(int[] nums, int left, int right) {
        while(left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;

            left++;
            right--;
        }
    }
}