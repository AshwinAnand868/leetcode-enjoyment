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
        if(head == null || head.next == null || head == rightNode) {
            return head;
        }

        ListNode newHead = reverse(head.next, rightNode);
        // reverse the pointers
        ListNode front = head.next;
        front.next = head;
        head.next = null;

        return newHead;
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null || left == right) {
            return head;
        }

        ListNode leftPrev = null, leftNode = null, rightNext = null, rightNode = null;
        ListNode curr = head;
        int counter = 1;

        while(counter < left) {
            leftPrev = curr;
            curr = curr.next;
            counter++;
        }

        leftNode = curr;

        while(counter < right) {
            curr = curr.next;
            counter++;
        }

        rightNode = curr;
        rightNext = curr.next;

        ListNode newReversedHead = reverse(leftNode, rightNode);

        if(leftPrev != null) {
            leftPrev.next = newReversedHead;
        } else {
            head = newReversedHead;
        }

        leftNode.next = rightNext;

        return head;
    }
}
