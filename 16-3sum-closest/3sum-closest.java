class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int closestSum = 100000;
        int n = nums.length;

        // sorting the array
        Arrays.sort(nums);

        // Fixing k as the first element
        for(int k = 0; k <= n - 3; ++k) {
            int i = k + 1;
            int j = n - 1;

            while (i < j) {
                int sum = nums[k] + nums[i] + nums[j];

                if(Math.abs(target - sum) < Math.abs(target - closestSum)) {
                    closestSum = sum;
                }

                if(sum < target) {
                    i++;
                } else {
                    j--;
                }
            }
        }

        return closestSum;
    }
}