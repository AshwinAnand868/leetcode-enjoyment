class Solution {
    public int minimumDifference(int[] nums, int k) {
                if (nums.length < 2)
            return 0;

        int[] sortedDesc = IntStream.of(nums)
                .boxed() // converting the stream of int[] to Stream<Integer>
                .sorted((a, b) -> b - a)
                .mapToInt(Integer::intValue)
                .toArray();

        int minimumDifference = Integer.MAX_VALUE;

        for (int i = 0; i < sortedDesc.length - 1; i++) {
            if (i + k - 1 >= sortedDesc.length) {
                break;
            } else {
                minimumDifference = Math.min(minimumDifference, Math.abs(sortedDesc[i] - sortedDesc[i + k - 1]));
            }
        }

        return minimumDifference;
        
    }
}