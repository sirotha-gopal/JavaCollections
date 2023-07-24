import java.util.*;
import java.util.function.Predicate;

public class QueueLearn {

    public static void main(String[] args) {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        myArrayList.add(1);
        myArrayList.add(2);
        myArrayList.add(3);
        myArrayList.add(4);
        myArrayList.add(5);
        myArrayList.add(5);
        myArrayList.add(5);
        myArrayList.add(5);
        myArrayList.add(5);
        myArrayList.add(5);
        myArrayList.add(5);
        myArrayList.add(5);
        myArrayList.add(5);

        Iterator iterator = myArrayList.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println(myArrayList.get(4));



    }
}