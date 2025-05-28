package Linkedlist;

/*Delete Middle Node: Implement an algorithm to delete a node in the middle (i.e., any node but 
the first and last node, not necessarily the exact middle) of a singly linked list, given only access to 
that node. */
class Node <T>  {
    T data;
    Node<T> next;

    Node(T data) {
        this.data = data;
    }
}

public class Q3 {
    public static void main(String[] args) {
        Node<Integer> node1 = new Node<>(1);
        Node<Integer> node2 = new Node<>(2);
        Node<Integer> node3 = new Node<>(3);
        node1.next = node2;
        node2.next = node3;
       

        middleDelete(node2);
    }
    
    public static <T> void middleDelete(Node<T> node) {
        node.data = node.next.data;
        node.next = node.next.next;

    }
    
    public void b() {
        Node<Integer> node1 = new Node<>(1);
        Node<Integer> node2 = new Node<>(2);
        Node<Integer> node3 = new Node<>(3);
        node1.next = node2;
        node2.next = node3;
    }
    
}
