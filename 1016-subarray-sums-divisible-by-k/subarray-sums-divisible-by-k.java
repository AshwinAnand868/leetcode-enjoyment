class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> remainderWithCount = new HashMap<>();
        remainderWithCount.put(0, 1);

        int sum = 0;
        int count = 0;

        for (int num : nums) {
            sum += num;

            int rem = ((sum % k) + k) % k;

            if (remainderWithCount.containsKey(rem)) {
                count += remainderWithCount.get(rem);
            }

            remainderWithCount.put(rem, remainderWithCount.getOrDefault(rem, 0) + 1);
        }

        return count;
    }
}
