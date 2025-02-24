class Solution {
    public int waysToMakeFair(int[] nums) {
        int n = nums.length;
        int count = 0;
        int totalEven = 0, totalOdd = 0;

        for(int i = 0; i < nums.length; ++i) {
            if(i % 2 == 0) {
                totalEven += nums[i]; // sum the initial even indices values
            } else {
                totalOdd += nums[i]; // sum the initial odd indices values
            }
        }

        int prefixEven = 0;
        int prefixOdd = 0;

        for(int i = 0; i < nums.length; ++i) {
            if(i % 2 == 0) {
                totalEven -= nums[i];
            } else {
                totalOdd -= nums[i];
            }

            int newEvenSum = prefixEven + totalOdd;
            int newOddSum = prefixOdd + totalEven;

            if(newEvenSum == newOddSum) {
                count += 1;
            }

            if(i % 2 == 0) {
                prefixEven += nums[i];
            } else {
                prefixOdd += nums[i];
            }
        }

        return count;

        // for (int i = 0; i < n; i++) {
        //     // Create a temporary list excluding nums[i]
        //     List<Integer> tempList = new ArrayList<>();
        //     for (int j = 0; j < n; j++) {
        //         if (j != i) {  // Exclude element at index i
        //             tempList.add(nums[j]);
        //         }
        //     }

        //     // Compute even and odd sums based on new indices
        //     int evenSum = 0, oddSum = 0;
        //     for (int k = 0; k < tempList.size(); k++) {
        //         if (k % 2 == 0) {
        //             evenSum += tempList.get(k);
        //         } else {
        //             oddSum += tempList.get(k);
        //         }
        //     }

        //     // If sums are equal, increment the count
        //     if (evenSum == oddSum) {
        //         count++;
        //     }
        // }

        // return count;
    }
}