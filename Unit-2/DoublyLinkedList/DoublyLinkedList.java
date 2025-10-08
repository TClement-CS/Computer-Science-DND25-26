
public class DoublyLinkedList {
	// Implements a circular doubly-linked list.

	private final ListNode2<Nucleotide> SENTINEL = new ListNode2<Nucleotide>(null);
	private int nodeCount;

	// Constructor: creates an empty list
	public DoublyLinkedList() {
		nodeCount = 0;
		SENTINEL.setNext(SENTINEL);
		SENTINEL.setPrevious(SENTINEL);
	}

	// Constructor: creates a list that contains
	// all elements from the array values, in the same order
	public DoublyLinkedList(Nucleotide[] values) {

	}

	public ListNode2<Nucleotide> getSentinel() {
		return SENTINEL;
	}

	public ListNode2<Nucleotide> getHead() {
		return SENTINEL.getNext();
	}

	public ListNode2<Nucleotide> getTail() {
		return SENTINEL.getPrevious();
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
	public boolean contains(Nucleotide obj) {
		ListNode2<Nucleotide> newNode = SENTINEL.getNext();
		for (int i = 0; i < nodeCount; i++) {
			if (newNode.getValue().equals(obj)) {
				return true;
			}
			newNode = newNode.getNext();
		}
		return false;
	}

	// Returns the index of the first element in equal to obj;
	// if not found, returns -1.
	public int indexOf(Nucleotide obj) {
		int returncount = 0;
		for (ListNode2<Nucleotide> i = SENTINEL.getNext(); i.getValue() != obj; i = i.getNext()) {
			if (i.getValue() == obj) {
				return returncount;
			}
			returncount++;
		}
		return -1;

	}

	// Adds obj to this collection. Returns true if successful;
	// otherwise returns false.
	public boolean add(Nucleotide obj) {
		ListNode2<Nucleotide> newNode = new ListNode2<>(obj);
		ListNode2<Nucleotide> tail = SENTINEL.getPrevious();
		newNode.setNext(SENTINEL);
		newNode.setPrevious(tail);
		tail.setNext(newNode);
		SENTINEL.setPrevious(newNode);
		nodeCount++;
		return true;
	}

	// Removes the first element that is equal to obj, if any.
	// Returns true if successful; otherwise returns false.
	public boolean remove(Nucleotide obj) {
		if (obj == null) {
			return false;
		}
		ListNode2<Nucleotide> newNode = SENTINEL.getNext();
		for (int i = 0; i < nodeCount; i++) {
			if (newNode.getValue().equals(obj)) {
				newNode.getPrevious().setNext(newNode.getNext());
				newNode.getNext().setPrevious(newNode.getPrevious());
				nodeCount--;
				return true;
			}
			newNode = newNode.getNext();
		}
		return false;
	}

	// Returns the i-th element.
	public Nucleotide get(int i) {
		if (i < 0 || i >= nodeCount) {
			throw new IndexOutOfBoundsException();
		}
		ListNode2<Nucleotide> newNode = SENTINEL.getNext();
		for (int j = 0; j < i; j++) {
			newNode = newNode.getNext();
		}
		return newNode.getValue();
	}

	// Replaces the i-th element with obj and returns the old value.
	public Nucleotide set(int i, Nucleotide obj) {
		if (i < 0 || i >= nodeCount) {
			throw new IndexOutOfBoundsException();
		}
		ListNode2<Nucleotide> returnValue = null;
		ListNode2<Nucleotide> newNode = SENTINEL.getNext();
		for (int j = 0; j < i; j++) {
			if (newNode.getValue().equals(obj)) {
				returnValue = newNode;
				newNode.setValue(obj);
			}
			newNode = newNode.getNext();
		}
		return returnValue.getValue();
	}

	// Inserts obj to become the i-th element. Increments the size
	// of the list by one.
	public void add(int i, Nucleotide obj) {
		if (i < 0 || i > nodeCount) {
			throw new IndexOutOfBoundsException();
		}
		ListNode2<Nucleotide> newNode = SENTINEL.getNext();
		ListNode2<Nucleotide> insertedNode = new ListNode2<>(obj);
		for (int j = 0; j < i; j++) {
			if (j == i - 1) {
				newNode.getPrevious().setNext(insertedNode);
				newNode.setPrevious(insertedNode);
				nodeCount++;
			}
			newNode = newNode.getNext();
		}
	}

	// Removes the i-th element and returns its value.
	// Decrements the size of the list by one.
	public Nucleotide remove(int i) {
		if (i < 0 || i >= nodeCount) {
			throw new IndexOutOfBoundsException();
		}
		ListNode2<Nucleotide> newNode = SENTINEL.getNext();
		ListNode2<Nucleotide> returnValue = null;
		for (int j = 0; j < i; j++) {
			if (j == i - 1) {
				returnValue = newNode;
				newNode.getPrevious().setNext(newNode.getNext());
				newNode.getNext().setPrevious(newNode.getPrevious());
				nodeCount--;
			}
			newNode = newNode.getNext();
		}
		return returnValue.getValue();
	}

	// Returns a string representation of this list exactly like that for
	// MyArrayList.
	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		ListNode2<Nucleotide> current = SENTINEL.getNext();
		for (int i = 0; i < nodeCount; i++) {
			sb.append(current.getValue());
			if (i < nodeCount - 1)
				sb.append(", ");
			current = current.getNext();
		}
		sb.append("]");
		return sb.toString();
	}

	// Like question 7 on the SinglyLinkedList test:
	// Add a "segment" (another list) onto the end of this list
	public void addSegmentToEnd(DoublyLinkedList seg) {
		SENTINEL.setPrevious(seg.getTail());
		seg.getTail().setNext(SENTINEL);
		seg.getHead().setPrevious(SENTINEL.getPrevious());
		getTail().setNext(seg.getHead());
		nodeCount = seg.size() + nodeCount;

	}

	// Like question 8 on the SinglyLinkedList test:
	// You are to remove the next 16 nodes from the list, after the node nodeBefore.
	// (on the test these nodes were assumed to contain CCCCCCCCGGGGGGGG, but here
	// you do not need to assume or check for that)
	public void removeCCCCCCCCGGGGGGGG(ListNode2<Nucleotide> nodeBefore) {

	}

	// Like question 9 on the SinglyLinkedList test:
	// You are to find and delete the first instance of seg in the list.
	// If seg is not in the list, return false, otherwise return true.
	public boolean deleteSegment(DoublyLinkedList seg) {

	}

	// Like question 10 on the SinglyLinkedList test:
	// Delete the last three nodes in the list
	// If there are not enough nodes, return false
	public boolean deleteLastThree() {

	}

	// Like question 11 on the SinglyLinkedList test:
	// Replaces every node containing "A" with three nodes containing "T" "A" "C"
	public void replaceEveryAWithTAC() {

	}

}
