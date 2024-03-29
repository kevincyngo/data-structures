public class DoublyLinkedList<T> implements Iterable<T> {

    private int size = 0;
    private Node<T> head = null;
    private Node<T> tail = null;

    private class Node<T> {
        T data;
        Node<T> prev, next;

        public Node(T data, Node<T> prev, Node<T> next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }

    // Return the size of this linked list
    public int size() {
        return size;
    }

    // Is this linked list empty?
    public boolean isEmpty() {
        return size() == 0;
    }

    // Add an element to the tail of the linked list, O(1)
    public void add(T elem) {
        addLast(elem);
    }

    // Add a node to the tail of the linked list, O(1)
    public void addLast(T elem) {
        if (isEmpty()) {
            head = tail = new Node<T>(elem, null, null);
        } else {
            tail.next = new Node<T>(elem, tail, null);
            tail = tail.next;
        }
        size++;
    }

    // Add an element to the beginning of this linked list, O(1)
    public void addFirst(T elem) {
        if (isEmpty()) {
            head = tail = new Node<T>(elem, null, null);
        } else {
            head.prev = new Node<T>(elem, null, head);
            head = head.prev;
        }
        size++;
    }

    // Check the value of the first node if it exists, O(1)
    public T peekFirst() {
        if (isEmpty()) throw new RuntimeException("Empty list");
        return head.data;
    }

    // Check the value of the last node if it exists, O(1)
    public T peekLast() {
        if (isEmpty()) throw new RuntimeException("Empty list");
        return tail.data;
    }

    // Remove the first value at the head of the linked list, O(1)
    // Return the data in the removed node
    public T removeFirst() {
        if (isEmpty()) throw new RuntimeException("Empty list");
        T data = head.data;
        head = head.next;
        size--;

        if (isEmpty()) tail = null;
        else head.prev = null;
        return data;
    }

    // Remove the last value at the tail of the linked list, O(1)
    public T removeLast() {
        if (isEmpty()) throw new RuntimeException("Empty list");
        T data = tail.data;
        tail = tail.prev;
        size--;

        if (isEmpty()) head = null;
        else tail.next = null;
        return data;
    }

    // Remove an arbitrary node from the linked list, O(1)
    private T remove(Node<T> node) {

    }

    // Remove a node at a particular index, O(n)
    public T removeAt(int index) {

    }

    // Remove a particular value in the linked list, O(n)
    public boolean remove(Object obj) {

    }

    // Find the index of a particular value in the linked list, O(n)
    public int indexOf(Object obj) {

    }

    // Check is a value is contained within the linked list
    public boolean contains(Object obj) {

    }

    public java.util.Iterator<T> iterator() {
        return new java.util.Iterator<T>() {
            private Node<T> trav = head;

            public boolean hasNext() {
                return trav != null;
            }

            public T next() {
                T data = trav.data;
                trav = trav.next;
                return data;
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

}
