class Solution {
    public List<Integer> getRow(int rowIndex) {

        int[] arr = new int[rowIndex + 1];
        arr[0] = 1;

        for(int i = 1; i <= rowIndex; ++i) {
            for(int j = i; j > 0; --j) {
                arr[j] += arr[j - 1];
            }
        }

        List<Integer> res = new ArrayList<>();

        for(int a : arr) {
            res.add(a);
        }

        return res;

        // List<List<Integer>> pT = new ArrayList<>();

        // for(int i = 0; i <= rowIndex; ++i) {
        //     List<Integer> row = new ArrayList<>();

        //     for(int j = 0; j <= i; ++j) {
        //         row.add(1);
        //     }

        //     for(int j = 1; j < i; ++j) {
        //         int aboveValOnLeft = pT.get(i - 1).get(j - 1);
        //         int aboveValOnRight = pT.get(i - 1).get(j);

        //         row.set(j, aboveValOnLeft + aboveValOnRight);
        //     }

        //     pT.add(row);
        // }

        // return pT.get(rowIndex);
    }
}