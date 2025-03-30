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
    int size = 0;

    public Solution(ListNode head) {
        this.head = head;
        this.size = getSize(head);
    }

    private int getSize(ListNode head) {
        ListNode temp = head;
        int count = 0;

        while (temp != null) {
            count++;
            temp = temp.next;
        }

        return count;
    }

    public int getRandom() {
        int randomIndex = (int) (Math.random() * this.size);

        int count = 0;
        ListNode temp = this.head;

        if (temp == null) return -1;

        while (temp != null) {
            if (count == randomIndex) {
                return temp.val;
            }
            count++;
            temp = temp.next;
        }

        return -1; // dummy fallback statement
    }
}


/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */