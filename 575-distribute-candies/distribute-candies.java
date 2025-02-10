class Solution {
    public int distributeCandies(int[] candyType) {
        HashMap<Integer, Integer> candyTypeToCount = new HashMap<>();

        for(int i = 0; i < candyType.length; ++i) {
            candyTypeToCount.merge(candyType[i], 1, Integer::sum);
        }

        int n = candyType.length;

        if(candyTypeToCount.size() >= (n/2)) {
            return n/2;
        } else {
            return candyTypeToCount.size();
        }
    }
}