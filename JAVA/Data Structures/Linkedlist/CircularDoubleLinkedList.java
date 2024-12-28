package Linkedlist;

import java.util.Iterator;

public class CircularDoubleLinkedList<T> implements Iterable<T> {
    Node<T> head;
    Node<T> tail;
    int size = 0;

    private static class Node<T> { // Node has its own type parameter T due to static
        Node<T> next;
        Node<T> prev;
        T data;

        Node(T data, Node<T> next, Node<T> prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }
    /*
     * The `Node` class in your `DoublyLinkedList` implementation **does not have to
     * be static**, but whether it should be static depends on your design and
     * requirements. Here's why you might choose one over the other:
     * 
     * ---
     * 
     * ### **1. When `Node` is Non-Static**
     * A non-static inner class has an implicit association with an instance of the
     * enclosing outer class (`DoublyLinkedList` in this case). This means:
     * 
     * - **Advantages**:
     * - The `Node` class automatically inherits the type parameter `T` from the
     * outer class.
     * - It can directly access the outer class's instance fields and methods
     * without requiring an explicit reference.
     * 
     * - **Disadvantages**:
     * - Every `Node` instance implicitly holds a reference to the enclosing
     * `DoublyLinkedList` instance. This can lead to **memory overhead** if you
     * create many `Node` objects, as each `Node` carries an unnecessary reference
     * to its parent.
     * - The coupling between `Node` and `DoublyLinkedList` increases, making the
     * `Node` class less reusable outside the context of `DoublyLinkedList`.
     * 
     * ---
     * 
     * ### **2. When `Node` is Static**
     * A static nested class (like `Node`) does not have an implicit reference to
     * the enclosing class (`DoublyLinkedList`). It is treated as a top-level class
     * nested inside `DoublyLinkedList`. This means:
     * 
     * - **Advantages**:
     * - A `Node` instance does not carry a reference to the enclosing
     * `DoublyLinkedList` instance, which reduces memory usage.
     * - The `Node` class becomes more self-contained and reusable in other contexts
     * if needed.
     * - It is clearer that `Node` is a utility class specifically for representing
     * the data structure, rather than depending on the outer class's state.
     * 
     * - **Disadvantages**:
     * - The `Node` class cannot directly access the outer class's instance fields
     * or methods.
     * - You must explicitly pass the outer class's type parameter (`T`) to the
     * `Node` class when it is static.
     * 
     * ---
     * 
     * ### Why Use `static` for `Node` in Your Case?
     * 
     * In a `DoublyLinkedList` implementation:
     * - The `Node` class is a simple container for data and links to other nodes.
     * It does not need access to the outer class's instance fields or methods.
     * - Making `Node` static reduces memory overhead because each `Node` instance
     * does not need a reference to the enclosing `DoublyLinkedList` instance.
     * - The `Node` class is not designed to be used independently outside the
     * `DoublyLinkedList` context, but it does not need to be tightly coupled to the
     * outer class.
     * 
     * Thus, making `Node` static is generally the preferred design choice in this
     * scenario.
     * 
     * ---
     * 
     * ### When Not to Make `Node` Static
     * 
     * If your `Node` class needs to:
     * 1. Access the outer class's fields or methods directly.
     * 2. Use the outer class's type parameter implicitly without requiring explicit
     * passing.
     * 
     * Then you would not make it static. However, such use cases are rare for a
     * basic linked list implementation.
     * 
     * ---
     * 
     * ### Conclusion
     * 
     * - Use `static` for `Node` to reduce memory overhead and decouple it from the
     * outer class.
     * - Avoid `static` only if the `Node` class needs to interact directly with the
     * outer class's instance members.
     */

    public void clear() {
        if (head == null)
            return;
        Node<T> cur = head;
        do {
            Node<T> NextNode = cur.next;
            cur.next = null;
            cur.prev = null;
            cur.data = null;
            cur = NextNode;
        } while (cur != head);

        head = null;
        tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addLast(T data) {
        if (head == null) {
            head = new Node<T>(data, null, null);
            head.next = head;
            head.prev = head;
            tail = head;
        } else {
            // Node<T> trav = head;
            // while (trav.next != head) {
            //     trav = trav.next;
            // }
            // Node<T> temp = new Node<T>(data, head, tail);
            // trav.next = temp;
            // temp.prev = trav;
            // temp.next = head;
            // head.prev = temp;
            // tail = temp;
            Node<T> temp = new Node<T>(data, head, tail);
            // temp.prev = tail;
            tail.next = temp;
            head.prev = temp;
            tail = temp;
        }
        size++;
    }

    public void addFirst(T data) {
        if (head == null) {
            head = new Node<T>(data, null, null);
            head.next = head;
            head.prev = head;
            tail = head;
        } else {
            Node<T> temp = new Node<T>(data, head, tail);
            head.prev = temp;
            tail.next = temp;
            head = temp;

        }
        size++;
    }

    public void addAt(T data, int index) throws Exception{
        if (index < 0 || index > size) {
            throw new Exception("out of bounds");
        }
        

        
        if (index == 0) {
            addFirst(data);
            return;
        } else if (index == size) {
            addLast(data);
            return;
        }else {
            Node<T> trav = head;
            int n = 0;
            while (n != index) {
                trav = trav.next;
                n++;
            }
            Node<T> temp = new Node<T>(data, trav.next, trav);
            trav.next.prev = temp;
            trav.next = temp;
            size++;
        }
    }
        

}



