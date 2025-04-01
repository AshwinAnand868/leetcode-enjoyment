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
        
        // Using two pointers node
        ListNode smallerHead = new ListNode(0), largerHead = new ListNode(0);
        ListNode smaller = smallerHead, larger = largerHead;

        while(head != null) {
            if(head.val < x) {
                smaller.next = head;
                smaller = head; // moves the pointer forward
            } else {
                larger.next = head;
                larger = head;
            }
            head = head.next;
        }

        larger.next = null;
        smaller.next = largerHead.next;

        return smallerHead.next;


        // Using array lists
        // ArrayList<Integer> lessThanX = new ArrayList<>();
        // ArrayList<Integer> notLessThanX = new ArrayList<>();

        // ListNode curr = head;

        // while(curr != null) {
        //     if(curr.val < x) lessThanX.add(curr.val);
        //     else notLessThanX.add(curr.val);
        //     curr = curr.next;
        // }

        // curr = head;

        // for(int elem : lessThanX) {
        //     curr.val = elem;
        //     curr = curr.next;
        // }

        // for(int elem : notLessThanX) {
        //     curr.val = elem;
        //     curr = curr.next;
        // }

        // return head;
    }
}