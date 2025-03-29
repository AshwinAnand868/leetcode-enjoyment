class Solution {

    public ListNode mergeTwoSortedLists(ListNode list1, ListNode list2) {
        ListNode dummyNode = new ListNode(-1);
        ListNode temp = dummyNode;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                temp.next = list1;
                list1 = list1.next;
            } else {
                temp.next = list2;
                list2 = list2.next;
            }
            temp = temp.next;
        }

        temp.next = (list1 != null) ? list1 : list2;

        return dummyNode.next;
    }

    public ListNode findMiddle(ListNode head) {
        ListNode slow = head, fast = head, prev = null;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        if (prev != null) prev.next = null; // Properly split the list

        return slow;
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode middle = findMiddle(head);
        ListNode right = middle;
        ListNode left = head;

        left = sortList(left);
        right = sortList(right);

        return mergeTwoSortedLists(left, right);
    }
}
