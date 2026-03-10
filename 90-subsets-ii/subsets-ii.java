class Solution {

    public void helper(int[] nums, int n, int start, List<List<Integer>> result, List<Integer> temp) {
        result.add(new ArrayList<>(temp));
        for(int i = start; i < n; ++i) {
            if(i > start && nums[i] == nums[i - 1]) continue;
            temp.add(nums[i]);
            helper(nums, n, i + 1, result, temp);
            temp.remove(temp.size() - 1);
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        helper(nums, nums.length, 0, result, new ArrayList<>());
        return result;
    }
}