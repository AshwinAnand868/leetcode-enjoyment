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
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;

        while(head != null && head.next != null) {
            ListNode firstNode = head;
            ListNode secondNode = head.next;

            // pair swapping
            firstNode.next = secondNode.next;
            secondNode.next = firstNode;
            prev.next = secondNode;

            // moving pointers forward
            prev = firstNode;
            head = firstNode.next;
        }

        return dummy.next;
    }
}