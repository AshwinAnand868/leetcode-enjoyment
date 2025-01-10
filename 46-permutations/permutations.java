class Solution {
    public void makePermutations(int index, int[] nums, List<List<Integer>> ans) {

        if (index == nums.length) {
            List<Integer> ds = new ArrayList<>();

            for (int i = 0; i < nums.length; ++i) {
                ds.add(nums[i]); // add the swapped values
            }

            ans.add(new ArrayList<>(ds));

            return;
        }

        for (int i = index; i < nums.length; ++i) {
            swap(index, i, nums);
            makePermutations(index + 1, nums, ans);
            swap(index, i, nums);
        }
    }

    public void swap(int index, int i, int[] nums) {
        int t = nums[i];
        nums[i] = nums[index];
        nums[index] = t;
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        boolean[] freq = new boolean[nums.length];
        makePermutations(0, nums, res);
        return res;
    }

    // public void makePermutations(int[] nums, List<Integer> ds, boolean[] freq,
    // List<List<Integer>> ans) {
    // if (ds.size() == nums.length) {
    // ans.add(new ArrayList<>(ds));
    // return;
    // }

    // for (int i = 0; i < nums.length; i++) {
    // if (!freq[i]) {
    // freq[i] = true;
    // ds.add(nums[i]);
    // makePermutations(nums, ds, freq, ans);
    // ds.remove(ds.size() - 1);
    // freq[i] = false;
    // }
    // }
    // }

    // public List<List<Integer>> permute(int[] nums) {
    // List<List<Integer>> res = new ArrayList<>();
    // List<Integer> ds = new ArrayList<>();
    // boolean[] freq = new boolean[nums.length];
    // makePermutations(nums, ds, freq, res);
    // return res;
    // }
}