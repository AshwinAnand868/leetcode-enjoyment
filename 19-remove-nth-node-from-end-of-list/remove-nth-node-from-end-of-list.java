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
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // find the total count of nodes
        ListNode current = head;
        int totalNodes = 0;

        while(current != null) {
            totalNodes++;
            current = current.next;
        }

        if(n == totalNodes) {
            head = head.next;
            return head;
        }

        int nodePosBeforeTarget = totalNodes - n;
        ListNode prev = null;

        current = head;
        while(nodePosBeforeTarget != 0) {
            prev = current;
            current = current.next;
            nodePosBeforeTarget--;
        }

        prev.next = current.next;

        return head;
    }
}