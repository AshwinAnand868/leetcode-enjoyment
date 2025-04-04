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
        HashMap<ListNode, Integer> criticalPointsMap = new HashMap<>();

        ListNode prev = head;
        ListNode curr = head.next;
        int position = 1;
        ArrayList<Integer> positions = new ArrayList<>();

        while(curr != null && curr.next != null) {
            position++;
            if(curr.val < prev.val && curr.val < curr.next.val) {
                // criticalPointsMap.put(curr, position);
                positions.add(position);
            } else if(curr.val > prev.val && curr.val > curr.next.val) {
                // criticalPointsMap.put(curr, position);
                positions.add(position);
            }

            prev = curr;
            curr = curr.next;
        }

        if(positions.size() < 2) {
            return result;
        }
 
        Collections.sort(positions);
        int diff = Integer.MAX_VALUE;
        for(int i = 0; i < positions.size() - 1; ++i) {
            int e1 = positions.get(i);
            int e2 = positions.get(i + 1);
            diff = Math.min(e2 - e1, diff);
        }

        result[0] = diff;
        result[1] = positions.get(positions.size() - 1) - positions.get(0);
        return result;
    }
}