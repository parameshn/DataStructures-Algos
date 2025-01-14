package Queue;

import java.util.Queue;

public abstract class IntQueue implements Queue<Integer> {

    private int[] data;
    private int front, end;
    private int size;

    public IntQueue(int maxSize) {
        end = size = front = 0;
        data = new int[maxSize];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public Integer peek() {
        if (isEmpty())
            throw new RuntimeException("Queue is empty");
        front = front % data.length;
        return data[front];
    }

    @Override
    public boolean offer(Integer value) {
        if (isFull()) {
            throw new RuntimeException("queue too small");
        }
        data[end++] = value;
        size++;
        end = end % data.length;
        return true;
    }

    public boolean isFull() {
        return size == data.length;
    }

    public Integer poll() {
        if (isEmpty())
            throw new RuntimeException("queue is empty");

        front = front % data.length;
        size--;
        return data[front++];
    }

    // public static void main(String[] args) {
    //     IntQueue q = new IntQueue(5);

    //     q.offer(5);
    //     q.offer(2);
    //     q.offer(8);
    //     q.offer(9);
    //     q.offer(7);

    //     System.out.println(q.poll());
    //     System.out.println(q.poll());
    //     System.out.println(q.poll());

    //     System.out.println(q.isEmpty());

    // }

}


