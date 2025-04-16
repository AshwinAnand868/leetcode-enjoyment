class Solution {

    public void backtrack(int[] nums, int n, int target, int sum, int index, List<Integer> temp, List<List<Integer>> result) {
        if(index == n) return;
        
        if(sum == target) {
            List<Integer> one = new ArrayList<>(temp);
            result.add(one);
            return;
        }

        if(sum > target) {
            return;
        }

        // consider the current element unlimitd times until reach base case
        temp.add(nums[index]);
        backtrack(nums, n, target, sum + nums[index], index, temp, result);
        temp.remove(temp.size() - 1);

        // skip the current element and move on to the next
        backtrack(nums, n, target, sum, index + 1, temp, result);
    }

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, nums.length, target, 0, 0, new ArrayList<>(), result);
        return result;
    }























    // private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int remain, int start) {
    //     if (remain < 0)
    //         return;
    //     else if (remain == 0)
    //         list.add(new ArrayList<>(tempList));
    //     else {
    //         for (int i = start; i < nums.length; i++) {
    //             tempList.add(nums[i]);
    //             backtrack(list, tempList, nums, remain - nums[i], i);
    //             tempList.remove(tempList.size() - 1);
    //         }
    //     }
    // }
}