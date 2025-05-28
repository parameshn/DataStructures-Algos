package Linkedlist;

import java.util.Arrays;
import java.util.LinkedList;

//Return Kth to Last: Implement an algorithm to find the kth to last element of a singly linked list.

public class Q2 {
    public static void main(String[] args) {

         LinkedList<Integer> list = new LinkedList<>();
        list.add(10);
        list.add(20);
        list.addAll(Arrays.asList(5, 2, 3, 6, 9, 10));
        System.out.println(list);

        eleFromLast(2, list);
    }
    
    public static <T> void  eleFromLast(int k, LinkedList<T> list) {
        int i = list.size() - k;
        T ele = list.get(i);

        System.out.println(ele);
    }
}
