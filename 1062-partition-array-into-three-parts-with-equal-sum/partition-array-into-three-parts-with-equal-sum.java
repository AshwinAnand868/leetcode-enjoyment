class Solution {
    public boolean canThreePartsEqualSum(int[] arr) {
        int totalSum = 0;
        for(int i = 0; i < arr.length; ++i) {
            totalSum += arr[i];
        }

       if(totalSum % 3 != 0) return false;

       int currSum = 0;
       int partitions = 0;

       for(int i = 0; i < arr.length; ++i) {
            currSum += arr[i];

            if(currSum == totalSum / 3) {
                currSum = 0;
                partitions++;

                if(partitions == 2 && i < arr.length - 1) {
                    return true;
                }
            }
       }

       return false;
    }
}