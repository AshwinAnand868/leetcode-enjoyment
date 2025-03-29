/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode d1 = headA;
        ListNode d2 = headB;

        while(d1 != d2) {
            d1 = d1 == null ? headB : d1.next;
            d2 = d2 == null ? headA : d2.next;
        }

        return d1;

        // ListNode tempHeadA = headA;
        // ListNode tempHeadB = headB;
        // HashMap<ListNode, Integer> map = new HashMap<>();

        // while(tempHeadA != null) {
        //     map.put(tempHeadA, 1);
        //     tempHeadA = tempHeadA.next;
        // }

        // while(tempHeadB != null) {

        //     if(map.containsKey(tempHeadB)) {
        //         return tempHeadB;
        //     }
        //     tempHeadB = tempHeadB.next;
        // }

        // return null;
    }
}