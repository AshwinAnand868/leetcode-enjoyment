class Solution {
    public void fetchSubsets(List<List<Integer>> result, List<Integer> temp, int[] nums, int index) {
        if(index >= nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }

        // take
        temp.add(nums[index]);
        fetchSubsets(result, temp, nums, index + 1);
        temp.remove(temp.size() - 1);

        // skip
        fetchSubsets(result, temp, nums, index + 1);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        fetchSubsets(result, new ArrayList<>(), nums, 0);

        return result;
    }
}