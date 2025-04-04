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
        // if(head.next == null) {
        //     return head;
        // }

        // ListNode last = reverse(head.next);
        // head.next.next = head;
        // head.next = null;
        // return last;
        ListNode next = null, curr = head, prev = null;

        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public ListNode doubleIt(ListNode head) {

        if(head == null) return null;

        ListNode result = null;
        head = reverse(head);
        ListNode newNode = head;

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

        head = reverse(head);

        if(carry > 0) {
            result = new ListNode(carry);
            result.next = head;
        }

        return result == null ? head : result;
    }
}