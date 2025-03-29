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
    public ListNode sortList(ListNode head) {
        // edge cases first
        if(head == null || head.next == null) {
            return head;
        }

        ArrayList<Integer> tempList = new ArrayList<>();
        ListNode temp = head;

        while(temp != null) {
            tempList.add(temp.val);
            temp = temp.next;
        }

        Collections.sort(tempList);

        temp = head;
        int i = 0;
        while(temp != null) {
            temp.val = tempList.get(i);
            temp = temp.next;
            i++;
        }

        return head;
    }
}