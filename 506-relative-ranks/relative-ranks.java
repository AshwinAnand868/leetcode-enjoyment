class Solution {
    public String[] findRelativeRanks(int[] score) {
        String[] ranks = new String[score.length];

        int n = score.length;

        int maxScore = 0;

        for (int i = 0; i < n; ++i) {
            maxScore = Math.max(maxScore, score[i]);
        }

        int[] scoreToIndex = new int[maxScore + 1];

        for (int i = 0; i < n; ++i) {
            scoreToIndex[score[i]] = i + 1;
        }
        

        int place = 1;

        for (int i = maxScore; i >= 0; --i) {
            if (scoreToIndex[i] == 0)
                continue;

            int originalIndex = scoreToIndex[i] - 1;

            if (place == 1) {
                ranks[originalIndex] = "Gold Medal";
            } else if (place == 2) {
                ranks[originalIndex] = "Silver Medal";
            } else if (place == 3) {
                ranks[originalIndex] = "Bronze Medal";
            } else {
                ranks[originalIndex] = String.valueOf(place);
            }

            place++;
        }

        return ranks;

        // TreeMap<Integer, Integer> map = new TreeMap<>(Comparator.reverseOrder());

        // for(int i = 0; i < score.length; ++i) {
        // map.put(score[i], i);
        // }

        // int place = 1;

        // for(int key : map.keySet()) {

        // if(place == 1) {
        // ranks[map.get(key)] = "Gold Medal";
        // } else if(place == 2) {
        // ranks[map.get(key)] = "Silver Medal";
        // } else if(place == 3) {
        // ranks[map.get(key)] = "Bronze Medal";
        // } else {
        // ranks[map.get(key)] = String.valueOf(place);
        // }

        // place++;
        // }

        // return ranks;
    }
}