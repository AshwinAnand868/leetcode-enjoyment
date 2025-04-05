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

    public int findGCD(int a, int b) {
        while(b != 0) {
            int temp = b; // store b in a temporary variable
            b = a % b; // update b
            a = temp; // update a
        }

        return a;
    }

    public ListNode insertGreatestCommonDivisors(ListNode head) {

        if(head == null || head.next == null) {
            return head;
        }

        ListNode curr = head;
        ListNode next = head.next;

        while(next != null) {
            ListNode gcdNode = new ListNode(findGCD(curr.val, next.val));
            curr.next = gcdNode;
            gcdNode.next = next;

            curr = next;
            next = next.next;
        }

        return head;
    }
}