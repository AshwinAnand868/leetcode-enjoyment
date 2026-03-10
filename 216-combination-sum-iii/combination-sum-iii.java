class Solution {

    public void backtrack(List<List<Integer>> result, int[] nums, int k, int n, int index, int sum, List<Integer> temp) {
        if(temp.size() == k && sum == n) {
            result.add(new ArrayList<>(temp));
            return;
        }

        if(index > nums.length || sum > n) return;

        for(int i = index; i < nums.length; ++i) {
            temp.add(nums[i]);
            backtrack(result, nums, k, n, i + 1, sum + nums[i], temp);
            temp.remove(temp.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] nums = new int[9];
        for(int i = 0; i < 9; ++i) {
            nums[i] = i + 1;
        }

        List<List<Integer>> result = new ArrayList<>();

        backtrack(result, nums, k, n, 0, 0, new ArrayList<>());

        return result;
    }
}