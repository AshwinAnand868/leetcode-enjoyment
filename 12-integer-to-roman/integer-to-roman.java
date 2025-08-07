class Solution {
    private static final String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    private static final int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    
    public String intToRoman(int num) {

         int i = 0;
         StringBuilder sb = new StringBuilder();

         while(num > 0) {
            while(num >= values[i]) {
                num = num - values[i];
                sb.append(symbols[i]);
            }
            i++;
         }

         return sb.toString();
    }
}