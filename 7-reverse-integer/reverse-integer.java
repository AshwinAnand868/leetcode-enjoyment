class Solution {
    public int reverse(int x) {
        
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        int reversedX = 0;

        while (x != 0) {
            int pop = x % 10;
            x = x / 10;

            System.out.println(reversedX * 10);

            if (reversedX > max / 10 || (reversedX == max / 10 && pop > 7))
                return 0;
            if (reversedX < min / 10 || (reversedX == min / 10 && pop < -8))
                return 0;

            reversedX = reversedX * 10 + pop;
        }

        return reversedX;

    }
}