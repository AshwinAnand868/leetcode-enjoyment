class Node {
    int key;
    int value;

    Node prev;
    Node next;

    Node(int key, int value) {
        this.key = key;
        this.value = value;
        prev = null;
        next = null;
    }
}

class LRUCache {

    int capacity;
    Node head;
    Node tail;

    Map<Integer, Node> map = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;

        head = new Node(-1, -1);
        tail = new Node(-1, -1);

        head.next = tail;
        tail.prev = head;
    }

    private void addNode(Node toAdd) {
        Node temp = head.next;

        head.next = toAdd;

        toAdd.next = temp;
        toAdd.prev = head;

        temp.prev = toAdd;
    }

    private void deleteNode(Node toDel) {
        Node prev = toDel.prev;
        Node next = toDel.next;

        prev.next = next;
        next.prev = prev;
    }

    public int get(int key) {

        if (!map.containsKey(key)) {
            return -1;
        }

        Node node = map.get(key);
        deleteNode(node);
        addNode(node);

        return node.value;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)) {
            Node node = map.get(key);

            node.value = value;

            deleteNode(node);

            addNode(node);

            return;
        }

        if(map.size() == capacity) {
            // delete tail node
            Node toDelNode = tail.prev;

            deleteNode(toDelNode);

            // delete from map as well
            map.remove(toDelNode.key);
        }

        Node newNode = new Node(key, value);

        addNode(newNode);

        map.put(key, newNode);
    }
}