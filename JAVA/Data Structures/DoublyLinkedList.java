

public class DoublyLinkedList<T> implements Iterable<T> {

    private int size = 0;
    private Node<T> head = null;
    private Node<T> tail = null;

    //Internal node to class to rep data
    private static class Node<T> {
        private T data;
        private Node<T> prev, next;

        public Node(T data, Node<T> prev, Node<T> next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }

        @Override
        public String toString() {
            return data.toString();
        }

    }

    // Empty the linked list
    public void clear() {
        Node<T> trav = head;
        while (trav != null) {
            Node<T> next = trav.next;
            trav.next = null;
            trav.prev = null;
            trav.data = null;
            trav = next;
        }
        head = tail = trav = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addLast(T elem) {
        if (isEmpty()) {
            head = tail = new Node<T>(elem, null, null);
        } else {
            tail.next = new Node<T>(elem, tail, null);
            tail = tail.next;

        }

        size++;
    }

    public void addFirst(T elem) {
        if (isEmpty()) {
            head = tail = new Node<T>(elem, null, null);
        } else {
            head.prev = new Node<T>(elem, head.prev, head.next);
            head = head.prev;
            // tail.next = head;
        }
        size++;
    }

    // Add an element at a specified index
    public void addAt(int index, T elem) throws Exception {
        if (index < 0 || index > size) {
            throw new Exception("Illegeal Index");
        }
        if (index == 0) {
            addFirst(elem);
            return;
        }
        if (index == size) {
            addLast(elem);
            return;
        }
        Node<T> temp = head;
        int num = 0;
        while (num < index) {
            temp = temp.next;
            num++;
        }

        Node<T> newNode = new Node<T>(elem, temp, temp.next);
        temp.prev.next = newNode;
        temp.prev = newNode;
        size++;
    }

    // public String peekFirst() {
    //     if (isEmpty())
    //         throw new RuntimeException("Empty List");
    //     else
    //         return head.toString(); //throws null
    // }

    public T peekFirst() {
        if (isEmpty())
            throw new RuntimeException("Empty List");
        else
            return head.data;
    }

    public T peekLast() {
        if (isEmpty()) {
            throw new RuntimeException("Empty List");
        } else {
            return tail.data;
        }
    }

    public T removeFirst() {
        if (isEmpty()) {
            throw new RuntimeException("Empty List");
        }
        Node<T> newNode = head;
        head = newNode.next;
        --size;

        if (isEmpty())
            tail = null;
        else
            head.prev = null;

        return head.data;
    }

    public T removeLast() {
        if (isEmpty())
            throw new RuntimeException("EmptyLsit");

        T data = tail.data;
        tail.data = null;
        // tail.next = null;
        tail.prev = null;
        --size;
        if (isEmpty())
            head = null;
        else
            tail.next = null;

        return data;

    }

    public T remove(Node<T> node) {
        if (node.prev == null)
            return removeFirst();
        if (node.next == null)
            return removeLast();

        node.next.prev = node.prev;
        node.prev.next = node.next;

        T data = node.data;

        node.data = null;
        node = node.next = node.prev = null;

        --size;

        return data;
    }

    // public T removeAt(int index) {

    //     if (index < 0 || index >= size) {
    //         throw new IllegalArgumentException();
    //     }
    //     int n = 0;
    //     Node<T> temp = head;
    //     while(n < index)
    //     {
    //         n++;
    //         temp = temp.next;
    //     }
    //     temp.next.prev = temp.prev;
    //     temp.prev.next = temp.next;
    //     temp.prev = temp.next = null;
    //     T data = temp.data;
    //     return data;
    // }

    public T removeAt(int index)
    {

        if (index < 0 || index >= size) {
            throw new IllegalArgumentException();
        }
        int i;
        Node<T> trav;

        if (index < size / 2) {
            for (i = 0, trav = head; i != index; i++) {
                trav = trav.next;
            }
        } else {
            for (i = size - 1, trav = tail; i != index; i--) {
                trav = trav.prev;
            }
        }
        return remove(trav);
    }
    
    // Search for non null object
    public boolean remove(Object obj) {
        Node<T> trav = head;

        if (obj == null) {
            for (trav = head; trav != null; trav = trav.next) {
                if (trav.data == null) {
                    remove(trav);
                    return true;
                }
            }
        } else {
            for (trav = head; trav != null; trav = trav.next) {
                if (obj.equals(trav.data)) {
                    remove(trav);
                    return true;
                }
            }
        }
        return false;
    }
    
    public int indexOf(Object obj) {
        Node<T> temp = head;
        int index = 0;

        if (obj == null) {
            for (; temp != null; temp = temp.next, index++) {
                if (temp.data == null) {
                    return index;
                }
            }
        } else {
            for (; temp != null; temp = temp.next, index++) {
                //if (obj.equals(temp.data)) 
                if (temp.data.equals(obj)) {
                    return index;
                }
            }
        } //if(temp.data.equals(obj)){}
        return -1;
    }
    
    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override
    public java.util.Iterator<T> iterator() {
        return new java.util.Iterator<T>() {
            private Node<T> trav = head;

            @Override
            public boolean hasNext() {
                return trav != null;
            }

            @Override
            public T next() {
                T data = trav.data;
                trav = trav.next;
                return data;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[]");
        Node<T> trav = head;
        while (trav != null) {
            sb.append(trav.data);
            if (trav.next != null) {
                sb.append(",");
            }
            trav = trav.next;
        }
        sb.append("]");
        return sb.toString();
    }

    public void reverse() {
        if (isEmpty())
            throw new RuntimeException("List empty");

        Node<T> cur = head;
        Node<T> temp = null;

        while (cur != null)
        {
            temp = cur.prev;
            cur.prev = cur.next;
            cur.next = temp;
            cur = cur.prev;
        }

        while (temp != null) {
            head = temp.prev;
            tail = temp;
        }
    }


}