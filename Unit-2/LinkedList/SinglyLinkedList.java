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
	public SinglyLinkedList(Object[] values) {
		int n = 0;
		nodeCount = values.length;
		head = new ListNode<>((E) values[0]);
		ListNode<E> current = head;
		for (int i = 1; i < values.length; i++) {
			ListNode<E> newNode = new ListNode<>((E) values[i]);
			current.setNext(newNode);
			current = newNode;
		}

		tail = current;
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
			if (i.getValue().equals(obj)) {
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
			if (i.getValue().equals(obj)) {
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
		if (head == null) {
			head = temp;
			tail = temp;
			return true;
		}
		tail.setNext(temp);
		tail = temp;
		nodeCount++;
		return true;

	}

	// Removes the first element that is equal to obj, if any.
	// Returns true if successful; otherwise returns false.
	public boolean remove(E obj) {
		if (head == null) {
			return false;
		}
		if (head.getValue().equals(obj)) {
			head = head.getNext();
			if (head == null)
				tail = null;
			nodeCount--;
			return true;
		}
		ListNode<E> prev = head;
		ListNode<E> current = head.getNext();
		while (current != null) {
			if (current.getValue().equals(obj)) {
				prev.setNext(current.getNext());
				if (current == tail) {
					tail = prev;
				}
				nodeCount--;
				return true;
			}
			prev = current;
			current = current.getNext();
		}
		return false;
	}

	// Returns the i-th element.
	public E get(int i) {
		if (i >= nodeCount || i < 0) {
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
		if (i < 0 || i >= nodeCount) {
			throw new IndexOutOfBoundsException();
		}
		ListNode<E> temp = head;
		if (i == 0) {

		}
		for (int j = 0; j < i; j++) {
			temp = temp.getNext();
		}
		E oldValue = temp.getValue();
		temp.setValue((E) obj);

		return oldValue;

	}

	// Inserts obj to become the i-th element. Increments the size
	// of the list by one.
	public void add(int i, Object obj) {
		if (i < 0 || i >= nodeCount) {
			throw new IndexOutOfBoundsException("Index: " + i);
		}

		ListNode<E> newNode = new ListNode<>((E) obj);

		if (i == 0) {
			newNode.setNext(head);
			head = newNode;
		} else {
			ListNode<E> prev = head;
			for (int j = 0; j < i - 1; j++) {
				prev = prev.getNext();
			}
			newNode.setNext(prev.getNext());
			prev.setNext(newNode);
			if (newNode.getNext() == null)
				tail = newNode;
		}

		nodeCount++;
	}

	// Removes the i-th element and returns its value.
	// Decrements the size of the list by one.
	public E remove(int i) {
		E removedValue = head.getValue();
		if (i == 0) {
			head = head.getNext();
			if (head == null)
				tail = null;
		} else {
			ListNode<E> prev = head;
			for (int j = 0; j < i - 1; j++) {
				prev = prev.getNext();
			}
			ListNode<E> toRemove = prev.getNext();
			removedValue = toRemove.getValue();
			prev.setNext(toRemove.getNext());
			if (toRemove == tail)
				tail = prev;
		}
		nodeCount--;
		return removedValue;
	}

	// Returns a string representation of this list exactly like that for
	// MyArrayList.
	public String toString() {
		StringBuilder tostring = new StringBuilder();
		ListNode<E> temp = head;
		for (int i = 0; i < nodeCount; i++) {
			tostring.append(head.getValue());
			temp = temp.getNext();
		}
		return tostring.toString();
	}

}
