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
    public ListNode partition(ListNode head, int x) {
        ArrayList<Integer> lessThanX = new ArrayList<>();
        ArrayList<Integer> notLessThanX = new ArrayList<>();

        ListNode curr = head;

        while(curr != null) {
            if(curr.val < x) lessThanX.add(curr.val);
            else notLessThanX.add(curr.val);
            curr = curr.next;
        }

        curr = head;

        for(int elem : lessThanX) {
            curr.val = elem;
            curr = curr.next;
        }

        for(int elem : notLessThanX) {
            curr.val = elem;
            curr = curr.next;
        }

        return head;
    }
}