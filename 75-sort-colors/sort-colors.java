class Solution {

    public void merge(int[] arr, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];

        int left = low;
        int right = mid + 1;
        int idx = 0;

        while(left <= mid && right <= high) {
            if(arr[left] <= arr[right]) {
                temp[idx] = arr[left];
                left++;
            } else {
                temp[idx] = arr[right];
                right++;
            }

            idx++;
        }

        while(left <= mid) {
            temp[idx] = arr[left];
            idx++;
            left++;
        }

        while(right <= high) {
            temp[idx] = arr[right];
            idx++;
            right++;
        }

        for(int i = 0; i< temp.length; ++i) {
            arr[low + i] = temp[i];
        }
    }

    public void mergeSort(int[] arr, int low, int high) {
        if(low == high) {
            return;
        }

        int mid = (low + high) / 2;

        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);
        merge(arr, low, mid, high);
    }

    public void sortColors(int[] arr) {

        mergeSort(arr, 0, arr.length - 1);
        

        // int n = arr.length;

        // boolean didSwap = false;

        // for(int i = 0; i < n; ++i) {
        //     for(int j = 0; j < n - i - 1; ++j) {
        //         if(arr[j] > arr[j + 1]) {
        //             int temp = arr[j];
        //             arr[j] = arr[j + 1];
        //             arr[j + 1] = temp;
        //             didSwap = true;
        //         }
        //     }

        //     if(!didSwap) {
        //         break;
        //     }
        // }

    }
}