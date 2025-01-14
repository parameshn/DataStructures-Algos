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

    // public boolean removeAll(Collection<?> c) {
    //     if(isEmpty())
    //         return false;

    //     for (int i = 0; i != rear; i = adjustIndex(i + 1, data.length)) {
    //         data[i] = null;
    //     }
    //     front = 0;
    //     rear = -1;
    //     return true;
    // }
    @Override
    public boolean removeAll(Collection<?> c) {
        boolean modified = false;
        for (int i = front; i != rear;) {
            if (c.contains(data[i])) {
                // Shift elements to the left to remove the current element
                for (int j = i; j != rear; j = adjustIndex(j + 1, data.length)) {
                    data[j] = data[adjustIndex(j + 1, data.length)];
                }
                rear = adjustIndex(rear - 1, data.length);
                data[rear] = null; // Clear the last element
                modified = true;
            } else {
                i = adjustIndex(i + 1, data.length);
            }
        }
        return modified;
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

    @Override
    @SuppressWarnings("unchecked")
    public java.util.Iterator<T> iterator() {
        return new java.util.Iterator<T>() {
            private int current = front;

            public boolean hasNext() {
                return current == rear;
            }

            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T element = (T) data[current];
                current = adjustIndex(current + 1, data.length);
                return element;
            }
        };
    }

    public Object[] toArray() {
        Object[] result = new Object[size()];
        int index = 0;
        for (int i = front; i != rear; i = adjustIndex(i + 1, data.length)) {
            result[index++] = data[i];
        }
        return result;
    }

    // @Override
    // @SuppressWarnings("unchecked")
    // public <T> T[] toArray(T[] a) {
    //     int size = size();
    //     if (a.length < size) {
    //         a = (T[]) java.lang.reflect.Array.newInstance(a.getClass().getComponentType(), size);
    //     }
    //     int index = 0;
    //     for (int i = front; i != rear; i = adjustIndex(i + 1, data.length)) {
    //         a[index++] = (T) data[i];
    //     }
    //     if (a.length > size) {
    //         a[size] = null;
    //     }
    //     return a;
    // }
    @Override
    @SuppressWarnings("unchecked")
    public <U> U[] toArray(U[] a) {
        int size = size();
        if (a.length < size) {
            a = (U[]) java.lang.reflect.Array.newInstance(a.getClass().getComponentType(), size);
        }
        int index = 0;
        for (int i = front; i != rear; i = adjustIndex(i + 1, data.length)) {
            a[index++] = (U) data[i];
        }
        if (a.length > size) {
            a[size] = null;
        }
        return a;
    }

    // public boolean remove(Object o) {
    //     if (isEmpty()) {
    //         return false;
    //     }

    //     for (int i = front; i != rear; i = adjustIndex(i + 1, data.length)) {
    //         if (data[i].equals(o)) {
    //             for (int j = i; j != rear; j = adjustIndex(j + 1, data.length)) {
    //                 data[j] = data[adjustIndex(j + 1, data.length)];
    //             }
    //             rear = adjustIndex(rear - 1, data.length);
    //             data[rear] = null;
    //             return true;
    //         }
    //     }
    //     return false;
    // }
    public boolean remove(Object o) {
        if (isEmpty())
            return false;

        for (int i = front; i != rear; i = adjustIndex(i + 1, data.length)) {
            if (data[i].equals(o)) {
                for (int j = front; i != rear; j = adjustIndex(j + 1, data.length)) {
                    data[j] = data[j + 1];
                }
                rear = adjustIndex(rear - 1, data.length);
                data[rear] = null;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        boolean modified = false;
        for (int i = front; i != rear;) {
            if (!c.contains(data[i])) {
                for (int j = i; j != rear; j = adjustIndex(j + 1, data.length)) {
                    data[j] = data[adjustIndex(j + 1, data.length)];
                }
                rear = adjustIndex(rear - 1, data.length);
                data[rear] = null; // Clear the last element
                modified = true;
            } else {
                i = adjustIndex(i + 1, data.length);
            }
        }
        return modified;
    }

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
