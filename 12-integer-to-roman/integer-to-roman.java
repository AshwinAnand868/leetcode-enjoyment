class Solution {
    private static final int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static final String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public String intToRoman(int num) {
        return convert(num, 0);
    }

    private String convert(int num, int index) {
        // Base case: If num is 0, return an empty string
        if (num == 0) return "";

        // Get how many times the current Roman numeral fits in num
        int quotient = num / values[index];  
        
        // Get the remainder for next recursive call
        int remainder = num % values[index];  

        // Append the Roman numeral `quotient` times and recursively process the remainder
        return symbols[index].repeat(quotient) + convert(remainder, index + 1);
    }
}