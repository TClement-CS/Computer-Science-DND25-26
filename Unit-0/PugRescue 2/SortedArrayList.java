public class SortedArrayList<E extends Comparable<E>> extends MyArrayList<E> {

	@Override
	public boolean contains(E obj) {
		return binarySearch(internalArray, obj) != -1;
	}

	// May not contain more than one of the same object
	@Override
	public boolean add(E obj) {
		if (obj == null) {
			return super.add(obj);
		}
		if (internalArray[internalArray.length] == null) {
			super.add(internalArray.length - 1, obj);
			return true;
		}
		int index = 0;
		while (index < internalArray.length && obj.compareTo(internalArray[index]) > 0) {
			index++;
		}
		super.add(index, obj);
		return true;
	}

	@Override
	public boolean remove(E obj) {
		super.remove(obj);
		return true;
	}

	public E min() {
		E temp = null;
		for (int i = 0; i < objectCount; i++) {
			if (this.get(i).compareTo(temp) < 0) {
				temp = this.get(i);
			}
		}
		return temp;
	}

	public E max() {
		E temp = null;
		for (int i = 0; i < objectCount; i++) {
			if (this.get(i).compareTo(temp) > 0) {
				temp = this.get(i);
			}
		}
		return temp;
	}

	public int binarySearch(E[] arr, E key) {
		return binarySearchRecursiveHelper(arr, key, 0, arr.length - 1);
	}

	private int binarySearchRecursiveHelper(E[] arr, E key, int low, int high) {
		if (low > high) {
			return -1;
		}
		int mid = low + (high - low) / 2;
		int comparison = arr[mid].compareTo(key);

		if (comparison == 0) {
			return mid;
		} else if (comparison > 0) {
			return binarySearchRecursiveHelper(arr, key, low, mid - 1);
		} else {
			return binarySearchRecursiveHelper(arr, key, mid + 1, high);
		}
	}
}
