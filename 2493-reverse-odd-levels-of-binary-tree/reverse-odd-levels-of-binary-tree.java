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
    public TreeNode reverseOddLevels(TreeNode root) {
        int level = 0;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        
        while(!queue.isEmpty()) {
            int n = queue.size();
            ArrayList<TreeNode> list = new ArrayList<>(); // all nodes per level
            while(n-- > 0) {
                TreeNode node = queue.peek();
                queue.poll();
                
                list.add(node);
                
                if(node.left != null) {
                    queue.offer(node.left);
                }
                
                if(node.right != null) {
                    queue.offer(node.right);
                }
            }
            
            if(level % 2 == 1) {
               int i = 0;
                int j = list.size() - 1;
                
                while(i < j) {
                    int temp = list.get(i).val;
                    list.get(i).val = list.get(j).val;
                    list.get(j).val = temp;
                    
                    i++;
                    j--;
                }
            }
            
            level++;
        } 
        
        return root;
        
    }
}