class Solution {

// Function to merge two sorted linked lists
ListNode mergeTwoSortedLinkedLists(ListNode list1, ListNode list2) {
    // Create a dummy node to serve as the head of the merged list
    ListNode dummyNode = new ListNode(-1);
    ListNode temp = dummyNode;

    // Traverse both lists simultaneously
    while (list1 != null && list2 != null) {
        // Compare elements of both lists and link the smaller node
        if (list1.val <= list2.val) {
            temp.next = list1;
            list1 = list1.next;
        } else {
            temp.next = list2;
            list2 = list2.next;
        }
        // Move the temporary pointer to the next node
        temp = temp.next;
    }

    // If any list still has remaining elements, append them to the merged list
    if (list1 != null) {
        temp.next = list1;
    } else {
        temp.next = list2;
    }

    // Return the merged list starting from the next of the dummy node
    return dummyNode.next;
}

// Function to find the middle of a linked list
ListNode findMiddle(ListNode head) {
    // If the list is empty or has only one node, the middle is the head itself
    if (head == null || head.next == null) {
        return head;
    }

    // Initializing slow and fast pointers
    ListNode slow = head;
    ListNode fast = head.next;

    // Move the fast pointer twice as fast as the slow pointer
    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
    }

    // When the fast pointer reaches the end, the slow pointer will be at the middle
    return slow;
}

// Function to perform merge sort on a linked list
public ListNode sortList(ListNode head) {
    // Base case: if the list is empty or has only one node, it is already sorted
    if (head == null || head.next == null) {
        return head;
    }

    // Find the middle of the list using the findMiddle function
    ListNode middle = findMiddle(head);

    // Divide the list into two halves
    ListNode right = middle.next;
    middle.next = null;
    ListNode left = head;

    // Recursively sort the left and right halves
    left = sortList(left);
    right = sortList(right);

    // Merge the sorted halves using the mergeTwoSortedLinkedLists function
    return mergeTwoSortedLinkedLists(left, right);
}
}
