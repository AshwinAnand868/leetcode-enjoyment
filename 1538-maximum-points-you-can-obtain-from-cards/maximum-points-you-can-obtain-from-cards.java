class Solution {
    public int maxScore(int[] cardPoints, int k) {

        int i = 0, j = 0, n = cardPoints.length;
        int windowSize = n - k; // take windows of size n - k
        int maxPoints = Integer.MIN_VALUE;
        int runningSum = 0;
        int totalPoints = 0;

        for(int point : cardPoints) {
            totalPoints += point;
        }

        if(k == n) {
            return totalPoints;
        }

        while(j < n) {
            runningSum += cardPoints[j];

            if((j - i + 1) == windowSize) {
                maxPoints = Math.max(maxPoints, totalPoints - runningSum);
                runningSum -= cardPoints[i];
                i++;
            }


            ++j;
        }

        return maxPoints;




        // int n = cardPoints.length;
        // int sum = 0;
        // int i = 0, j = n - 1;

        // // if k is equal to total no of cards, then the result
        // // is simply the sum of all card points
        // if(k == n) {
        //     for(; i < n; ++i) {
        //         sum += cardPoints[i];
        //     }
        // } else {
        //     while(k > 0) {
        //         if(cardPoints[i] <= cardPoints[j]) {
        //             sum += cardPoints[j];
        //             j--;
        //         } else {
        //             sum += cardPoints[i];
        //             i++;
        //         }

        //         k--;
        //     }
        // }

        // return sum;
    }
}