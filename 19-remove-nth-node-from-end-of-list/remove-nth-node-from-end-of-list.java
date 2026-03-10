/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        if(head == null) {
            return null;
        }

        int totalNodes = 0;
        ListNode temp = head;

        while(temp != null) {
            totalNodes++;
            temp = temp.next;
        }

        int nodeBeforeTargetPos = totalNodes - n;

        // if the nth node is head
        if(nodeBeforeTargetPos == 0) {
            return head.next;
        }

        ListNode nodeBeforeTarget = head;

        while(nodeBeforeTargetPos-- > 1) {
            nodeBeforeTarget = nodeBeforeTarget.next;
        }

        if(nodeBeforeTarget != null && nodeBeforeTarget.next != null) {
            nodeBeforeTarget.next = nodeBeforeTarget.next.next;
        }

        return head;



        // if (head == null)
        //     return null;

        // // Step 1: Count total number of nodes
        // int totalNodes = 0;
        // Node temp = head;
        // while (temp != null) {
        //     totalNodes++;
        //     temp = temp.next;
        // }

        // // Step 2: Find the position to remove
        // int targetIndex = totalNodes - n; // This is already the node before the target

        // // If we need to remove the head node
        // if (targetIndex == 0) {
        //     return head.next;
        // }

        // // Step 3: Traverse to the node before the target
        // Node current = head;
        // int count = 0;
        // while (count < targetIndex - 1) {
        //     current = current.next;
        //     count++;
        // }

        // // Step 4: Remove the target node
        // if (current != null && current.next != null) {
        //     current.next = current.next.next;
        // }

        // return head;

        // // find the total count of nodes
        // ListNode current = head;
        // int totalNodes = 0;

        // while(current != null) {
        // totalNodes++;
        // current = current.next;
        // }

        // if(n == totalNodes) {
        // head = head.next;
        // return head;
        // }

        // int nodePosBeforeTarget = totalNodes - n;
        // ListNode prev = null;

        // current = head;
        // while(nodePosBeforeTarget != 0) {
        // prev = current;
        // current = current.next;
        // nodePosBeforeTarget--;
        // }

        // prev.next = current.next;

        // return head;
    }
}