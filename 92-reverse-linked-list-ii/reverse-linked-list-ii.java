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
    
    public ListNode reverse(ListNode head, ListNode rightNode) {
        if (head == null || head.next == null || head == rightNode) {
            return head;
        }
        
        ListNode last = reverse(head.next, rightNode);
        head.next.next = head;
        head.next = null;
        return last;
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null || left == right) {
            return head;
        }

        ListNode leftNode = null, leftPrev = null, rightNode = null, rightNext = null;
        ListNode curr = head;
        int c = 1;

        // Find leftPrev and leftNode
        while (c < left) {
            leftPrev = curr;
            curr = curr.next;
            c++;
        }
        leftNode = curr;

        // Find rightNode and rightNext
        while (c < right) {
            curr = curr.next;
            c++;
        }
        rightNode = curr;
        rightNext = rightNode.next;

        // Reverse nodes from leftNode to rightNode
        ListNode temp = reverse(leftNode, rightNode);

        // Adjust the connections
        if (leftPrev != null) {
            leftPrev.next = temp;
        } else {
            // If left = 1, update head
            head = temp;
        }

        leftNode.next = rightNext; // Connect last node of reversed section

        return head;
    }
}
