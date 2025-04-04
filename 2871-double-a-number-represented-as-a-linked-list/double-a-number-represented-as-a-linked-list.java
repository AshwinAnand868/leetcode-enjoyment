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

    public ListNode reverse(ListNode head) {
        if(head.next == null) {
            return head;
        }

        ListNode last = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    public ListNode doubleIt(ListNode head) {

        if(head == null) return null;

        ListNode result = null;
        ListNode newHead = reverse(head);
        ListNode newNode = newHead;

        int sum = 0;
        int carry = 0;

        while(newNode != null) {
            int val = newNode.val + newNode.val;
            sum = sum + (val % 10);
            carry = val / 10;

            newNode.val = sum;

            newNode = newNode.next;
            sum = carry;
        }

        newHead = reverse(newHead);

        if(carry > 0) {
            result = new ListNode(carry);
            result.next = newHead;
        }

        return result == null ? newHead : result;
    }
}