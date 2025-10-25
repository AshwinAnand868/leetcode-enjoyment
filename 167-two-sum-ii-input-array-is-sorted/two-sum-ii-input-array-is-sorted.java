class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int x = 0;
        int y = n - 1;

        while(x < y) {
            int num1 = numbers[x];
            int num2 = numbers[y];

            int sum = num1 + num2;
            if(sum == target) {
                return new int[] {x + 1, y + 1};
            } else if(sum < target) {
                x++;
            } else {
                y--;
            }
        }

        return new int[] {-1, -1};
    }
}