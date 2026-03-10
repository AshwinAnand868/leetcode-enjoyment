class Solution {
    public int search(int[] arr, int target) {
        int n = arr.length;
        int low = 0, high = n - 1;

        while(low <= high) {
            int mid = (low + high) / 2;

            if(arr[mid] == target) {
                return mid;
            }

            // the left part is sorted
            if(arr[mid] >= arr[low]) {
                // the target is in the sorted half
                if(arr[low] <= target && target <= arr[mid]) {
                    // eliminate the unsorted part
                    high = mid - 1;
                } else {
                    // the target is in the unsorted half
                    // eliminate the sorted part
                    low = mid + 1;
                }

            } else {
                // the right part is sorted
                if(target >= arr[mid] && target <= arr[high]) {
                    // element is in the sorted part
                    low = mid + 1;
                } else {
                    // element is in the unsorted part
                    high = mid - 1;
                }
            }
        }

        return -1;
    }
}