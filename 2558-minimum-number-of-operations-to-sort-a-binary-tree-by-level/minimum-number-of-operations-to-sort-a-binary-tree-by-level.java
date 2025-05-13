/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    public int minimumOperations(TreeNode root) {
        if(root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int swaps = 0;

        while(!queue.isEmpty()) {
            int size = queue.size();
            int[] levelValues = new int[size];

            for(int i = 0; i < size; ++i) {
                TreeNode curr = queue.poll();

                levelValues[i] = curr.val;

                if(curr.left != null) queue.offer(curr.left);
                if(curr.right != null) queue.offer(curr.right);
            }

            swaps += getMinSwaps(levelValues);
        }

        return swaps;
    }

    private int getMinSwaps(int[] original) {
        int[] target = original.clone();
        Arrays.sort(target);

        Map<Integer, Integer> valToPosition = new HashMap<>();

        for(int i = 0; i < original.length; ++i) {
            valToPosition.put(original[i], i);
        }

        int swaps = 0;
        for(int i = 0; i < original.length; ++i) {
            if(original[i] != target[i]) {
                swaps++;

                int correctPosition = valToPosition.get(target[i]);
                valToPosition.put(original[i], correctPosition);
                original[correctPosition] = original[i];
            }
        }

        return swaps;
    }
}