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
    private int[] level = new int[1000001];
    private int[] height = new int[1000001];
    private int[] levelMaxHeight = new int[1000001];
    private int[] levelSecondMaxHeight = new int[1000001];

    private int populateHeightsAndLevelArray(TreeNode root, int l) {
        if(root == null) {
            return 0;
        }

        level[root.val] = l;
        height[root.val] = 1 + Math.max(populateHeightsAndLevelArray(root.left, l + 1), populateHeightsAndLevelArray(root.right, l + 1));

        if(levelMaxHeight[l] < height[root.val]) {
            levelSecondMaxHeight[l] = levelMaxHeight[l];
            levelMaxHeight[l] = height[root.val];
        } else if (levelSecondMaxHeight[l] < height[root.val]) {
            levelSecondMaxHeight[l] = height[root.val];
        }

        return height[root.val];
    }

    public int[] treeQueries(TreeNode root, int[] queries) {
        populateHeightsAndLevelArray(root, 0); // root is at level 0

        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int nodeLevel = level[queries[i]];
            int maxHeight = levelMaxHeight[nodeLevel] == height[queries[i]] ? levelSecondMaxHeight[nodeLevel] : levelMaxHeight[nodeLevel];

            int result = nodeLevel + maxHeight - 1;
            answer[i] = result;
        }

        return answer;
    }
}