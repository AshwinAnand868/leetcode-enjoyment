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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;

        ListNode tail = head;
        int length = 1;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }

        tail.next = head;

        k = k % length;
        int stepsToNewHead = length - k;

        ListNode newTail = head;
        for (int i = 0; i < stepsToNewHead - 1; i++) {
            newTail = newTail.next;
        }

        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }
}




// The below solution is for doubly linked list
// class Solution {
//     public Node rotateRight(Node head, int k) {
//         if (head == null || k == 0) return head;

//         // Step 1: Find the length and tail
//         Node tail = head;
//         int length = 1;

//         while (tail.next != null) {
//             tail = tail.next;
//             length++;
//         }

//         // Step 2: Make it circular
//         tail.next = head;
//         head.prev = tail;

//         // Step 3: Compute the new head position
//         k = k % length;
//         int stepsToNewHead = length - k;

//         Node newTail = head;
//         for (int i = 1; i < stepsToNewHead; i++) {
//             newTail = newTail.next;
//         }

//         Node newHead = newTail.next;

//         // Step 4: Break the circle
//         newTail.next = null;
//         newHead.prev = null;

//         return newHead;
//     }
// }
