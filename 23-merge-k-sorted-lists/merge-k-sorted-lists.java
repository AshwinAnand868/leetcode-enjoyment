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

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;

        if(l1.val <= l2.val) {
            // fix l1
            l1.next = mergeTwoLists(l2, l1.next);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    public ListNode partitionAndMerge(ListNode[] lists, int start, int end) {
        if(start > end) {
            return null;
        }

        if(start == end) {
            return lists[start];
        }

        int mid = start + (end - start) / 2;

        ListNode l1 = partitionAndMerge(lists, start, mid);
        ListNode l2 = partitionAndMerge(lists, mid + 1, end);

        return mergeTwoLists(l1, l2);
    }

    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        if(n == 0) return null;
        if(n == 1) return lists[0];

        return partitionAndMerge(lists, 0, n - 1);
    }

    // public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    //     ListNode dummy = new ListNode();
    //     ListNode pointer = dummy;

    //     while(list1 != null && list2 != null) {
    //         if(list1.val < list2.val) {
    //             pointer.next = list1;
    //             list1 = list1.next;
    //         } else {
    //             pointer.next = list2;
    //             list2 = list2.next;
    //         }

    //         pointer = pointer.next;
    //     }

    //     if(list1 == null) {
    //         pointer.next = list2;
    //     } else {
    //         pointer.next = list1;
    //     }

    //     return dummy.next;
    // }

    // public ListNode mergeKLists(ListNode[] lists) {
    //     if(lists.length == 0) return null;
    //     if(lists.length == 1) return lists[0];

    //     ListNode pointer = lists[0];
    //     ListNode result = pointer;

    //     for(int i = 1; i < lists.length; ++i) {
    //         pointer = mergeTwoLists(pointer, lists[i]);
    //     }

    //     return pointer;
    // }
}