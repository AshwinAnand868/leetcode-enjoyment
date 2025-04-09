class Solution {
    public void nextPermutation(int[] nums) {
        if(nums.length == 1) {
            return;
        }

        int pivot = -1;

        for(int i = nums.length - 1; i > 0; --i) {
            if(nums[i - 1] < nums[i]) {
                pivot = i - 1;
                break;
            }
        }

        if(pivot == -1) {
            Arrays.sort(nums);
            return;
        }

        for(int i = nums.length - 1; i > pivot; --i) {
            if(nums[i] > nums[pivot]) {
                int temp = nums[i];
                nums[i] = nums[pivot];
                nums[pivot] = temp;
                break;
            }
        }

        // Reverse the suffix
        int left = pivot + 1, right = nums.length - 1;

        while(left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}