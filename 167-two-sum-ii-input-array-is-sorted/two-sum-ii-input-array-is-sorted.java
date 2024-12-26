class Solution {
    public int[] twoSum(int[] numbers, int target) {

        int i = 0;
        int j = numbers.length - 1;
        int[] indices = new int[2];

        while (i < j) {
            if (numbers[i] + numbers[j] < target) // need to increase the addition result
            {
                i++; // go to higher value

            } else if (numbers[i] + numbers[j] > target) // need to decrease the addition result
            {
                j--; // move toward lower value

            } else { // both are equal
                indices[0] = i + 1;
                indices[1] = j + 1;
                break;
            }
        }

        return indices;
    }
}