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

    ListNode head = null;

    public Solution(ListNode head) {
        this.head = head;
    }
    
    public int getRandom() {
        int count = 1;
        int result = 0;

        ListNode temp = head;

        while(temp != null) {

            if (Math.random() < 1.0 / count) {
                result = temp.val;
            }

            count++;
            temp = temp.next;
        }

        return result;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */