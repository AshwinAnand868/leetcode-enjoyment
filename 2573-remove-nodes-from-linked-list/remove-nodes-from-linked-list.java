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
    public ListNode removeNodes(ListNode head) {
        // Whenever you are asked to do a traversal from right to left,
        // you can either use recursion, reverse the list or stack

        // Approach I - Using stack
        Stack<ListNode> stack = new Stack<>();

        ListNode temp = head;

        while(temp != null) {
            stack.push(temp);
            temp = temp.next;
        }

        int max = Integer.MIN_VALUE;
        ListNode newNode = null;

        while(!stack.isEmpty()) {
            ListNode top = stack.pop();

            if(newNode == null) {
                newNode = top;
                max = top.val;
            } else if(newNode.val <= top.val) {
                ListNode dummy = newNode;
                newNode = top;
                newNode.next = dummy;
            }
        }

        return newNode;
    }
}