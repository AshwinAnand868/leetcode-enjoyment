package finalvalueafteroperations.shufflethearray;

public class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] ans = new int[nums.length];

        for (int z = 0; z < n; z++) {
            ans[2 * z] = nums[z];
            ans[2 * z + 1] = nums[z + n];
        }
        return ans;
    }
}
