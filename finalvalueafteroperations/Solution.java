package finalvalueafteroperations;

public class Solution {
    public int finalValueAfterOperations(String[] operations) {
        // int x = 0;

        int result = 0;

        for (String x : operations) {
            if (x.charAt(1) == '-') {
                result--;
            } else {
                result++;
            }
        }

        return result;
        // for(String operation: operations) {
        // if(operation.equals("++X") || operation.equals("X++")) {
        // x++;
        // } else {
        // x--;
        // }
        // }

        // return x;
    }
}
