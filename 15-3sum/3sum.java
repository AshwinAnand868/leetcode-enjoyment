class Solution {
    private void twoSum(List<List<Integer>> result, int[] nums, int target, int i, int j) {

        while (i < j) {
            if (nums[i] + nums[j] > target) {
                j--;
            } else if (nums[i] + nums[j] < target) {
                i++;
            } else { // target locked
                while (i < j && nums[i] == nums[i + 1])
                    i++;
                while (i < j && nums[j] == nums[j - 1])
                    j--;

                int n2 = nums[i];
                int n3 = nums[j];

                List<Integer> resultPart = new ArrayList<>();
                resultPart.add(-target);
                resultPart.add(n2);
                resultPart.add(n3);
                result.add(resultPart);

                i++; // update both pointers
                j--;
            }
        }
    }

    public List<List<Integer>> threeSum(int[] nums) {

        int n = nums.length;

        if (n < 3) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();

        // sort the array
        Arrays.sort(nums);

        for (int i = 0; i <= n - 3; ++i) {
            if (i > 0 && nums[i] == nums[i - 1]) { // if the element is already selected
                continue; // skip the current iteration
            }

            int n1 = nums[i];
            int target = -n1;

            twoSum(result, nums, target, i + 1, n - 1);
        }

        return result;
    }
}