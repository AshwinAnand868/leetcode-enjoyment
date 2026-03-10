class Solution {
    public List<List<Integer>> generate(int numRows) {
        
        List<List<Integer>> result = new ArrayList<>();

        for(int i = 0; i < numRows; ++i) {

            List<Integer> row = new ArrayList<>();

            // Populate row
            for(int j = 0; j <= i; j++) {
                row.add(1);
            }

            for(int j = 1; j < i; j++) {
                int valueOnAboveLeft = result.get(i - 1).get(j - 1);
                int valueOnAboveRight = result.get(i - 1).get(j);

                int sum = valueOnAboveLeft + valueOnAboveRight;

                row.set(j, sum);
            }

            result.add(row);
        }

        return result;
    }
}