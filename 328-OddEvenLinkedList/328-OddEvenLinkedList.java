// Last updated: 7/13/2026, 5:25:36 PM
1/**
2 * Definition for singly-linked list.
3 * public class ListNode {
4 *     int val;
5 *     ListNode next;
6 *     ListNode() {}
7 *     ListNode(int val) { this.val = val; }
8 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
9 * }
10 */
11class Solution {
12    public ListNode oddEvenList(ListNode head) {
13
14        if(head == null || head.next == null) return head;
15
16        ListNode tempOdd = head;
17        ListNode even = head.next;
18        ListNode tempEven = even;
19
20        while(tempOdd != null && tempEven != null
21                && tempOdd.next != null && tempEven.next != null) {
22            tempOdd.next = tempOdd.next.next;
23            tempEven.next = tempEven.next.next;
24
25            tempOdd = tempOdd.next;
26            tempEven = tempEven.next;
27        }
28
29        tempOdd.next = even;
30
31        return head;
32    }
33}