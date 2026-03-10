class Solution {
    public int maxScore(int[] cardPoints, int k) {

        int n = cardPoints.length;
        int maxPoints = 0;
        int leftSum = 0, rightSum = 0;

        for(int i = 0; i < k; ++i) {
            leftSum += cardPoints[i];
        }

        maxPoints = leftSum;

        for(int left = k - 1, right = n - 1; left >= 0; left--, right--) {
            leftSum -= cardPoints[left];
            rightSum += cardPoints[right];
            maxPoints = Math.max(maxPoints, leftSum + rightSum);
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