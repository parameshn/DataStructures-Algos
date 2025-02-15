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


        Collections.sort(arrayList);
        System.out.println("ArrayList after sorting: " + arrayList);

        Collections.sort(arrayList, (s1, s2) -> Integer.compare(s1.length(), s2.length()));
        System.out.println("ArrayList after sorting: " + arrayList);
        
        arrayList.sort(Comparator.reverseOrder());
        System.out.println("ArrayList after sorting: " + arrayList);

        arrayList.sort(Comparator.naturalOrder());
        System.out.println("ArrayList after sorting: " + arrayList);

        arrayList.sort(Comparator.comparing(String::length));
        System.out.println("ArrayList after sorting: " + arrayList);

       
        arrayList.sort(Comparator.comparing(String::length).reversed());
        System.out.println("ArrayList after sorting: " + arrayList);

        
        arrayList.sort(Comparator.comparing(String::length).thenComparing(Comparator.naturalOrder()));
        System.out.println("ArrayList after sorting: " + arrayList);

        arrayList.sort(Comparator.comparing(String::length).thenComparing(Comparator.reverseOrder()));
        System.out.println("ArrayList after sorting: " + arrayList);

        arrayList.sort(Comparator.comparing(String::length).thenComparing(Comparator.reverseOrder()).reversed());
        System.out.println("ArrayList after sorting: " + arrayList);

        arrayList.sort(Comparator.comparing(String::length).thenComparing(Comparator.reverseOrder()).reversed().reversed());
        System.out.println("ArrayList after sorting: " + arrayList);

        Collections.sort(arrayList, Collections.reverseOrder());
        System.out.println("ArrayList after sorting: " + arrayList);

        System.out.println("===Clone===");
        List<String> cloneList = new ArrayList<>(arrayList);
        System.out.println("Is clone List empty: " + cloneList.isEmpty());
        System.out.println("Cloned List: " + cloneList);

        String[] array = arrayList.toArray(new String[0]);
        System.out.println("Array: " + Arrays.toString(array));
        System.out.println("Array: " + Arrays.toString(arrayList.toArray()));
        System.out.println("Array:" + array[1]);
        array = arrayList.toArray(new String[10]);
        System.out.println("Array: " + Arrays.toString(array));
        array = arrayList.toArray(new String[1]);// Java creates a new array of size
        System.out.println("Array: " + Arrays.toString(array));

        arrayList.addAll(Arrays.asList("peach", "berry", "dragonfruit"));
        System.out.println("ArrayList : " + arrayList);

        arrayList.removeAll(Arrays.asList("kiwi"));
        System.out.println("ArrayList :" + arrayList);

        arrayList.retainAll(Arrays.asList("apple", "banana"));
        System.out.println("ArrayList :" + arrayList);

        arrayList.clear();
        System.out.println("ArrayList :" + arrayList);

        List<String> unModifiable = Collections.unmodifiableList(cloneList);
        System.out.println("Unmodifiable List: " + unModifiable);

        try{
            unModifiable.add("kiwi");
        } catch (Exception e) {
            System.out.println(e);
        }


        List<String> syncList = Collections.synchronizedList(cloneList);
        System.out.println("Synchronized List: " + syncList);
        synchronized (syncList) {
            for (String s : syncList) {
                System.out.println(s);
            }
        }
       
        List<String> copyOnWriteList = new CopyOnWriteArrayList<>(cloneList);
        System.out.println("CopyOnWrite List: " + copyOnWriteList);

        copyOnWriteList.add("kiwi");
        System.out.println("CopyOnWrite List: " + copyOnWriteList);

        copyOnWriteList.sort(Comparator.naturalOrder());
        System.out.println("CopyOnWrite List: " + copyOnWriteList);

        copyOnWriteList.remove("kiwi");
        System.out.println("CopyOnWrite List: " + copyOnWriteList);

        int c = copyOnWriteList.lastIndexOf("kiwi");
        copyOnWriteList.remove(c);
        System.out.println("CopyOnWrite List: " + copyOnWriteList);

        System.out.println(copyOnWriteList.contains("kiwi"));

        try{
            System.out.println(Integer.valueOf(copyOnWriteList.indexOf("kiwi")).equals(2));
        } catch (Exception e) {
            System.out.println(e);
        }
        


    }
}