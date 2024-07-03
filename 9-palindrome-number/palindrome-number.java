class Solution {
    public boolean isPalindrome(int x) {
        int[] arrayOfX = convertIntToArray(x);
        
        // special case if the x consists of only 2 digits
        if(arrayOfX.length == 2) {
            return arrayOfX[0] == arrayOfX[1];
        }
        
        int i = 0;
        int j = arrayOfX.length - 1;
        boolean continueL = true;
        boolean toReturn = false;
        
        while(i < j && continueL) {
            if(arrayOfX[i] == arrayOfX[j]) {
                i++;
                j--;
            } else {
                continueL = false; // not a palindrome
            }
        }
        
        if(i == j) // it is a palindrome
            toReturn = true;
        
        if(!toReturn && continueL && (arrayOfX.length % 2) == 0 && i > j) {
            toReturn = true;
        }
        
        return toReturn;
    }
    
    public int[] convertIntToArray(int x) {
        String xStr = Integer.toString(x);
        int[] toReturn = new int[xStr.length()];
        
        for(int i = 0; i < toReturn.length; i++) {
            toReturn[i] = xStr.charAt(i) - '0'; // getting int value for the character number
        }
        
        return toReturn;
    }
}