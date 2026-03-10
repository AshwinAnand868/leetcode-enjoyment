class Solution {
    public int myAtoi(String s) {
        int sign = 1, result = 0, i = 0;
        int n = s.length();

        while(i < n && s.charAt(i) == ' ') {
            i++;
        }

        if(i == n) return result;

        if(s.charAt(i) == '-' || s.charAt(i) == '+') {
            sign = s.charAt(i) == '-' ? -1 : 1;
            i++;

            if(i == n) return result * sign;
        }

        while(i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
            if(result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && s.charAt(i) - '0' > 7)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            result = result * 10 + (s.charAt(i) - '0');
            i++;
        }

        return result * sign;
    }
}