class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {

        Set<Integer> set1 = new HashSet<>();
        List<Integer> result = new ArrayList<>();

        for(int i : nums1) {
            set1.add(i);
        }

        for(int i : nums2) {
            if(set1.contains(i) && !result.contains(i)) {
                result.add(i);
            }
        }

        return result.stream().mapToInt(i -> i).toArray();
    }
}