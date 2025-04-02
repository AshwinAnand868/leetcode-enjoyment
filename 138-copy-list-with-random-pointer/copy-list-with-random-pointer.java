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
        Node prev = null;
        Node newHead = null;
        Node curr = head;
        HashMap<Node, Node> map = new HashMap<>();

        while(curr != null) {
            Node newNode = new Node(curr.val);
            map.put(curr, newNode); // storing corresponding nodes to fill the random pointer value for the new list
            if(newHead == null) { // new list is empty yet
                newHead = newNode;
                prev = newHead;
            } else {
                prev.next = newNode;
                prev = newNode; // move the prev pointer forward to continue building the list
            }

            curr = curr.next;
        } // By now after this while loop ends, we will have populated the next and value of new nodes

        curr = head; // now the turn to populate random nodes

        Node newCurr = newHead;

        while(curr != null) {
            newCurr.random = map.get(curr.random);
            curr = curr.next;
            newCurr = newCurr.next;
        }

        return newHead;
    }
}