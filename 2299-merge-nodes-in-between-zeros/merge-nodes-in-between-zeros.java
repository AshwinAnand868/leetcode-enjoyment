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
    public ListNode mergeNodes(ListNode head) {

        if(head == null) return head;

        ListNode dummy = new ListNode(0);
        ListNode newNode = dummy;

        ListNode curr = head.next;
        int val = 0;

        while(curr.next != null) {
            val += curr.val;
            if(curr.val == 0) {
                newNode.next = new ListNode(val);
                newNode = newNode.next;
                val = 0;
            }
            curr = curr.next;
        }

        newNode.next = new ListNode(val);

        return dummy.next;
    }
}