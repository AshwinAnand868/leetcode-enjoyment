class Solution {

    private void collectTargetSumSubsets(List<List<Integer>> result, int[] candidates, int target, int index, int runningSum, List<Integer> temp) {
        if(runningSum > target || index >= candidates.length) return;

        if(runningSum == target) {
            result.add(new ArrayList<>(temp));
            return;
        }

        // take
        runningSum += candidates[index];
        temp.add(candidates[index]);
        collectTargetSumSubsets(result, candidates, target, index, runningSum, temp); // reuse the same element multiple times at the same index
        runningSum -= candidates[index];
        temp.remove(temp.size() - 1);

        // skip
        collectTargetSumSubsets(result, candidates, target, index + 1, runningSum, temp);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();

        collectTargetSumSubsets(result, candidates, target, 0, 0, new ArrayList<>());

        return result;
    }
}