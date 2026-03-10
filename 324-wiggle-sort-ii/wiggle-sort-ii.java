import java.util.*;

class Solution {
    public void wiggleSort(int[] nums) {
        int n = nums.length;
        
        // Sort in ascending order (no comparator needed for int[])
        Arrays.sort(nums);
        
        // Calculate half size
        int halfSize = (int) Math.ceil((double) n / 2);
        
        // Split into two halves
        int[] halfNum1 = new int[halfSize];       // smaller half
        int[] halfNum2 = new int[n - halfSize];   // larger half

        for (int i = 0; i < halfSize; i++) {
            halfNum1[i] = nums[i];
        }

        for (int i = 0; i < n - halfSize; i++) {
            halfNum2[i] = nums[i + halfSize];
        }

        // Reverse both halves to avoid duplicates clumping
        reverse(halfNum1);
        reverse(halfNum2);

        // Interleave halves
        int j = 0, k = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                nums[i] = halfNum1[j++];
            } else {
                nums[i] = halfNum2[k++];
            }
        }
    }

    private void reverse(int[] arr) {
        for (int i = 0, j = arr.length - 1; i < j; i++, j--) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}
