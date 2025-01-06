class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        HashMap<Integer, Integer> nextGreatest = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[nums1.length];
        
        for(int i = 0; i < nums2.length; ++i) {
            int curr = nums2[i];

            while(!stack.isEmpty() && stack.peek() < curr) {
                nextGreatest.put(stack.pop(), curr);
            }

            stack.push(curr);
        }

        for(int i = 0; i < nums1.length; ++i) {
            res[i] = nextGreatest.getOrDefault(nums1[i],-1);
        }

        return res;
    }
}