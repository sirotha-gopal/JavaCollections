import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        myLinkedList();
//        System.out.println(new MyLinkedList().isItTrue(2));
    }

    private static void myLinkedList() {
        MyLinkedList ll = new MyLinkedList();
        ll.insertLast(1);
        ll.insertLast(2);



        ll.display();
        for(Object i : ll) {
            System.out.print((int) i + " ");
        }
        System.out.println();
        System.out.println("Size of the list:: "+ll.size());
//        System.out.println("First removed:: "+ ll.removeFirst() );
//        System.out.println("Last removed:: "+ll.removeLast());
        System.out.println("Removed Element:: "+ll.remove(1));

        ll.display();

    }
}