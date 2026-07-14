class Solution {
    private int helper(int num) {
        if(num <= 0) return 0;
        return num % 10 + helper(num / 10);
    }

    public int addDigits(int num) {
        if(num <  10) return num;
        return addDigits(helper(num));
    }
}