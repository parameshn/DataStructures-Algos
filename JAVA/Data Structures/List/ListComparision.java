import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;


public class ListComparision {
    public static void main(String[] arhs) {
        System.out.println("====Array List demo====");
        arrayListDemo();

    }


    public static void arrayListDemo() {

        List<String> arrayList = new ArrayList<>();
        arrayList.add("apple");
        arrayList.add("banana");
        arrayList.add("grapes");

        //adding at a specific index
        arrayList.add(1, "mango");
        System.out.println("ArrayLsit" + arrayList);

        arrayList.set(1, "brinjal");
        System.out.println("ArrayLsit" + arrayList);

        arrayList.remove(1);
        System.out.println("ArrayLsit" + arrayList);

        String bbb = arrayList.get(2);
        System.out.println(bbb);

        try {
            System.out.println(arrayList.get(5));
        } catch (Exception e) {
            System.out.println(e);
        }

        int b = arrayList.indexOf("grapes");
        System.out.println(b);
        System.out.println("ArrayList index of grapes : " + arrayList);

        b = arrayList.lastIndexOf("banana");
        System.out.println("===banana===");
        System.out.println("Last index of :" + b);
        b = arrayList.indexOf("banana");
        System.out.println("Index of :" + b);

        System.out.println("after adding banana at last");
        arrayList.add("banana");
        b = arrayList.lastIndexOf("banana");
        System.out.println("Last index of :" + b);
        System.out.println("ArrayLsit" + arrayList);

        arrayList.add(1, "orange");
        System.out.println("ArrayLsit" + arrayList);

        List<String> sublist = arrayList.subList(1, arrayList.size());
        System.out.println("sublist :" + sublist);
        // try{
        //     sublist = arrayList.subList("String", arrayList.size());
        // } catch (Exception e) {
        //     System.out.println(e);
        // }
        try {
            sublist = arrayList.subList(6, arrayList.size());
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("sublist :" + sublist);

        System.out.println("====For-each====");
        for (String s : arrayList) {
            System.out.println(s);
        }


        System.out.println("====Iterator====");
        Iterator<String> op = arrayList.iterator();
        while (op.hasNext()) {
            System.out.println(op.next());
        }

        System.out.println("====List Iterator Index====");
        ListIterator<String> it;
        it = arrayList.listIterator(1);
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        System.out.println("====List Iterator Backward Traversal====");
        it = arrayList.listIterator(arrayList.size());
        while (it.hasPrevious()) {
            System.out.println(it.previous());
        }
        ListIterator<String> listIt = arrayList.listIterator(1);

         System.out.println("====List Iterator Index Information====");
        listIt = arrayList.listIterator();
        while (listIt.hasNext()) {
            System.out.println("Next index: " + listIt.nextIndex());
            System.out.println("Next element: " + listIt.next());
        }

        System.out.println("====List Iterator Modification Capabilities====");
        listIt = arrayList.listIterator();
        while (listIt.hasNext()) {
            String element = listIt.next();
            if (element.equals("banana")) {
                listIt.set("kiwi");
            }
        }
        System.out.println("ArrayList after set operation: " + arrayList);

        listIt.add("pineapple");
        System.out.println("ArrayList after add operation: " + arrayList);


    }
}