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
        ListNode next = null, curr = head, prev = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public ListNode removeNodes(ListNode head) {
        ListNode newHead = reverse(head);

        ListNode newNode = newHead;
        ListNode temp = newHead.next;
        newNode.next = null;

        while (temp != null) {
            ListNode nextNode = temp.next;

            if (temp.val >= newNode.val) {
                temp.next = newNode;
                newNode = temp;
            }

            temp = nextNode;
        }

        return newNode;
    }
}