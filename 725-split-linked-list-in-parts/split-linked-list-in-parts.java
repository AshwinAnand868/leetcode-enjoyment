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
    public ListNode[] splitListToParts(ListNode head, int k) {

        ListNode[] nodes = new ListNode[k];

        int count = 0;

        ListNode temp = head;

        while (temp != null) {
            count++;
            temp = temp.next;
        }

        int basePartSize = count / k;
        int extraNodes = count % k;

        temp = head;

        for (int i = 0; i < k; ++i) {
            nodes[i] = temp;
            int partSize = basePartSize + (extraNodes > 0 ? 1 : 0);
            extraNodes--;

            for (int j = 0; j < partSize - 1 && temp != null; j++) {
                temp = temp.next;
            }

            if(temp != null) {
                ListNode next = temp.next;
                temp.next = null;
                temp = next;
            }

        }

        return nodes;
    }
}