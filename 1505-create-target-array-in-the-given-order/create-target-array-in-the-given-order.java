class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        int[] target = new int[nums.length];
        ArrayList<Integer> arr = new ArrayList<>();

        for (int i = 0; i < target.length; i++) {
            arr.add(index[i], nums[i]);
        }

        for (int i = 0; i < nums.length; i++) {
            target[i] = arr.get(i);
        }
        
        return target;
    }
}