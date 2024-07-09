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
        // whenever we are given an output list to return, the common approach is to go with a dummy node
        ListNode dummy = new ListNode();
        ListNode ptr = dummy;
        
        while (list1 != null && list2 != null) {
            if(list1.val < list2.val) {
                ptr.next = list1;
                list1 = list1.next;
            } else {
                ptr.next = list2;
                list2 = list2.next;
            }
            ptr = ptr.next;
        }
        
        if(list1 == null) {
            ptr.next = list2;
        } else {
            ptr.next = list1;
        }
        
        return dummy.next;
    }
}