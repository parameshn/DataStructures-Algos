package Queue;

import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Stream;

public class qimpl {
    public static void main(String[] args) {
        System.out.println("====Array Queue====");
       // arrayDequeDemo();
        System.out.println("====Linked List Queue====");
        linkedListQueueDemo();
        System.out.println("====Priority Queue====");
        priorityQueueDemo();
        System.out.println("====BlockingQueue ====");
        blockingQueueDemo();
        System.out.println("====ConcurrentLinked Queue====");
        concurrentLinkedQueueDemo();
        System.out.println("====DelayQueue====");
        delayQueueDemo();
    }

    public static void arrayDequeDemo() {

        Deque<String> arrayDeque = new ArrayDeque<>();
       
        System.out.println(arrayDeque.add("apple"));
        System.out.println(arrayDeque.offer("banana"));
        arrayDeque.addFirst("orange");
        arrayDeque.addLast("grapes");
        arrayDeque.offerFirst("kiwi");
        arrayDeque.offerLast("mango");
        arrayDeque.add("apple");
        Deque<String> arrayDeque1 = new ArrayDeque<>(arrayDeque);


        System.out.println("ArrayDeque:" + arrayDeque);
        System.out.println("ArrayDequeue 1"+arrayDeque1);
        
        System.out.println("First element:" + arrayDeque.getFirst());
        System.out.println("Last element:" + arrayDeque.getLast());
        System.out.println("Peek first:" + arrayDeque.peekFirst());
        System.out.println("Peek last:" + arrayDeque.peekLast());
        System.out.println("Remove:" + arrayDeque.remove());
        System.out.println("ArrayDeque:" + arrayDeque);
        System.out.println("Poll:" + arrayDeque.poll());
        System.out.println("ArrayDeque:" + arrayDeque);

        System.out.println("element:" + arrayDeque.element());
        System.out.println("ArrayDeque:" + arrayDeque);

        System.out.println("pollFirst:" + arrayDeque.pollFirst());
        System.out.println("ArrayDeque:" + arrayDeque);
        
        System.out.println("pollLast:" + arrayDeque.pollLast());
        System.out.println("ArrayDeque:" + arrayDeque);

        System.out.println("removeFirst:" + arrayDeque.removeFirst());
        System.out.println("ArrayDeque:" + arrayDeque);

        System.out.println("removeLast:" + arrayDeque.removeLast());
        System.out.println("ArrayDeque:" + arrayDeque);

        System.out.println("removeFirstOccurrence:" + arrayDeque.removeFirstOccurrence("grapes"));
        System.out.println("Array Deqeue"+arrayDeque);
        System.out.println("Array Deqeue 1" +arrayDeque1);
        arrayDeque = arrayDeque1;
        System.out.println("Array Deqeue" + arrayDeque);
       
        System.out.println("removeLastOccurrence:" + arrayDeque.removeLastOccurrence("apple"));
        System.out.println("Array Deqeue 1" + arrayDeque1);
        System.out.println("Array Deqeue" + arrayDeque);

        arrayDeque = new ArrayDeque<>(arrayDeque1);

        System.out.println("Array Deqeue " + arrayDeque.peekFirst());

        System.out.println("Array Deqeue " + arrayDeque.peekLast());
        
        arrayDeque.clear();
        System.out.println("Array Deqeue " + arrayDeque);
        System.out.println("Array Deqeue " + arrayDeque.isEmpty());
        System.out.println("Array Deqeue " + arrayDeque.size());
        System.out.println("Array Deqeue " + arrayDeque.contains("apple"));
        System.out.println("Array Deqeue1 " + arrayDeque1);
        arrayDeque1.push("ramp");
        System.out.println(arrayDeque1);
        arrayDeque1.pop();
        System.out.println(arrayDeque1);


        System.out.println("===Iterator===");
        Iterator<String> iterator = arrayDeque1.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("===Descending Iterator===");
        Iterator<String> iterator1 = arrayDeque1.descendingIterator();

        while (iterator1.hasNext()) {
            System.out.println(iterator1.next());
        }


        arrayDeque1.clear();
        System.out.println("Array Deqeue 1" + arrayDeque1);
        System.out.println("Array Deqeue 1" + arrayDeque1.isEmpty());
        System.out.println("Array Deqeue " + arrayDeque);

    }

    public static void linkedListQueueDemo() {

        LinkedList<String> linked = new LinkedList<>();

        linked.add("appple");
        linked.offer("banana");
        linked.addFirst("grapes");
        linked.addLast("pomegranate");
        linked.offerFirst("gauva");
        linked.offerLast("dragonfruit");
      //  LinkedList<String> linked1 = (LinkedList<String>) linked.clone();
        /*
         * Since clone() returns Object, Java doesn't automatically cast it to
         * LinkedList<String>, so explicit casting is necessary.
         * 
         */
        LinkedList<String> linked1 = new LinkedList<>(linked);
        System.out.println("linkedList" + linked);
        System.out.println("Poll:" + linked.poll());
        System.out.println("Poll first:" + linked.pollFirst());
        System.out.println("Poll last:" + linked.pollFirst());

        System.out.println("Peek:" + linked.peek());
        System.out.println("Peek First:" + linked.peekFirst());
        System.out.println("Peek Last:" + linked.peekLast());

        System.out.println("linkedList" + linked);
        System.out.println("get:" + linked.get(1));
        System.out.println("get First:" + linked.getFirst());
        System.out.println("get Last:" + linked.getLast());

        System.out.println("linkedList" + linked);
        System.out.println("Remove:" + linked.remove());
        System.out.println("Remove First:" + linked.removeFirst());
        System.out.println("Remove last:" + linked.removeLast());
        System.out.println("linkedList" + linked);

        linked.push("apple");
        System.out.println("linkedList" + linked);
        linked.pop();
        System.out.println("linkedList" + linked);
        System.out.println("size" + linked.size());

        System.out.println("clone:" + linked1);
        System.out.println(linked1.contains("banana"));
        String linkeds = linked1.toString();
        System.out.println(linkeds);
        String[] arr = linked1.toArray(new String[linked1.size()]);
        System.out.println(Arrays.toString(arr));
        System.out.println(arr[1]);
        System.out.println(linked1.indexOf("banana"));
        LinkedList<String> list = new LinkedList<>(Arrays.asList(arr));
        System.out.println(list);

        Iterator<String> iterator = linked1.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        try{
            System.out.println("element:"+linked1.element());
        } catch (Exception e) {
            System.out.println(e);
        }


        Iterator<String> iterator1 = linked1.descendingIterator();
        while (iterator1.hasNext()) {
            System.out.println(iterator1.next());
        }
        List<String> list2 = Arrays.asList("A", "B", "C");

        Spliterator<String> spliterator = list2.spliterator();
        spliterator.forEachRemaining(System.out::println);

        Stream<String> stream = list2.parallelStream();
        stream.forEach(System.out::println);



        


       // linked = Arrays.asList(arr);
       // Arrays.asList(arr) returns List<String>, but linked is a LinkedList<String>.

        

    }

    public static void priorityQueueDemo() {

        PriorityQueue<String> priorityQueue = new PriorityQueue<>();

        priorityQueue.add("banana");
        priorityQueue.add("apple");
        priorityQueue.add("oranges");
        priorityQueue.add("grapes");

        System.out.println("PriorityQueue" + priorityQueue);
        System.out.println("peek:" + priorityQueue.peek());
        
        System.out.println("====Polling elements (shows natural order)====");
        while (!priorityQueue.isEmpty()) {
            System.out.println(priorityQueue.poll());
        }

        PriorityQueue<String> cusPriorityQueue = new PriorityQueue<>(Comparator.comparing());
    }
    
    public static void blockingQueueDemo() {
    }
    
    public static void concurrentLinkedQueueDemo() {
    }

    public static void delayQueueDemo() {
    }

}
