class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result = new ArrayList<>();

        int maximumCandies = 0;

        for(int candy: candies) {
            maximumCandies = Math.max(maximumCandies, candy);
        }

        for(int candy: candies) {
            if(candy + extraCandies >= maximumCandies) {
                result.add(true);
            } else {
                result.add(false);
            }
        }

        return result;
    }
}