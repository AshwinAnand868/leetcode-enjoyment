/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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

    public boolean check(ListNode head, TreeNode root) {
        if(head == null) return true; // we have found the linked list inside
        if(root == null) return false; // we could not find the list in this subtree

        if(head.val != root.val) {
            return false;
        }

        return check(head.next, root.left) || check(head.next, root.right);
    }

    public boolean isSubPath(ListNode head, TreeNode root) {
        if(root == null) {
            return false; // we have reached the end of this subtree
        }

        return check(head, root) || isSubPath(head, root.left) || isSubPath(head, root.right);
    }
}