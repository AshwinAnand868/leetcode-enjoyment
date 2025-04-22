class Solution {
    public int longestSubarray(int[] nums) {
        List<Integer> chunks = new ArrayList<>();

        int n = nums.length;
        int count = 0;
        boolean zeroesPresent = false;

        for(int num : nums) {
            if(num == 1) {
                count++;
            } else {
                if(count > 0) {
                    chunks.add(count);
                    count = 0; // reset count
                }

                chunks.add(0);
                zeroesPresent = true;
            }
        }

        // for the last chunk if count is greater than 0
        if(count > 0) {
            chunks.add(count);
        }

        if(!zeroesPresent) {
            return chunks.get(0) - 1; // if only ones are present
        }

        int max = 0;

        for(int i = 0; i < chunks.size(); i++) {
            if(chunks.get(i) == 0 && i - 1 >= 0 && i + 1 < chunks.size()) {
                max = Math.max(max, chunks.get(i + 1) + chunks.get(i - 1));
            }
        }

        // Fallback: if no 0 between two 1s was found, just take the largest 1-chunk
        for (int i = 0; i < chunks.size(); i++) {
            if (chunks.get(i) != 0) {
                max = Math.max(max, chunks.get(i));
            }
        }

        return max;
    }
}