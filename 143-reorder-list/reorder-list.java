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

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        ListNode slow = head, fast = head;
        ListNode slowPrev = null;

        while (fast != null && fast.next != null) {
            slowPrev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        if (slowPrev != null) {
            slowPrev.next = null;
        }

        ListNode prev = null, curr = slow, next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        ListNode secondHalf = prev;

        ListNode dummy = new ListNode(0);
        ListNode currMerge = dummy;
        ListNode l1 = head, l2 = secondHalf;

        while (l1 != null && l2 != null) {
            currMerge.next = l1;
            l1 = l1.next;
            currMerge = currMerge.next;

            currMerge.next = l2;
            l2 = l2.next;
            currMerge = currMerge.next;
        }

        if (l1 != null) {
            currMerge.next = l1;
        }

    }
}