class Solution {

    private boolean binarySearch(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while(low <= high) {
            int mid = low + (high - low) / 2;
            
            if(nums[mid] == target) {
                return true;
            } else if(nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return false;
    }

    public int[] intersection(int[] nums1, int[] nums2) {

        Set<Integer> set = new HashSet<>();
        Arrays.sort(nums2);

        for(Integer num : nums1) {
            if(binarySearch(nums2, num)) {
                set.add(num);
            }
        }

        int i = 0;
        int[] result = new int[set.size()];

        for(Integer num : set) {
            result[i++] = num;
        }

        return result;


        // Arrays.sort(nums1);
        // Arrays.sort(nums2);

        // int i = 0;
        // int j = 0;
        // Set<Integer> intersect = new HashSet<>();
        
        // while(i < nums1.length && j < nums2.length) {
        //     if(nums1[i] == nums2[j]) {
        //     intersect.add(nums1[i]);
        //         i++;
        //         j++;
        //     } else if(nums1[i] < nums2[j]) {
        //         i++;
        //     } else {
        //         j++;
        //     }
        // }

        // return intersect.stream().mapToInt(e -> e).toArray();

        // Set<Integer> set1 = new HashSet<>();
        // List<Integer> result = new ArrayList<>();

        // for(int i : nums1) {
        //     set1.add(i);
        // }

        // for(int i : nums2) {
        //     if(set1.contains(i) && !result.contains(i)) {
        //         result.add(i);
        //     }
        // }

        // return result.stream().mapToInt(i -> i).toArray();
    }
}