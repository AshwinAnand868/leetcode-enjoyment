class Solution {

    private void backtrack(int[] nums, int remaining, int index, List<Integer> temp, List<List<Integer>> result) {
        if(remaining < 0) return;
        else if(remaining == 0) {
            result.add(new ArrayList<>(temp));
        } else {
            for(int i = index; i < nums.length; ++i) {
                if(i > index && nums[i] == nums[i - 1]) continue;
                temp.add(nums[i]);
                backtrack(nums, remaining - nums[i], i + 1, temp, result);
                temp.remove(temp.size() - 1);
            }
        }

    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }
}