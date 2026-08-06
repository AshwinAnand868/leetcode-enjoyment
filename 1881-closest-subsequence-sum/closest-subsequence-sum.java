class Solution {

    private void generateSubsets(int[] nums, int index, int n, int sum, List<Integer> sums) {
        if (index == n) {
            sums.add(sum);
            return;
        }

        // take
        generateSubsets(nums, index + 1, n, sum + nums[index], sums);

        // skip
        generateSubsets(nums, index + 1, n, sum, sums);
    }

    private int lowerbound(List<Integer> rightSum, int key) {
        int low = 0;
        int high = rightSum.size() - 1;

        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (rightSum.get(mid) >= key) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    public int minAbsDifference(int[] nums, int goal) {

        int n = nums.length;

        List<Integer> leftSum = new ArrayList<>();
        List<Integer> rightSum = new ArrayList<>();

        generateSubsets(nums, 0, n / 2, 0, leftSum);
        generateSubsets(nums, n / 2, n, 0, rightSum);

        Collections.sort(rightSum);

        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < leftSum.size(); i++) {

            int left = leftSum.get(i);
            int idx = lowerbound(rightSum, goal - left);

            // lower bound candidate
            if (idx != -1) {
                ans = Math.min(ans,
                        Math.abs(left + rightSum.get(idx) - goal));
            }

            // previous element
            if (idx > 0) {
                ans = Math.min(ans,
                        Math.abs(left + rightSum.get(idx - 1) - goal));
            }

            // if lower bound doesn't exist
            if (idx == -1) {
                ans = Math.min(ans,
                        Math.abs(left + rightSum.get(rightSum.size() - 1) - goal));
            }
        }

        return ans;
    }
}