class Solution {
    public int[] findOriginalArray(int[] changed) {
        if(changed.length % 2 != 0) {
            return new int[0];
        }

        int originalArraySize = changed.length / 2;
        int[] original = new int[originalArraySize];

        HashMap<Integer, Integer> frequencyMap = new HashMap<>();

        // sort the changed array
        Arrays.sort(changed);

        for(int i : changed) {
            frequencyMap.merge(i, 1, Integer::sum);
        }

        for(int i = 0, j= 0; i < changed.length; ++i) {
            if(frequencyMap.containsKey(changed[i] * 2) && frequencyMap.get(changed[i]) > 0 && frequencyMap.get(changed[i] * 2) > 0) {
                original[j] = changed[i];
                frequencyMap.merge(changed[i], -1, Integer::sum);
                frequencyMap.merge(changed[i] * 2, -1, Integer::sum);
                ++j;
            } else if(frequencyMap.get(changed[i]) == 0) {
                continue;
            } else {
                return new int[0];
            }
        }

        return original;
    }
}