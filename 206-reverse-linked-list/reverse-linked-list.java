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

    public ListNode recurse(ListNode head, ListNode prev) {
        if(head.next == null) {
            return head;
        }

        ListNode newHead = recurse(head.next, head);

        ListNode front = head.next;
        front.next = head;
        head.next = null;

        return newHead;
    }

    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode temp = head;
        ListNode prev = null;

        return recurse(head, prev);

        // while(temp != null) {
        //     ListNode front = temp.next;
        //     temp.next = prev;
        //     prev = temp;
        //     temp = front;
        // }

        // return prev;

        // Stack<Integer> reversed = new Stack<>();
        // ListNode temp = head;

        // while(temp != null) {
        //     reversed.push(temp.val);
        //     temp = temp.next;
        // }

        // temp = head;
        // while(!reversed.isEmpty()) {
        //     int val = reversed.pop();
        //     temp.val = val;
        //     temp = temp.next;
        // }

        // return head;
    }
}