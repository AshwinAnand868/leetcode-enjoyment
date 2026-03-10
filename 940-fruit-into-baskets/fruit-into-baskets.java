class Solution {
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> fruitsCount = new HashMap<>();
        int i = 0, maxFruits = 0;

        for(int j = 0; j < fruits.length; ++j) {
            fruitsCount.put(fruits[j], fruitsCount.getOrDefault(fruits[j], 0) + 1);

            while(fruitsCount.size() > 2) {
                fruitsCount.put(fruits[i], fruitsCount.get(fruits[i]) - 1);

                if(fruitsCount.get(fruits[i]) == 0) {
                    fruitsCount.remove(fruits[i]);
                }
                i++;
            }

            maxFruits = Math.max(maxFruits, j - i + 1);
        }

        return maxFruits;
    }
}