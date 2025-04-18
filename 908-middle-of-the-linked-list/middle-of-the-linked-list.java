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
    public ListNode middleNode(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;
        ListNode prevSlow = null;

        while(fast != null) {
            prevSlow = slow;
            slow = slow.next;

            if(fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
            } else {
                fast = fast.next;
            }

        }

        return prevSlow;
    }
}