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
        ListNode dummy = new ListNode();
        ListNode pointer = dummy;

        while(list1 != null && list2 != null) {
            if(list1.val < list2.val) {
                pointer.next = list1;
                list1 = list1.next;
            } else {
                pointer.next = list2;
                list2 = list2.next;
            }

            pointer = pointer.next;
        }

        if(list1 == null) {
            pointer.next = list2;
        } else {
            pointer.next = list1;
        }

        return dummy.next;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        if(lists.length == 1) return lists[0];

        ListNode pointer = lists[0];
        ListNode result = pointer;

        for(int i = 1; i < lists.length; ++i) {
            pointer = mergeTwoLists(pointer, lists[i]);
        }

        return pointer;
    }
}