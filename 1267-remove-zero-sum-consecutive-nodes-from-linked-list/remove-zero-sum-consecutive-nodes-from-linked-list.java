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
    public ListNode removeZeroSumSublists(ListNode head) {
        int prefixSum = 0;
        Map<Integer, ListNode> hashMap = new HashMap<>();

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        hashMap.put(prefixSum, dummy);

        while(head != null) {
            prefixSum += head.val;

            if(hashMap.containsKey(prefixSum)) {
                ListNode start = hashMap.get(prefixSum);
                ListNode startNext = start.next;
                int pSum = prefixSum;

                while(startNext != head) {
                    pSum += startNext.val;
                    hashMap.remove(pSum);
                    startNext = startNext.next;
                }

                start.next = startNext.next;

            } else {
                hashMap.put(prefixSum, head);
            }

            head = head.next;
        }

        return dummy.next;
    }
}