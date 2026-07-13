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
    public ListNode oddEvenList(ListNode head) {

        if(head == null || head.next == null) return head;

        ListNode tempOdd = head;
        ListNode even = head.next;
        ListNode tempEven = even;

        while(tempOdd != null && tempEven != null
                && tempOdd.next != null && tempEven.next != null) {
            tempOdd.next = tempOdd.next.next;
            tempEven.next = tempEven.next.next;

            tempOdd = tempOdd.next;
            tempEven = tempEven.next;
        }

        tempOdd.next = even;

        return head;
    }
}