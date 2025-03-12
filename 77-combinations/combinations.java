class Solution {

    public void makeCombinations(List<List<Integer>> combinations, int k, List<Integer> temp, int index, int n) {
        if(k == 0) { // we found a combination
            combinations.add(new ArrayList<>(temp));
            return;
        }

        for(int i = index; i <= n; ++i) {
            temp.add(i);
            makeCombinations(combinations, k - 1, temp, i + 1, n);
            temp.remove(temp.size() - 1);
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> combinations = new ArrayList<>();

        makeCombinations(combinations, k, new ArrayList<Integer>(), 1, n);

        return combinations;
    }
}