package Queue;

import java.io.EOFException;
import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.Queue;

//abstract
public class ArrayQueue<T> implements Queue<T> {

    public Object[] data;
    public int front;
    public int rear;

    ArrayQueue(int capacity) {
        data = new Object[capacity + 1];
        rear = front = 0;
    }

    // @Override
    // public boolean offer(T data) {
    // if (isFull())
    // return false;
    // // throw new RuntimeException("Queue is full!");

    // this.data[rear++] = data;
    // rear = adjustIndex(rear, this.data.length);
    // return true;
    // }

    // @Override
    // @SuppressWarnings("unchecked")
    // public T poll() {
    // if (isFull())
    // throw new RuntimeException();
    // front = adjustIndex(front, data.length);
    // return (T) data[front++];
    // }

    // @Override
    // @SuppressWarnings("unchecked")
    // public T peek() {
    // if (isEmpty()) {
    // throw new RuntimeException("Empty!");
    // }
    // return (T) data[front];
    // }

    // @Override
    // public boolean add(T ele) {
    // if (isEmpty())
    // throw new IllegalStateException("Empty List!");

    // data[rear++] = ele;
    // rear = adjustIndex(rear, data.length);
    // return true;
    // }

    // @Override
    // @SuppressWarnings("unchecked")
    // public T remove() {
    // if (isEmpty())
    // throw new IllegalStateException("Empty List!");

    // T ele = (T) data[front++];
    // front = adjustIndex(front, data.length);
    // return ele;

    // }

    // @Override
    // @SuppressWarnings("unchecked")
    // public T element() {
    // if (isEmpty()) {
    // throw new RuntimeException("Empty!");
    // }
    // return (T) data[front];
    // }
    @Override
    public boolean offer(T ele) {
        if (isFull())
            return false;

        data[rear++] = ele;
        rear = adjustIndex(rear, data.length);
        return true;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T remove() {
        if (isEmpty())
            throw new NoSuchElementException();

        front = adjustIndex(front, data.length);
        return (T) data[front++];
    }

    @Override
    @SuppressWarnings("unchecked")
    public T poll() {
        if (isEmpty())
            return null;
        
        front = adjustIndex(front, data.length);
        return (T) data[front++];
    }

    @Override
    @SuppressWarnings("unchecked")
    public T element() {
        if (isEmpty())
            throw new NoSuchElementException("Empty!");

        return (T) data[front];
    }

    @Override
    @SuppressWarnings("unchecked")
    public T peek() {
        if (isEmpty())
            return null;

        return (T) data[front];
    }
    //Methods from inherited from Collection

    public boolean add(T ele) {
        if (isFull())
            throw new IllegalStateException("Full");
        data[rear++] = ele;
        rear = adjustIndex(rear, data.length);
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        for (T ele : c) {
            if (isFull())
                throw new IllegalStateException("Queue is full!");
            data[rear++] = ele;
            rear = adjustIndex(rear, data.length);
        }
        return true;
    }

    public void clear() {
        if (isEmpty())
            // throw new RuntimeException("queue is empty!");
            return;

        for (int i = 0; i < data.length; i++) {
            data[i] = null;
        }

        front = rear = 0;
    }

    public boolean contains(Object o) {
        if (isEmpty())
            // throw new RuntimeException("queue is empty!");
            return false;

        for (int i = front; i != rear; i = adjustIndex(+1, data.length)) {
            if (data[i].equals(o)) {
                return true;
            }
        }
        return false;
    }

    // @SuppressWarnings("unchecked")
    // public boolean containsAll(Collection<?> o) {
    //     if(isEmpty())
    //         return false;

    //         int i = 0;
    //         for(Object ele : o){
    //             for(int j = 0;j < data.length;j++){
    //                 if(ele.equals(data[j])){
    //                     i++;
    //                 }
    //             }
    //         }
    //         if(i == o.size())
    //         return true;

    //         return false;
    // }
    public boolean containsAll(Collection<?> o) {
        if (isEmpty()) {
            return false;
        }

        for (Object ele : o) {
            boolean found = false;
            for (int i = front; i != rear; i = adjustIndex(i + 1, data.length)) {
                if (data[i].equals(o)) {
                    found = true;
                    break;
                }
            }
            if (!found)
                return false;
        }
        return true;
    }


    // @Override
    // @SuppressWarnings("unchecked")
    // public java.util.Iterator<T> iterator() {
    //     return new java.util.Iterator<T>(){
    //         public boolean hasNext(){
    //            return front !=  rear;
    //         }
    //         public T next(){
    //             rear = adjustIndex(rear, data.length);
    //             return (T) data[rear++];

    //         }
    //     };
    // }


    public boolean isFull() {
        return (rear + 1) % data.length == front;
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public int size() {
        return adjustIndex(rear + data.length - front, data.length);
    }

    public int adjustIndex(int index, int size) {
        return index >= size ? index - size : index;
    }

}
