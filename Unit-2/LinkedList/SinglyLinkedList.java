// Implements a singly-linked list.

import java.util.List;

public class SinglyLinkedList<E> {
	private ListNode<E> head;
	private ListNode<E> tail;
	private int nodeCount;

	// Constructor: creates an empty list
	public SinglyLinkedList() {
		head = null;
		tail = null;
		nodeCount = 0;
	}

	// Constructor: creates a list that contains
	// all elements from the array values, in the same order
	// to-do:
	public SinglyLinkedList(Object[] values) {
		int n = 0;
		for (ListNode i = head; i != tail; i = i.getNext()) {
			i.setValue(values[n]); // not correct
			n++;
		}
	}

	public ListNode<E> getHead() {
		return head;
	}

	public ListNode<E> getTail() {
		return tail;
	}

	// Returns true if this list is empty; otherwise returns false.
	public boolean isEmpty() {
		if (nodeCount == 0) {
			return true;
		}
		return false;
	}

	// Returns the number of elements in this list.
	public int size() {
		return nodeCount;
	}

	// Returns true if this list contains an element equal to obj;
	// otherwise returns false.
	public boolean contains(E obj) {
		for (ListNode i = head; i != tail; i = i.getNext()) {
			if (i.getValue() == obj) {
				return true;
			}
		}
		return false;
	}

	// Returns the index of the first element in equal to obj;
	// if not found, returns -1.
	public int indexOf(E obj) {
		int n = 0;
		for (ListNode i = head; i != tail; i = i.getNext()) {
			if (i.getValue() == obj) {
				return n;
			}
			n++;
		}
		return -1;
	}

	// Adds obj to this collection. Returns true if successful;
	// otherwise returns false.
	public boolean add(E obj) {
		ListNode temp = new ListNode<E>(obj);
		tail.setNext(temp);
		tail = temp;
		return true;

	}

	// Removes the first element that is equal to obj, if any.
	// Returns true if successful; otherwise returns false.
	public boolean remove(E obj) {
		if()
		for (ListNode i = head; i != tail; i = i.getNext()) {
			if (i.getValue() == obj) {
				return true;
			}
		}
	}

	// Returns the i-th element.
	public E get(int i) {
		if (i > nodeCount || i < 0) {
			throw new IndexOutOfBoundsException();
		}
		ListNode<E> next = head;
		for (int j = 0; j < i; j++) {
			next = next.getNext();
		}
		return next.getValue();

	}

	// Replaces the i-th element with obj and returns the old value.
	public E set(int i, Object obj) {

		E 

	}

	// Inserts obj to become the i-th element. Increments the size
	// of the list by one.
	public void add(int i, Object obj) {
	}

	// Removes the i-th element and returns its value.
	// Decrements the size of the list by one.
	public E remove(int i) {

	}

	// Returns a string representation of this list exactly like that for
	// MyArrayList.
	public String toString() {

	}

}
