class Solution {

    private void backtrack(int[] nums, int index, List<List<Integer>> result) {
        if(index == nums.length) {
            ArrayList<Integer> temp = new ArrayList<>();

            for(int i = 0; i < nums.length; ++i) {
                temp.add(nums[i]);
            }
            result.add(temp);
            return;
        }

        HashSet<Integer> used = new HashSet<>(); // Track used elements at this level
        for (int i = index; i < nums.length; ++i) {
            if (used.contains(nums[i])) continue; // Skip duplicates

            used.add(nums[i]);

            swap(index, i, nums);
            backtrack(nums, index + 1, result);
            swap(index, i, nums);
        }
    }

    private void swap(int left, int right, int[] arr) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }


    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, 0, result);
        return result;
    }
}