class Solution {
    public boolean isPalindrome(int x) {
        
        // negative number is not a palindrome for this case
        if(x < 0) return false;
        
        int j = x; // copy of x
        int r = 0;
        int reversedJ = 0;
        
        while(j != 0) {
            r = j % 10; // get the remainder
            j = j / 10; // take out the last digit from j
            
            reversedJ = reversedJ * 10 + r; // add the remainder to reversed value of j
        }
        
        if(x == reversedJ)
            return true;
        
        return false;
    }
}