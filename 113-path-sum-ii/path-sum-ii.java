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

    private void dfs(List<List<Integer>> paths, List<Integer> currPath, TreeNode root, int targetSum, int runningSum) {
        if(root == null) return;

        if(root.left == null && root.right == null) {
            if(runningSum == targetSum) {
                paths.add(new ArrayList<>(currPath));
            }
            return;
        }


        if(root.left != null) {
            currPath.add(root.left.val);
            dfs(paths, currPath, root.left, targetSum, runningSum + root.left.val);
            currPath.remove(currPath.size() - 1);
        }

        if(root.right != null) {
            currPath.add(root.right.val);
            dfs(paths, currPath, root.right, targetSum, runningSum + root.right.val);
            currPath.remove(currPath.size() - 1);
        }
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        if(root == null) return new ArrayList<>();

        List<List<Integer>> paths = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(root.val);
        dfs(paths, list ,root, targetSum, root.val);
        return paths;
    }
}