class Solution {
    public int minDeletionSize(String[] strs) {
        // column-wise iteration
        int cols = strs[0].length();
        int rows = strs.length;
        int count = 0;

        for(int i = 0; i < cols; ++i) {
            for(int j = 1; j < rows; ++j) {
                if(strs[j].charAt(i) < strs[j - 1].charAt(i)) {
                    count++;
                    break;
                }
            }  
        }

        return count;
    }
}