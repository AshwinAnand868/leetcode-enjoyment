/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {

        if(head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if(fast == slow) {
                slow = head;

                while(slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }

                return slow;
            }
        }

        return null;

    //    ListNode current = head;

    //    HashMap<ListNode, Integer> map = new HashMap<>();

    //    while(current != null) {
    //         if(map.containsKey(current)) {
    //             return current;
    //         }
    //         map.put(current, 1);
    //         current = current.next;
    //    }

    //    return null;
    }
}