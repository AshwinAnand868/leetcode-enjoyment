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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        if(head == null) return null;

        int[] result = {-1, -1};

        ListNode prev = head;
        ListNode curr = head.next;
        int position = 1;
        // ArrayList<Integer> positions = new ArrayList<>();
        int first = -1;
        int last = -1;
        int prevCrit = 0; // 1 based indexing
        int minDistance = Integer.MAX_VALUE;

        while(curr != null && curr.next != null) {
            position++;
            if((curr.val < prev.val && curr.val < curr.next.val) || (curr.val > prev.val && curr.val > curr.next.val)) {
                if(first == -1) {
                    first = position;
                } else {
                    minDistance = Math.min(minDistance, position - prevCrit);
                    last = position;
                }
                prevCrit = position;
            }

            prev = curr;
            curr = curr.next;
        }

        if (first != -1 && last != -1) {
            result[0] = minDistance;
            result[1] = last - first;
        }

        return result;

        // if(positions.size() < 2) {
        //     return result;
        // }
 
        // int diff = Integer.MAX_VALUE;
        // for(int i = 0; i < positions.size() - 1; ++i) {
        //     int e1 = positions.get(i);
        //     int e2 = positions.get(i + 1);
        //     diff = Math.min(e2 - e1, diff);
        // }

        // result[0] = diff;
        // result[1] = positions.get(positions.size() - 1) - positions.get(0);
        // return result;
    }
}