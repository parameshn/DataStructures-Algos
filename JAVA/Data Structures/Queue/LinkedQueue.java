package Queue;

import java.util.Queue;

public abstract class  LinkedQueue<T> implements  Queue<T> {
    
    private java.util.LinkedList<T> list = new java.util.LinkedList<T>();


    public LinkedQueue() {
    }
    
    public LinkedQueue(T ele) {
        offer(ele);
    }

    public T peek() {
        if (isEmpty())
            throw new RuntimeException("Queue Empty");
        return list.peekFirst();
    }

    public java.util.Iterator<T> iterator() {
        return list.iterator();
    }

    public T poll() {
        if (isEmpty()) throw new RuntimeException("Queue Empty");
       return list.removeLast();
    }

    public boolean offer(T ele) {
        return list.add(ele);
    }

    
}
