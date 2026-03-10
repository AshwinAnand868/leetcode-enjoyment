class Solution {
    public int[] plusOne(int[] digits) {

        int n = digits.length;
        int carry = 0;

        for(int i = n - 1; i >= 0; --i) {
            int temp = digits[i] + 1;

            if(temp < 10) {
                digits[i] += 1;
                return digits;
            } else {
                carry = (digits[i] + 1) - 9;
                digits[i] = 0;
            }
        }

        int[] newDigits = new int[n + 1];
        newDigits[0] = carry;

        return newDigits;
       
        // long largeNumber = digits[0];
        // int n = digits.length;

        // if(n == 1) {
        //     digits[0] = digits[0] + 1;

        //     if(digits[0] > 9) {
        //         return new int[] { digits[0] / 10, digits[0] % 10};
        //     }
        //     return digits;
        // }

        // for(int i = 1; i < n; ++i) {
        //     largeNumber = largeNumber * 10 + digits[i]; // construct the large number
        // }


        // System.out.println(largeNumber);
        // // plus one
        // largeNumber += 1;

        // // convert large number to string
        // String large = Long.toString(largeNumber);

        // int[] result = large.chars()
        //     .map(Character::getNumericValue)
        //     .toArray();

        // return result;
    }
}