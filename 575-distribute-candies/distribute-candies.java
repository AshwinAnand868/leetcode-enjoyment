class Solution {
    public int distributeCandies(int[] candyType) {
        boolean[] types = new boolean[200001];
        int count = 0;
        int max = candyType.length / 2;

        for(int i = 0; i < candyType.length; ++i) {
            // index calc
            int t = 100000 + candyType[i];
            if(!types[t]) {
                count++; // new candy type
                if(count == max) return max;
                types[t] = true;
            }
        }
        return count;
        // HashMap<Integer, Integer> candyTypeToCount = new HashMap<>();

        // for(int i = 0; i < candyType.length; ++i) {
        //     candyTypeToCount.merge(candyType[i], 1, Integer::sum);
        // }

        // int n = candyType.length;

        // if(candyTypeToCount.size() >= (n/2)) {
        //     return n/2;
        // } else {
        //     return candyTypeToCount.size();
        // }
    }
}