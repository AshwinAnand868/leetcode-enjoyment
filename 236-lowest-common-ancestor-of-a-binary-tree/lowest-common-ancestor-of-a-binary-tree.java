/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        LinkedList<TreeNode> pPath = new LinkedList<>();
        getNodePath(root, p.val, pPath, new boolean[] {false});

        LinkedList<TreeNode> qPath = new LinkedList<>();
        getNodePath(root, q.val, qPath, new boolean[] {false});

        TreeNode lca = null;

        ListIterator<TreeNode> pIt = pPath.listIterator(pPath.size());
        ListIterator<TreeNode> qIt = qPath.listIterator(qPath.size());


        while(pIt.hasPrevious() && qIt.hasPrevious()) {
            TreeNode pNode = pIt.previous();
            TreeNode qNode = qIt.previous();

            if (pNode == qNode) {
                lca = pNode;
            } else {
                break;
            }
        }

        return lca;
    }

    public void getNodePath(TreeNode node, int data, LinkedList<TreeNode> path, boolean[] found) {
        if(node == null || found[0]) return;

        path.addFirst(node);

        if(node.val == data) {
            found[0] = true;
            return;
        }

        getNodePath(node.left, data, path, found);
        getNodePath(node.right, data, path, found);

        if(!found[0]) {
            path.removeFirst();
        }
    }
}