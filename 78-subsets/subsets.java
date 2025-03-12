class Solution {

    public void backtrack(List<List<Integer>> subsetsList, ArrayList<Integer> temp, int index, int n, int[] nums) {
        subsetsList.add(new ArrayList<>(temp));
        for(int i = index; i < n; ++i) {
            temp.add(nums[i]);
            backtrack(subsetsList, temp, i + 1, n, nums);
            temp.remove(temp.size() - 1);
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsetsList = new ArrayList<>();
        // Arrays.sort(nums);
        backtrack(subsetsList, new ArrayList<>(), 0, nums.length, nums);
        return subsetsList;
    }
}