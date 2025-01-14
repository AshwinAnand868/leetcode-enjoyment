class Solution {
    public int clumsy(int n) {

        Stack<Integer> nums = new Stack<>();
        int operation = 0;
        nums.push(n);

        for(int i = n - 1; i >= 1; --i) {
            // Multiply
            if(operation == 0) {
                nums.push(nums.pop() * i);
            } else if(operation == 1) { // Divide
                nums.push(nums.pop() / i);
            } else if(operation == 2) { // Just Add to Stack
                nums.push(i);
            } else {
                nums.push(-i);
            }

            operation = ((operation + 1) % 4);
        }

        int result = 0;
        while(!nums.isEmpty()) {
            result += nums.pop();
        }

        return result;
    }
}