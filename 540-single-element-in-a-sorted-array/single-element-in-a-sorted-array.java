class Solution {
    public int singleNonDuplicate(int[] arr) {

        int n = arr.length;
        int low = 1; // starting from 2nd element
        int high = n - 2; // going till 2nd last element

        if (n == 1) {
            return arr[0];
        }

        // Edge case I
        if (arr[0] != arr[1]) {
            return arr[0];
        }

        if (arr[n - 1] != arr[n - 2]) {
            return arr[n - 1];
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] != arr[mid - 1] && arr[mid] != arr[mid + 1]) {
                return arr[mid];
            } else if ((mid % 2 == 1 && arr[mid] == arr[mid + 1]) ||
                    (mid % 2 == 0 && arr[mid] == arr[mid - 1])) {
                // eliminate left half - single is in right half
                high = mid - 1;
            } else {
                // eliminate right half - single is in left half
                low = mid + 1;
            }
        }

        return -1;

        // int xor = 0;

        // for (int i = 0; i < nums.length; i++) {
        //     xor = xor ^ nums[i];
        // }

        // return xor;
    }
}