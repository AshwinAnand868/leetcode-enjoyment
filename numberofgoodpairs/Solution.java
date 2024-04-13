package numberofgoodpairs;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int numIdenticalPairs(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();

        int counter = 0;

        for (int i = 0; i < nums.length; ++i) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                counter = map.get(nums[i]) + counter;
                map.put(nums[i], map.get(nums[i]) + 1);
            }
        }

        return counter;
    }
}
