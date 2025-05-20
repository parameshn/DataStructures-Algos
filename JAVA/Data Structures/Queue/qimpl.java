package Queue;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;
//port java.util.concurrent.*;
import java.util.stream.Stream;
import java.util.concurrent.TimeUnit;



public class qimpl {

static
   class StringLengthComparator implements Comparator<String> {
        @Override
        public int compare(String s1, String s2) {
            return Integer.compare(s1.length(), s2.length());
        }
    }

    Comparator<String> comparator = new StringLengthComparator();
    
    

    
    public static void main(String[] args) {
        System.out.println("====Array Queue====");
        // arrayDequeDemo();
        System.out.println("====Linked List Queue====");
      //  linkedListQueueDemo();
        System.out.println("====Priority Queue====");
      //  priorityQueueDemo();
        
        System.out.println("====ConcurrentLinked Queue====");
      //  concurrentLinkedQueueDemo();
        System.out.println("====DelayQueue====");
        delayQueueDemo();

        System.out.println("====BlockingQueue ====");
        blockingQueueDemo();
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
        System.out.println("ArrayDequeue 1" + arrayDeque1);

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
        System.out.println("Array Deqeue" + arrayDeque);
        System.out.println("Array Deqeue 1" + arrayDeque1);
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
        // LinkedList<String> linked1 = (LinkedList<String>) linked.clone();
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
        try {
            System.out.println("element:" + linked1.element());
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

        System.out.println("PriorityQueue :" + priorityQueue);
        System.out.println("peek:" + priorityQueue.peek());

        System.out.println("====Polling elements (shows natural order)====");
        while (!priorityQueue.isEmpty()) {
            System.out.println(priorityQueue.poll());
        }

        priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
        /*
         * Unfortunately, you cannot change the comparator of an existing PriorityQueue
         * instance without re-adding the elements. The comparator is set when the queue
         * is constructed and is used to maintain the heap structure. If you need a
         * different order, you'll have to create a new PriorityQueue with the new
         * comparator and add the elements to it.
         */

        priorityQueue.offer("banana");
        priorityQueue.offer("apple");
        priorityQueue.offer("oranges");
        priorityQueue.offer("grapes");

        System.out.println("PriorityQueue :" + priorityQueue);

        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return (a % 10) - (b % 10);
            }

        });

        pq.add(1);
        pq.add(20);
        pq.offer(40);
        System.out.println("pq :" + pq);// Sorts based on the last digit of numbers.

        // Integer int0 = 0;
        // Integer int1 = 1;
        // System.out.println(int0.compareTo(int1) < 0);
        // String str0 = "zero";
        // String str1 = "one";
        // assert str0.compareTo(str1) > 0;
        // System.out.println(str0.compareTo(str1) > 0);
        // //sgn(int0.compareTo(int1) < 0);
        // int compareResult = int0.compareTo(int1); // This will be negative if int0 < int1.
        // int sign = Integer.signum(compareResult); // Returns -1 for negative, 0 for zero, or 1 for positive.
        // System.out.println("sign: " + sign);

        // int strCompare = str0.compareTo(str1); // Depending on lexicographical order, this might be > 0.
        // int strSign = Integer.signum(strCompare);
        // System.out.println("String sign: " + strSign);

        // Comparator<Integer> badComparator = (a, b) -> a - b; // Subtraction may cause overflow!
        // System.out.println(badComparator.compare(2, 5)); // Output: -3
        // System.out.println(badComparator.compare(5, 2)); // Output: 3
        // System.out.println(badComparator.compare(5, 5)); // Output: 0

        // Integer i = 0;
        // String s = "one";
        // assert i.compareTo(s) < 0;

        // Constructor with Collection<? extends E> c
        priorityQueue = new PriorityQueue<>(List.of("jack fruit", "apple", "banana", "grapes"));

        /*
         * PriorityQueue(Collection<? extends E> c)
         * // natural ordering of elements taken from c, unless
         * // c is a PriorityQueue or SortedSet, in which case
         * // copy c's ordering
         */

        System.out.println("priority Queue:" + priorityQueue);
        /*
         * PriorityQueue(int initialCapacity)
         * // natural ordering, specified initial capacity
         */

        // Constructor with Initial Capacity
        priorityQueue = new PriorityQueue<>(10);
        // No, PriorityQueue does not fill the remaining capacity with anything.
        /*
         * Unlike arrays, the extra capacity in PriorityQueue remains unused until new
         * elements are added. The capacity only determines the initial size of the
         * internal array, but it does not limit the number of elements that can be
         * stored (because it dynamically resizes when needed).
         */

        priorityQueue.addAll(List.of("jack fruit", "apple", "banana", "grapes"));

        System.out.println("priority Queue 2:" + priorityQueue);
        System.out.println(priorityQueue.size());

        // Constructor with Initial Capacity and Comparator<? super E>
        priorityQueue = new PriorityQueue<>(10, Comparator.reverseOrder());
        priorityQueue.addAll(List.of("jack fruit", "apple", "banana", "grapes"));

        System.out.println("priority Queue 3:" + priorityQueue);
        System.out.println(priorityQueue.size());

        // Constructor with Initial Capacity and Comparator<? super E>
        // priorityQueue = new PriorityQueue<>(List.of("jack fruit", "apple", "banana", "grapes"));
        PriorityQueue<String> priorityQueue2 = new PriorityQueue<>(priorityQueue);
        System.out.println("priority Queue 3:" + priorityQueue2);
        System.out.println(priorityQueue2.size());
        /*
         * The constructor PriorityQueue(PriorityQueue<? extends E> c) copies only the
         * elements, NOT the comparator.
         * 
         * By default, a new PriorityQueue uses natural ordering (Comparable).
         * 
         * The ordering from priorityQueue is lost because the constructor does not copy
         * the comparator.
         */
        priorityQueue2.add("apple2");
        System.out.println("priority Queue 3:" + priorityQueue2);
        /*
         * Even though priorityQueue2 does not inherit the comparator, it accidentally
         * retains the reverse order because of how the elements are polled and
         * reinserted into a new heap structure.
         * 
         * Even though no comparator was copied, the heap structure is preserved because
         * of the natural insertion order.
         * 
         */

        //   priorityQueue2 = new PriorityQueue<>(priorityQueue,Comparator.naturalOrder()); //error
        priorityQueue2 = new PriorityQueue<>(Comparator.naturalOrder());
        priorityQueue2.addAll(priorityQueue);
        System.out.println("priority Queue 3:" + priorityQueue2);

        // Constructor with SortedSet<? extends E>
        SortedSet<String> sortedSet = new TreeSet<>(Set.of("jack fruit", "apple", "banana", "grapes"));
        priorityQueue2 = new PriorityQueue<>(sortedSet);
        System.out.println("priority Queue 7:" + priorityQueue2);

        // fail-fast iterator
        PriorityQueue<Integer> pq2 = new PriorityQueue<>();
        pq2.add(10);
        pq2.add(20);
        pq2.add(30);

        Iterator<Integer> iterator = pq2.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
            // pq2.add(40); // Modifying during iteration
        }
        pq2.add(40);

        iterator = pq2.iterator(); //removing causes error
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
            // pq2.add(40); // Modifying during iteration
        }

        /*
         * When you create an iterator, it captures the modification state (modCount) of
         * the collection at that moment.
         * If the collection is modified after the iterator is created, the next call to
         * next() will check the modCount and detect a change, causing a fail-fast
         * behavior.
         */

        // Custom Comparator: Sort by String Length
        priorityQueue = new PriorityQueue<>(Comparator.comparing(String::length));
        priorityQueue.addAll(List.of("jack fruit", "apple", "banana", "grapes"));
        System.out.println(priorityQueue);

        // Reverse String Length Order
        priorityQueue = new PriorityQueue<>(Comparator.comparing(String::length).reversed());
        priorityQueue.addAll(List.of("jack fruit", "apple", "banana", "grapes"));
        System.out.println(priorityQueue);

        // Custom Lexicographical Order (Ignoring Case)
        // Case-insensitive sorting.
        priorityQueue = new PriorityQueue<>(Comparator.comparing(String::toLowerCase));
        priorityQueue.addAll(List.of("jack fruit", "apple", "banana", "grapes"));
        System.out.println(priorityQueue);

        //Sort by Last Character
        // Sorted based on last character of the string.
        priorityQueue = new PriorityQueue<>(Comparator.comparing(s -> s.charAt(s.length() - 1)));
        priorityQueue.addAll(List.of("jack fruit", "apple", "banana", "grapes"));
        System.out.println(priorityQueue);

        // Using an Anonymous Class
        priorityQueue = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.length() - s2.length(); // Sort by string length
            }
        });
        priorityQueue.addAll(List.of("jack fruit", "apple", "banana", "grapes"));
        System.out.println(priorityQueue);

        //mparator<String> comparator = new StringLengthComparator();
       

        Comparator<String> comparator = new StringLengthComparator();

        PriorityQueue<String> queue1 = new PriorityQueue<>(comparator);
        PriorityQueue<String> queue2 = new PriorityQueue<>(comparator);

        queue1.addAll(priorityQueue);
        queue2.addAll(priorityQueue);
        System.out.println(queue1);
        System.out.println(queue2);

       queue1.stream()
                .sorted(Comparator.naturalOrder())
                .forEach(System.out::println);


        //   PriorityQueue<String> cusPriorityQueue = new PriorityQueue<>(Comparator.comparing());

    }
    
   


    public static void concurrentLinkedQueueDemo() {

        // Default Constructor (Empty Queue)
        Queue<String> concurrentQueue = new ConcurrentLinkedDeque<>();

        concurrentQueue.add("apple");
        concurrentQueue.add("apple");
        concurrentQueue.add("grapes");

        System.out.println("ConcurrentLinkedQueue: " + concurrentQueue);

        Iterator<String> iterator = concurrentQueue.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // Retrieve and remove
        System.out.println("Poll: " + concurrentQueue.poll());
        System.out.println("Peek: " + concurrentQueue.peek());

        System.out.println("Size: " + concurrentQueue.size());// O(n)
        /*
         * Expensive! Since ConcurrentLinkedQueue does not maintain a size counter, it
         * must iterate through all elements.
         */

        System.out.println("Is empty: " + concurrentQueue.isEmpty());

        System.out.println(concurrentQueue.contains("Delta"));//O(n)

        List<String> list = List.of("A", "B", "C");
        ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<>(list);
        System.out.println(queue); // Output: [A, B, C]

        queue.stream()
                .sorted(Comparator.reverseOrder()) // Sorting in descending order
                .forEach(System.out::println);

        queue.stream()
                .sorted(Comparator.naturalOrder())
                .forEach(System.out::println);

    }
    
    public static void blockingQueueDemo() {

       // ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(0);//exception on first insertion 
       ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(3); // fixed capacity (FIFO order)
       queue = new ArrayBlockingQueue<>(3, true);
       ArrayBlockingQueue<String> queue3 = new ArrayBlockingQueue<>(3);

       PriorityQueue<String> pq = new PriorityQueue<>(Comparator.reverseOrder());
       pq.addAll(List.of("king", "queen", "bishop"));
       queue = new ArrayBlockingQueue<>(3, false, pq);
       System.out.println("queue reverse :" + queue);
       queue = new ArrayBlockingQueue<>(3, true);
       

        /*
         * fair = true → Uses fair ordering for waiting threads
         * (first-come-first-served).
         * 
         * fair = false (default) → Can allow threads to "jump the queue" for
         * performance.
         */
        queue.add("apple");
        queue.addAll(List.of("grape", "banana"));
        System.out.println(queue);
        // queue.add("pomergranate"); // exception 
        queue = new ArrayBlockingQueue<>(4);
        queue.add("pomergranate");
        System.out.println(queue);
        queue.add("apple");
        queue.addAll(List.of("grape", "banana"));
        System.out.println(queue);
        // try{
        //      queue.put("jack fruit"); // add e, waiting as long as necessary

        //  } catch (Exception e) {   //forever
        //      System.out.println(e);
        //  }
         System.out.println(queue);
         
         try {
            String s1 = queue.take();// retrieve and remove the head of this queue, waiting
            // as long as necessary
             System.out.println(s1);
             System.out.println(queue);

         } catch (Exception e) {
             System.out.println(e);
         }

         /*
          * put(E e) Blocks if the queue is full until space is available
          * take() Blocks if the queue is empty until an element is available
          * offer(E e) Non-blocking version of put(), returns false if full
          * poll() Non-blocking version of take(), returns null if empty
          * peek() Retrieves (but does not remove) the head element
          * remainingCapacity() Returns the remaining space in the queue
          */
         queue.offer("cherry");
         System.out.println(queue);


         String s = queue.poll();
         System.out.println(s);
         System.out.println(queue);
         try {
             s = queue.poll(10, TimeUnit.MILLISECONDS); // // retrieve and remove the head, waiting up to the timeout
             // s = queue.poll(10, TimeUnit.MILLISECONDS);// error
             System.out.println(s);
             System.out.println(queue);
        }
         catch (Exception e) {
            
         }
         System.out.println(s);
         System.out.println(queue);
         s = queue.remove();
         System.out.println(s);
         System.out.println(queue);
         s = queue.peek();
         System.out.println(s);
         System.out.println(queue);

         System.out.println(queue.remainingCapacity());
         System.out.println(queue.size());
         try{
             boolean boo = queue.offer("berry", 10, TimeUnit.MILLISECONDS); // // insert e, waiting up to the timeout

             System.out.println(boo);
             System.out.println(queue);
         System.out.println(queue.remainingCapacity());
         System.out.println(queue.size());
         }catch(Exception e){}

         queue.add("dragon fruit");
         System.out.println(queue.remainingCapacity());
         System.out.println(queue.size());

        // Queue<String> queue2 = new ArrayBlockingQueue<String>(5);
        //The method drainTo(ArrayBlockingQueue<String>) is undefined for the type Queue<String>
        //queue2.drainTo(queue);
        ArrayBlockingQueue<String> queue2 = new ArrayBlockingQueue<String>(5);
        int i = queue2.drainTo(queue);
         /*
          * attempts to remove all elements from queue2 and add them to queue. Since
          * queue2 is empty, no elements will be transferred.
          * queue would remain unchanged
          */
         System.out.println(i);
         System.out.println("Queue:"+queue);
         System.out.println("Queue2:" +queue2);
         i = queue.drainTo(queue2);
         System.out.println(i);
         System.out.println("Queue:" +queue);
         System.out.println("Queue2:" + queue2);
         queue2.drainTo(queue);
         System.out.println("Queue:" + queue);
         System.out.println("Queue2:" + queue2);

         i = queue.drainTo(queue2, 2);
         System.out.println(i);
         System.out.println("Queue:" + queue);
         System.out.println("Queue2:" + queue2);
         System.out.println(queue.remainingCapacity());
         System.out.println(queue2.remainingCapacity());
         queue2.addAll(List.of("apple", "banana", "jack fruit"));

         System.out.println("Before removal: " + queue2);


        /*
         * While this works, ArrayBlockingQueue is designed for FIFO operations (add to
         * the end, remove from the front). Middle-element removal is atypical for
         * queues and is O(n) time complexity.
         * 
         * This code is safe in a single-threaded context.
         * 
         * In multi-threaded scenarios, use proper synchronization or thread-safe
         * iterators.
         */
         Iterator<String> iterator = queue2.iterator();
         while (iterator.hasNext()) {
             if (iterator.next().equals("banana")) { // Target element //O(n) middle removal 
                 iterator.remove(); // Remove current element safely
                 break; // Exit after removing
             }
         }
         

         System.out.println("After removal: " + queue2);
         System.out.println("After removal: " + queue2.remove("apple"));
         System.out.println("After removal: " + queue2);

         

        // System.out.println("After removal: " + queue2.poll("apple"));//not possible
         


         BlockingQueue<String> linkedBlockingQueue = new LinkedBlockingQueue<>(); // Unbounded queue
         linkedBlockingQueue = new LinkedBlockingQueue<>(5);// Fixed capacity
         linkedBlockingQueue.addAll(List.of("apple", "banana", "jack fruit"));
         System.out.println(linkedBlockingQueue.remove("banana"));
         System.out.println("Before removal: " + linkedBlockingQueue);


















       


       


    }

    public static void delayQueueDemo() {
    }

}

