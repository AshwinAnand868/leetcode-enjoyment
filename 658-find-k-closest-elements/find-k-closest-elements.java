class Solution {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        int low = 0;
        int high = arr.length - k;

        while(low < high) {
            int mid = (low + high) / 2;
            if(x - arr[mid] > arr[mid + k] - x) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = low; i < low + k; i++) {
            result.add(arr[i]);
        }

        return result;


        // Deque approach
        // Deque<Integer> closestElements = new LinkedList<>();
        // for(int num : arr) {
        //     closestElements.offer(num);
        // }

        // while(closestElements.size() > k) {
        //     int left = closestElements.peekFirst();
        //     int right = closestElements.peekLast();

        //     if(Math.abs(left - x) > Math.abs(right - x)) {
        //         closestElements.pollFirst();
        //     } else {
        //         closestElements.pollLast();
        //     }
        // }

        // return new ArrayList<>(closestElements);

        // Queue maintains the farthest element on the top
        // PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> {
        //     int diffA = Math.abs(a - x);
        //     int diffB = Math.abs(b - x);

        //     if(diffA != diffB) {
        //         return diffB - diffA; // Max heap
        //     } else {
        //         return b - a; // if difference is same, then the larger value goes on the top
        //     }
        // });

        // for(int num : arr) {
        //     maxHeap.offer(num);

        //     if(maxHeap.size() > k) {
        //         maxHeap.poll(); // if more than k elems in the heap, then the remove the top most elem
        //     }
        // }

        // List<Integer> result = new ArrayList<>(maxHeap);
        // Collections.sort(result); // final result must be sorted
        // return result;

    }



    // find lower bound
    // it returns the index of target if it exists, otherwise
    // it returns the position where it should be in the array
    // private int binarySearch(int[] arr, int target) {
    //     int left = 0;
    //     int right = arr.length - 1;
    //     int ans = arr.length; // default if all elements are less than target

    //     while (left <= right) {
    //         int mid = left + (right - left) / 2;

    //         if (arr[mid] >= target) {
    //             ans = mid;
    //             right = mid - 1;
    //         } else {
    //             left = mid + 1;
    //         }
    //     }

    //     return ans;
    // }

    // public List<Integer> findClosestElements(int[] arr, int k, int x) {
    //     int xPotentialIdx = binarySearch(arr, x);

    //     int ptr1 = xPotentialIdx - 1;
    //     int ptr2 = xPotentialIdx;
    //     int chosenElem = 0;
    //     int n = arr.length;

    //     List<Integer> result = new ArrayList<>();

    //     while (ptr1 >= 0 && ptr2 < n && chosenElem < k) {
    //         int leftDiff = Math.abs(arr[ptr1] - x);
    //         int rightDiff = Math.abs(arr[ptr2] - x);

    //         if (leftDiff < rightDiff) {
    //             result.add(arr[ptr1]);
    //             ptr1--;
    //         } else if (leftDiff > rightDiff) {
    //             result.add(arr[ptr2]);
    //             ptr2++;
    //         } else {
    //             if (arr[ptr1] <= arr[ptr2]) {
    //                 result.add(arr[ptr1]);
    //                 ptr1--;
    //             } else {
    //                 result.add(arr[ptr2]);
    //                 ptr2++;
    //             }
    //         }

    //         chosenElem++;
    //     }

    //     // Add remaining elements if needed
    //     while (chosenElem < k && ptr1 >= 0) {
    //         result.add(arr[ptr1]);
    //         ptr1--;
    //         chosenElem++;
    //     }

    //     while (chosenElem < k && ptr2 < n) {
    //         result.add(arr[ptr2]);
    //         ptr2++;
    //         chosenElem++;
    //     }

    //     Collections.sort(result);
    //     return result;
    // }
}
