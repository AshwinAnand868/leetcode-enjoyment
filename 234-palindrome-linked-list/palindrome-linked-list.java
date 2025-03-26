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

    public ListNode reverseLinkedList(ListNode head) {
        
        if(head == null || head.next == null) {
            return head;
        }

        ListNode newHead = reverseLinkedList(head.next);
        ListNode front = head.next;
        front.next = head;
        head.next = null;
        
        return newHead;
    }

    public boolean isPalindrome(ListNode head) {

        // an empty list or a list with one element is palindrome
        if(head == null || head.next == null) {
            return true;
        }

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode newHead = reverseLinkedList(slow);

        ListNode first = head;
        ListNode second = newHead;

        while(second != null) {
            if(first.val != second.val) {
                reverseLinkedList(newHead);
                return false;
            }

            first = first.next;
            second = second.next;
        }

        reverseLinkedList(newHead);

        return true;


        // Stack<Integer> stack = new Stack<>();

        // ListNode temp = head;

        // while(temp != null) {
        //     stack.push(temp.val);
        //     temp = temp.next;
        // }

        // temp = head;

        // while(temp != null) {
        //     if(temp.val != stack.pop()) {
        //         return false;
        //     }
        //     temp = temp.next;
        // }

        // return true;
    }
}