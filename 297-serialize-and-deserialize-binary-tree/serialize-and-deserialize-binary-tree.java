/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        StringBuilder sb = new StringBuilder();

        while(!queue.isEmpty()) {
            TreeNode curr = queue.poll();

            if(curr == null) {
                sb.append("# ");
                continue;
            }

            sb.append(curr.val + " ");
            queue.offer(curr.left);
            queue.offer(curr.right);
        }

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("")) return null;
        Queue<TreeNode> q = new LinkedList<>();
        String[] values = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        q.offer(root);

        for(int i = 1; i < values.length; ++i) {
            TreeNode curr = q.poll();
            if(!values[i].equals("#")) {
                TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                curr.left = left;
                q.offer(left);
            }
            i++;
            if(!values[i].equals("#")) {
                TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                curr.right = right;
                q.offer(right);
            }
        }

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));