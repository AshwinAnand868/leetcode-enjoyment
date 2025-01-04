class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0;
        int j = 0;
        Set<Integer> intersect = new HashSet<>();
        
        while(i < nums1.length && j < nums2.length) {
            if(nums1[i] == nums2[j]) {
            intersect.add(nums1[i]);
                i++;
                j++;
            } else if(nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }

        return intersect.stream().mapToInt(e -> e).toArray();

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