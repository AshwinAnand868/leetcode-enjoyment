class Solution {

    public void backTrack(List<List<Integer>> result, List<Integer> temp, int index, int[] nums) {
        result.add(new ArrayList<>(temp));

        for(int i = index; i < nums.length; ++i) {
            temp.add(nums[i]);
            backTrack(result, temp, i + 1, nums);
            temp.remove(temp.size() - 1);
        }
        // if(index >= nums.length) {
        //     result.add(new ArrayList<>(temp));
        //     return;
        // }

        // // take
        // temp.add(nums[index]);
        // backTrack(result, temp, index + 1, nums);

        // // skip
        // temp.remove(temp.size() - 1);
        // backTrack(result, temp, index + 1, nums);

    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        backTrack(result, new ArrayList<>(), 0, nums);

        return result;
    }
}