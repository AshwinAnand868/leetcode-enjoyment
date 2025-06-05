class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> sub = new ArrayList<>();
        // Binary search
        for(int num : nums) {
            int i = Collections.binarySearch(sub, num);
            if(i < 0) i = -(i + 1);
            if(i == sub.size()) {
                sub.add(num);
            } else {
                sub.set(i, num);
            }
        }

        return sub.size();
    }
}