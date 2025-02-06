class Solution {
    public String[] findRelativeRanks(int[] score) {
        String[] ranks = new String[score.length];

        int n = score.length;

        TreeMap<Integer, Integer> map = new TreeMap<>(Comparator.reverseOrder());

        for(int i = 0; i < score.length; ++i) {
            map.put(score[i], i);
        }

        int place = 1;

        for(int key : map.keySet()) {

            if(place == 1) {
                ranks[map.get(key)] = "Gold Medal";
            } else if(place == 2) {
                ranks[map.get(key)] = "Silver Medal";
            } else if(place == 3) {
                ranks[map.get(key)] = "Bronze Medal";
            } else {
                ranks[map.get(key)] = String.valueOf(place);
            }

            place++;
        }

        return ranks;
    }
}