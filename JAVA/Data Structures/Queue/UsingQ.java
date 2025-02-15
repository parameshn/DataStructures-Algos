package Queue;

import java.util.ArrayDeque;
import java.util.NoSuchElementException;
import java.util.Queue;

public class UsingQ  {
    public static void main(String[] main) {
        Queue<Integer> s = new ArrayDeque<>();// ArrayDeque is unbounded

        s.offer(1);
        s.offer(2);

        System.out.println(s.poll());
        System.out.println(s.poll());

        s.offer(1);
        s.offer(2);

        Integer e = s.poll();
        if (s != null) {
            //process next Task
        }

       try {
         Integer b = s.remove();
       }catch(NoSuchElementException h){}


       



    } 
}
