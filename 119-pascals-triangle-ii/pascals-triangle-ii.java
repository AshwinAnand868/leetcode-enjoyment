class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> pT = new ArrayList<>();

        for(int i = 0; i <= rowIndex; ++i) {
            List<Integer> row = new ArrayList<>();

            for(int j = 0; j <= i; ++j) {
                row.add(1);
            }

            for(int j = 1; j < i; ++j) {
                int aboveValOnLeft = pT.get(i - 1).get(j - 1);
                int aboveValOnRight = pT.get(i - 1).get(j);

                row.set(j, aboveValOnLeft + aboveValOnRight);
            }

            pT.add(row);
        }

        return pT.get(rowIndex);
    }
}