/* See ArrayList documentation here:
 * http://docs.oracle.com/javase/7/docs/api/java/util/ArrayList.html
 */

/*
 * Your indexed functions should throw IndexOutOfBoundsException if index is invalid!
 */

public class MyArrayList<E> {

	/* Internal Object counter */
	protected int objectCount;

	/* Internal Object array */
	protected E[] internalArray;

	/* Constructor: Create it with whatever capacity you want? */
	@SuppressWarnings("unchecked")
	public MyArrayList() {
		this.internalArray = (E[]) new Object[100];
	}

	/* Constructor with initial capacity */
	@SuppressWarnings("unchecked")
	public MyArrayList(int initialCapacity) {
		this.internalArray = (E[]) new Object[initialCapacity];
	}

	/* Return the number of active slots in the array list */
	public int size() {
		int size = 0;
		for (int i = 0; i < internalArray.length; i++) {
			if (internalArray[i] != null) {
				size++;
			}
		}
		return size;
	}

	/* Are there zero objects in the array list? */
	public boolean isEmpty() {
		int amt = 0;
		for (int i = 0; i < internalArray.length; i++) {
			if (internalArray[i] != null) {
				amt++;
			}
		}
		if (amt == 0) {
			return true;
		} else {
			return false;
		}
	}

	/* Get the index-th object in the list. */
	public E get(int index) {
		return internalArray[index];
	}

	/* Replace the object at index with obj. returns object that was replaced. */
	public E set(int index, E obj) {
		internalArray[index] = obj;
		return internalArray[index];
	}

	/*
	 * Returns true if this list contains an element equal to obj;
	 * otherwise returns false.
	 */
	public boolean contains(E obj) {
		/* ---- YOUR CODE HERE ---- */
		for (int i = 0; i < objectCount; i++) {
			if (internalArray[i] == obj) {
				return true;
			}
		}
		return false;
	}

	/* Insert an object at index */
	@SuppressWarnings("unchecked")
	public void add(int index, E obj) {
		/* ---- YOUR CODE HERE ---- */
		internalArray[index] = obj;
		if (index >= objectCount) {
			objectCount = index + 1;
		}
	}

	/* Add an object to the end of the list; returns true */
	@SuppressWarnings("unchecked")
	public boolean add(E obj) {
		/* ---- YOUR CODE HERE ---- */
		objectCount++;
		internalArray[objectCount] = obj;
		return true;
	}

	/* Remove the object at index and shift. Returns removed object. */
	public E remove(int index) {
		/* ---- YOUR CODE HERE ---- */
		for (int i = index; i < objectCount - 1; i++) {
			internalArray[i] = internalArray[i + 1];
		}
		internalArray[objectCount] = null;
		return internalArray[index];
	}

	/*
	 * Removes the first occurrence of the specified element from this list,
	 * if it is present. If the list does not contain the element, it is unchanged.
	 * More formally, removes the element with the lowest index i such that
	 * (o==null ? get(i)==null : o.equals(get(i))) (if such an element exists).
	 * Returns true if this list contained the specified element (or equivalently,
	 * if this list changed as a result of the call).
	 */
	// to-do:
	public boolean remove(E obj) {
		/* ---- YOUR CODE HERE ---- */
	}

	/*
	 * For testing; your string should output as "[X, X, X, X, ...]" where X, X, X,
	 * X, ... are the elements in the ArrayList.
	 * If the array is empty, it should return "[]". If there is one element, "[X]",
	 * etc.
	 * Elements are separated by a comma and a space.
	 */
	// to-do:
	public String toString() {
		/* ---- YOUR CODE HERE ---- */
	}

}