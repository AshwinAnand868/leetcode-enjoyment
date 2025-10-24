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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if(list1 == null && list2 == null) {
            return null;
        }

        if(list1 == null) {
            return list2;
        }

        if(list2 == null) {
            return list1;
        }

        ListNode t1 = list1;
        ListNode t2 = list2;
        ListNode resultPointer = new ListNode();
        ListNode result = resultPointer;

        while(t1 != null && t2 != null) {
            if(t1.val < t2.val) {
                resultPointer.val = t1.val;
                t1 = t1.next;
            } else {
                resultPointer.val = t2.val;
                t2 = t2.next;
            }
            resultPointer.next = new ListNode();
            resultPointer = resultPointer.next;
        
        }

        while(t1 != null) {
            resultPointer.val = t1.val;
            if(t1.next != null) {
                resultPointer.next = new ListNode();
                resultPointer = resultPointer.next;
            }
            t1 = t1.next;
        }

        while(t2 != null) {
            resultPointer.val = t2.val;
            if(t2.next != null) {
                resultPointer.next = new ListNode();
                resultPointer = resultPointer.next;
            }
            t2 = t2.next;
        }

        return result;
    }
}