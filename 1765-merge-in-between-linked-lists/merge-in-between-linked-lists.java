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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        int a1Index = a + 1;
        int b1Index = b + 1;
        int difference = b - a + 1;


        ListNode aNode = list1;

        while(a-- > 1) {
            aNode = aNode.next;
        }

        ListNode bNextNode = aNode;

        while(difference-- > -1) {
            bNextNode = bNextNode.next;
        }

        aNode.next = list2; 

        ListNode listEnd = list2;

        while(listEnd.next != null) {
            listEnd = listEnd.next;
        }

        listEnd.next = bNextNode;

        return list1;
    }
}