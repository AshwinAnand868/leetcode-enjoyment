class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        
        int n = nums.length;
        int[] tempArray = new int[n + 1];
        List<Integer> result = new ArrayList<>();

        for(int i = 0; i < n; ++i) {
            tempArray[nums[i]]++;
        }

        for(int i = 1; i <= n; ++i) {
            if(tempArray[i] == 0) {
                result.add(i);
            }
        }
        
        return result;
    }
}