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
        List<TreeNode> pPath = new ArrayList<>();
        List<TreeNode> qPath = new ArrayList<>();

        getNodePath(root, p, pPath, new boolean[] {false});
        getNodePath(root, q, qPath, new boolean[] {false});

        int i = 0;
        TreeNode lca = null;
        while (i < pPath.size() && i < qPath.size()) {
            if (pPath.get(i) == qPath.get(i)) {
                lca = pPath.get(i);
            } else {
                break;
            }
            i++;
        }

        return lca;
    }

    public void getNodePath(TreeNode node, TreeNode target, List<TreeNode> path, boolean[] found) {
        if (node == null || found[0]) return;

        path.add(node);

        if (node == target) {
            found[0] = true;
            return;
        }

        getNodePath(node.left, target, path, found);
        getNodePath(node.right, target, path, found);

        if (!found[0]) path.remove(path.size() - 1); // backtrack
    }
}

// class Solution {
//     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//         LinkedList<TreeNode> pPath = new LinkedList<>();
//         getNodePath(root, p.val, pPath, new boolean[] {false});

//         LinkedList<TreeNode> qPath = new LinkedList<>();
//         getNodePath(root, q.val, qPath, new boolean[] {false});

//         TreeNode lca = null;

//         ListIterator<TreeNode> pIt = pPath.listIterator(pPath.size());
//         ListIterator<TreeNode> qIt = qPath.listIterator(qPath.size());


//         while(pIt.hasPrevious() && qIt.hasPrevious()) {
//             TreeNode pNode = pIt.previous();
//             TreeNode qNode = qIt.previous();

//             if (pNode == qNode) {
//                 lca = pNode;
//             } else {
//                 break;
//             }
//         }

//         return lca;
//     }

//     public void getNodePath(TreeNode node, int data, LinkedList<TreeNode> path, boolean[] found) {
//         if(node == null || found[0]) return;

//         path.addFirst(node);

//         if(node.val == data) {
//             found[0] = true;
//             return;
//         }

//         getNodePath(node.left, data, path, found);
//         getNodePath(node.right, data, path, found);

//         if(!found[0]) {
//             path.removeFirst();
//         }
//     }
// }