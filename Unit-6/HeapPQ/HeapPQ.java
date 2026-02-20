
public class HeapPQ<E extends Comparable<E>> implements MyPriorityQueue<E> {

	private E[] heap;
	private int objectCount;

	public HeapPQ() {
		this.heap = (E[]) new Comparable[3];
		this.objectCount = 0;
	}

	// Returns the number of elements in the priority queue
	public int size() {
		return objectCount;
	}

	// DO NOT CHANGE MY JANKY TOSTRING!!!!!
	public String toString() {
		StringBuffer stringbuf = new StringBuffer("[");
		for (int i = 0; i < objectCount; i++) {
			stringbuf.append(heap[i]);
			if (i < objectCount - 1)
				stringbuf.append(", ");
		}
		stringbuf.append("]\nor alternatively,\n");

		for (int rowLength = 1, j = 0; j < objectCount; rowLength *= 2) {
			for (int i = 0; i < rowLength && j < objectCount; i++, j++) {
				stringbuf.append(heap[j] + " ");
			}
			stringbuf.append("\n");
			if (j < objectCount) {
				for (int i = 0; i < Math.min(objectCount - j, rowLength * 2); i++) {
					if (i % 2 == 0)
						stringbuf.append("/");
					else
						stringbuf.append("\\ ");
				}
				stringbuf.append("\n");
			}
		}
		return stringbuf.toString();
	}

	// Doubles the size of the heap array
	private void increaseCapacity() {
		E[] newHeap = (E[]) new Comparable[objectCount * 2];
		for (int i = 0; i < objectCount; i++) {
			newHeap[i] = heap[i];
		}

	}

	// Returns the index of the "parent" of index i
	private int parent(int i) {
		return (i + 1) / 2 - 1;
	}

	// Returns the index of the *smaller child* of index i
	private int smallerChild(int i) {
		return (i + 1) * 2 - 1;
	}

	// Swaps the contents of indices i and j
	private void swap(int i, int j) {
		if (i >= objectCount || i < 0 || j >= objectCount || j < 0) {
			throw new IndexOutOfBoundsException();
		}
		E temp = heap[i];
		heap[i] = heap[j];
		heap[j] = temp;
	}

	// Bubbles the element at index i upwards until the heap properties hold again.
	private void bubbleUp(int i) {
		while (i > 0) {
			if (heap[i].compareTo(heap[parent(i)]) > 0) {
				swap(i, parent(i));
				i = parent(i);
			} else {
				break;
			}
		}
	}

	// Bubbles the element at index i downwards until the heap properties hold
	// again.
	private void bubbleDown(int i) {
		while (true) {
			int left = 2 * i + 1;
			int right = 2 * i + 2;
			int largest = i;
			if (left < objectCount &&
					heap[left].compareTo(heap[largest]) > 0) {
				largest = left;
			}
			if (right < objectCount &&
					heap[right].compareTo(heap[largest]) > 0) {
				largest = right;
			}
			if (largest != i) {
				swap(i, largest);
				i = largest;
			} else {
				break;
			}
		}
	}

	@Override
	public void add(E obj) {
		if (objectCount == heap.length) {
			increaseCapacity();
		}

		heap[objectCount] = obj;
		bubbleUp(objectCount);
		objectCount++;
	}

	@Override
	public E removeMin() {
		E min = heap[0];
		heap[0] = heap[objectCount - 1];
		heap[objectCount - 1] = null;
		objectCount--;
		bubbleDown(0);
		return min;
	}

	@Override
	public E peek() {
		return heap[0];
	}

	@Override
	public boolean isEmpty() {
		return objectCount == 0;
	}

}
