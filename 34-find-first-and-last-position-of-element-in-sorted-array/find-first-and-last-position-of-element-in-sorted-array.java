class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int firstOccurrence = findFirstOccurrence(nums, target, n);
        int lastOccurrence = findLastOccurrence(nums, target, n);

        return new int[] {firstOccurrence, lastOccurrence};
    }

    public int findFirstOccurrence(int[] arr, int target, int n) {
        int result = -1;

        int low = 0;
        int high = n - 1;

        while(low <= high) {
            int mid = (low + high) / 2;

            if(arr[mid] == target) {
                result = mid;
                high = mid - 1;
            } else if(arr[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return result;  
    }

    public int findLastOccurrence(int[] arr, int target, int n) {
        int result = -1;

        int low = 0;
        int high = n - 1;

        while(low <= high) {
            int mid = (low + high) / 2;

            if(arr[mid] == target) {
                result = mid;
                low = mid + 1;
            } else if(arr[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return result;  
    }
}