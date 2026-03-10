/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        if (node == null)
            return;

        // O(n) TC
        ListNode prev = null;
        ListNode current = node;

        while (current != null && current.next != null) {
            current.val = current.next.val;
            prev = current;
            current = current.next;
        }

        prev.next = null;

        // O(1) TC
        // node.val = node.next.val;
        // node.next = node.next.next;
    }
}