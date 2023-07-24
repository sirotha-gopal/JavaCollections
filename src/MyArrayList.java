import java.util.Arrays;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class MyArrayList <E> implements Iterable{
    private int defualtSize = 5;

    private Object[] object;

    private static int index = 0;
    MyArrayList(){
        this.object = new Object[defualtSize];
    }

    public void add(E element){
        checkSize();
        this.object[index ++] = element;
    }

    private void checkSize() {
        if(defualtSize == index +1 ){
             this.object = Arrays.copyOf(this.object, defualtSize + 5);
             defualtSize = defualtSize + 5;
        }
    }

    public E get(int index){
        if(MyArrayList.index<index)
            throw new ArrayIndexOutOfBoundsException("asdf");
        return (E) this.object[index];
    }
    public int size(){
        return MyArrayList.index;
    }

    @Override
    public Iterator iterator() {
        return new MyItr();
    }

    @Override
    public void forEach(Consumer action) {
        Iterable.super.forEach(action);
    }

    @Override
    public Spliterator spliterator() {
        return Iterable.super.spliterator();
    }
    private class MyItr implements Iterator{
        int size = index;
        int itrIndex = 0;
        @Override
        public boolean hasNext() {
            return size>0?true:false;
        }

        @Override
        public E next() {
            size--;
            return (E) object[itrIndex++];
        }
    }
}
