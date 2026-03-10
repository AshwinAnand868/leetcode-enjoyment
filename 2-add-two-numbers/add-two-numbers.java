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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode resultHeadPrev = new ListNode(-1);
        ListNode result = resultHeadPrev;
        int carry = 0;

        while(l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            result.next = new ListNode(sum % 10);
            carry = sum / 10;

            l1 = l1.next;
            l2 = l2.next;
            result = result.next;
        }

        ListNode remaining = l1 == null ? l2 : l1;
        while(remaining != null) {
            int sum = remaining.val + carry;
            result.next = new ListNode(sum % 10);
            carry = sum / 10;

            remaining = remaining.next;
            result = result.next;
        }

        if(carry > 0) {
            result.next = new ListNode(carry);
        }

        return resultHeadPrev.next;
    }
}