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

    public int findListLength(ListNode head) {

        int count = 0;
        
        while(head != null) {
            count++;
            head = head.next;
        }

        return count;
    }

    public ListNode swapNodes(ListNode head, int k) {
        int node1Pos = k;

        ListNode node1 = head;
        while(node1Pos > 1) {
            node1 = node1.next;
            node1Pos--;
        }

        ListNode node2 = head;
        int length = findListLength(head);
        int node2Pos = length - k + 1;

        while(node2Pos > 1) {
            node2 = node2.next;
            node2Pos--;
        }

        int temp = node1.val;
        node1.val = node2.val;
        node2.val = temp;

        return head;
    }
}