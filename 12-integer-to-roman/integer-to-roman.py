class Solution(object):
    def intToRoman(self, num):
        symbols = ["M", "CM", "D", "CD", "C", "XC", 
            "L", "XL", "X", "IX", "V", "IV", "I"]
        
        values = [1000, 900, 500, 400, 100, 90, 
            50, 40, 10, 9, 5, 4, 1]

        result = []

        for i in range(len(values)):
            quotient = num // values[i]
            remainder = num % values[i]

            result.append(symbols[i] * quotient)
            num = remainder
        
        return ''.join(result)
        