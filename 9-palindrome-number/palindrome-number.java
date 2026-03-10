class Solution {
    public boolean isPalindrome(int x) {
        // a number is palindrome it reads the same backward and forward
        int reversed = reverseNumber(x);
        return x == reversed;
    }

    public int reverseNumber(int x) {
        int reversed = 0;

        while(x > 0) {
            int lastDigit = x % 10;
            reversed = (reversed * 10) + lastDigit;
            x = x / 10;
        }

        return reversed;
    }
}