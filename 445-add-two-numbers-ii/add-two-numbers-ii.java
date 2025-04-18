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

    public ListNode reverse(ListNode head) {
        ListNode curr = head, prev = null, next = null;

        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public ListNode addTwoNumbersReverse(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode();

        int sum = 0;
        int carry = 0;

        while(l1 != null || l2 != null) {
            if(l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if(l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            ans.val = sum % 10;
            carry = sum / 10;
            
            ListNode newNode = new ListNode(carry);
            newNode.next = ans;
            ans = newNode;
            sum = carry; // reset sum to left over carry  
        }

        return carry == 0 ? ans.next : ans;
    }

    // public ListNode addTwoNumbersReverse(ListNode l1, ListNode l2) {
    //     ListNode resultHeadPrev = new ListNode(-1);
    //     ListNode result = resultHeadPrev;

    //     int carry = 0;

    //     while(l1 != null && l2 != null) {
    //         int sum = l1.val + l2.val + carry;
    //         result.next = new ListNode(sum % 10);
    //         carry = sum / 10;

    //         l1 = l1.next;
    //         l2 = l2.next;
    //         result = result.next;
    //     }

    //     ListNode rest = l1 == null ? l2 : l1;

    //     while(rest != null) {
    //         int sum = rest.val + carry;
    //         result.next = new ListNode(sum % 10);
            
    //         carry = sum / 10;

    //         rest = rest.next;
    //         result = result.next;
    //     }

    //     if(carry > 0) {
    //         result.next = new ListNode(carry);
    //     }

    //     return resultHeadPrev.next;
    // }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode reverseL1 = reverse(l1);
        ListNode reverseL2 = reverse(l2);

        ListNode result = addTwoNumbersReverse(reverseL1, reverseL2);
        return result;
    }
}