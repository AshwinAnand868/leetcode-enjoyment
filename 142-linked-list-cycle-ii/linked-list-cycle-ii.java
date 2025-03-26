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

       ListNode current = head;

       HashMap<ListNode, Integer> map = new HashMap<>();

       while(current != null) {
            if(map.containsKey(current)) {
                return current;
            }
            map.put(current, 1);
            current = current.next;
       }

       return null;
    }
}