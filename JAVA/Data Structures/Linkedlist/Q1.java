package Linkedlist;


import java.util.LinkedList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

//Remove Dups: Write code to remove duplicates from an unsorted linked list.

public class Q1 {
    
    public static void main(String[] args) {

        duplicate();
    }
    

    // public static void duplicate() {
       

    //     LinkedList<Integer> list = new LinkedList<>();
    //     list.add(10);
    //     list.add(20);
    //     list.addAll(Arrays.asList(5, 2, 3, 6, 9, 10));
        
    //     int n = list.size();
    //     int[] array = new int[n];

    //     int Csize = 0;
    //     int l =0;
    //     for (int i : list) {
    //         array[l++] = i;
    //         Csize++;
    //         for (int j = 0; j < Csize; j++) {
    //             if(array[j] == i)
    //             System.out.println(list.remove(Csize));
    //             l--;   
    //         }
    //     }

    public static void duplicate() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(10);
        list.add(20);
        list.addAll(Arrays.asList(5, 2, 3, 6, 9, 10));
        
        HashSet<Integer> seen = new HashSet<>();
        Iterator<Integer> itr = list.iterator();

        while (itr.hasNext()) {
            int value = itr.next();
            if (seen.contains(value)) {
                System.out.println("Removed :" + value);
                itr.remove();
            } else {
                seen.add(value);
            }

        }
        System.out.println("Final list without duplicates: " + list);

    }
        

    
}
