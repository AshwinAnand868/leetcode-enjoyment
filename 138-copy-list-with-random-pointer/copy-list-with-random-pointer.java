/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {

        if(head == null) {
            return null;
        }

        Node temp = head;

        // inserting nodes in between
        while(temp != null) {
            Node newNode = new Node(temp.val);
            newNode.next = temp.next;
            temp.next = newNode;
            temp = temp.next != null ? temp.next.next : null;
        }

        // filling random nodes of each new node inserted
        temp = head;
        while(temp != null) {
            if(temp.random == null) {
                temp.next.random = null;
            } else {
                temp.next.random = temp.random.next;
            }
            temp = temp.next != null ? temp.next.next : null;
        }

        // separating the new and original lists
        Node curr = head;
        Node newHead = head.next;
        Node newCurr = newHead;

        while(curr != null && newCurr != null) {
            curr.next = curr.next != null ? curr.next.next : null;
            newCurr.next = newCurr.next != null ? newCurr.next.next : null;

            newCurr = newCurr.next;
            curr = curr.next;
        }

        return newHead;

        // Node prev = null;
        // Node newHead = null;
        // Node curr = head;
        // HashMap<Node, Node> map = new HashMap<>();

        // while(curr != null) {
        //     Node newNode = new Node(curr.val);
        //     map.put(curr, newNode); // storing corresponding nodes to fill the random pointer value for the new list
        //     if(newHead == null) { // new list is empty yet
        //         newHead = newNode;
        //         prev = newHead;
        //     } else {
        //         prev.next = newNode;
        //         prev = newNode; // move the prev pointer forward to continue building the list
        //     }

        //     curr = curr.next;
        // } // By now after this while loop ends, we will have populated the next and value of new nodes

        // curr = head; // now the turn to populate random nodes

        // Node newCurr = newHead;

        // while(curr != null) {
        //     newCurr.random = map.get(curr.random);
        //     curr = curr.next;
        //     newCurr = newCurr.next;
        // }

        // return newHead;
    }
}