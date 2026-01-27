import java.util.EmptyStackException;

public class MyStack<E> {
    protected E[] internalArray;
    private int size = 0;

    @SuppressWarnings("unchecked")
    public MyStack() {
        this.internalArray = (E[]) new Object[100];
    }

    @SuppressWarnings("unchecked")
    public MyStack(int initialCapacity) {
        this.internalArray = (E[]) new Object[initialCapacity];
    }

    public int size() {
        return size;
    }

    public boolean push(E obj) {
        internalArray[size] = obj;
        size++;
        return true;
    }

    public E pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        size--;
        E temp = internalArray[size];
        internalArray[size] = null;
        return temp;
    }

    public E peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return internalArray[size - 1];
    }

    public boolean isEmpty() {
        if (size() == 0) {
            return true;
        }
        return false;
    }
}
