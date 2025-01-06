class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        HashMap<Integer, Integer> nextGreatest = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[nums1.length];
        int n = nums2.length;

        for (int i = n - 1; i >= 0; --i) {
            int curr = nums2[i];

            while (!stack.isEmpty() && stack.peek() < curr) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                nextGreatest.put(curr, -1);
            } else {
                nextGreatest.put(curr, stack.peek());
            }

            stack.push(curr);
        }

        for (int i = 0; i < nums1.length; ++i) {
            res[i] = nextGreatest.get(nums1[i]);
        }

        return res;
    }
}