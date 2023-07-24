import java.rmi.UnexpectedException;
import java.util.Iterator;

public class MyLinkedList implements Iterable{

    private Node head;

    private Node tail;

    private static int size;

    @Override
    public Iterator iterator() {
        return new MyLinkedListIterator();
    }

    private class MyLinkedListIterator implements Iterator{

        Node tempNode;
        Node nextNode;
        MyLinkedListIterator(){
            this.tempNode = head;
        }
        @Override
        public boolean hasNext() {
            if(tempNode == null)
                return false;
            nextNode = tempNode;
            tempNode = tempNode.next;
            return true;
        }

        @Override
        public Object next() {
            return nextNode.data;
        }
    }

    private class Node{
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
        }

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    public void insertFirst(int val){
        if(head == null){
            head = new Node(val);
            size++;
            return;
        }
        Node newNode = new Node(val);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public void display(){
        if(head == null){
            System.out.println("List is empty!");
            return;
        }
        Node tempHead = head;
        while(tempHead != null){
            System.out.print(tempHead.data + "->");
            tempHead = tempHead.next;
        }
        System.out.println("End.");
    }

    public void insertLast(int val){
        if(head == null){
            head = new Node(val);
            size++;
            return;
        }
        Node tempHead = head;
        while(tempHead.next != null){
            tempHead = tempHead.next;
        }
        tempHead.next = new Node(val);
        size++;
    }

    public void insertAt(int index, int val){
        Node tempNode = head;
        if(index == size){
            insertLast(val);
            size++;
            return;
        }
        if(index > size) {
            throw new ArrayIndexOutOfBoundsException("Index out of bound exception");
        }
        if(index == 0){
            insertFirst(val);
            size++;
            return;
        }
        for(int i = 1; i < index; i++) {
            tempNode = tempNode.next;
        }
        tempNode.next = new Node(val,tempNode.next);
        size++;
    }

    public int get(int index){
        if(index >= size){
            throw new ArrayIndexOutOfBoundsException(index);
        }
        Node tempNode = head;
        int val = -1;
        while(index-- >= 0){
            val = tempNode.data;
            tempNode = tempNode.next;
        }
        return val;
    }

    public int size(){
        return MyLinkedList.size;
    }

    public int removeFirst(){
        int removedItem = 0;
        if(head == null){
            throw new IllegalArgumentException("List is empty!");
        }
        removedItem = head.data;
        head = head.next;
        size--;
        return removedItem;
    }
    public int removeLast(){
        int removedItem = 0;
        if(head == null){
            throw new IllegalArgumentException("List is already empty!");
        }
        Node tempNode = head;
        if(size == 1){
            return removeFirst();
        }
        for(int i = 2; i < size; i++){
            tempNode = tempNode.next;
        }
        removedItem = tempNode.next.data;
        tempNode.next = null;
        size--;
        return removedItem;
    }

    public int remove(int index) {
        int removedElement = 0;
        if(index == 0){
            return removeFirst();
        }
        if(index == size-1){
            return removeLast();
        }
        if(index >=size){
            throw new IndexOutOfBoundsException();
        }

        Node preNode = head;
        Node tempNode = head;
        for(int i = 0; i < index; i++){
            preNode = tempNode;
            tempNode = tempNode.next;
        }
        preNode.next = tempNode.next;
        removedElement = tempNode.data;
        size--;
        return removedElement;
    }
    public boolean isItTrue(int a){
        return a>a;
    }
}