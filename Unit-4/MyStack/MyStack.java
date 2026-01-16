public class MyStack<E> {

    protected int objectCount;

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
        int count = 0;
        for (int i = 0; i < internalArray.length; i++) {
            if (internalArray[i] != null) {
                count++;
            }
        }
        return count;
    }

    public boolean push(E obj) {
        internalArray[size] = obj;
        size++;
        return true;
    }

    public E pop() {
        E temp = internalArray[size];
        size--;
        return temp;
    }

    public E peek() {
        return internalArray[size];
    }

    public boolean isEmpty() {
        if (size() == 0) {
            return true;
        }
        return false;
    }
}
