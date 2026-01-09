// Implements a BST with BinaryNode nodes

public class MyBST<E extends Comparable<E>> {

	private BinaryNode<E> root; // holds the root of this BST

	// Constructor: creates an empty BST.
	public MyBST() {
		root = null;
	}

	public BinaryNode<E> getRoot() {
		return root;
	}

	public int getHeight() {
		return root.getHeight();
	}

	// Returns true if this BST contains value; otherwise returns false.
	public boolean contains(E value) {
		return containsHelper(root, value);
	}

	public boolean containsHelper(BinaryNode<E> temp, E value) {
		if (temp == null) {
			return false;
		}
		if (value.compareTo(temp.getValue()) == 0) {
			return true;
		}
		if (value.compareTo(temp.getValue()) < 0) {
			return containsHelper(temp.getLeft(), value);
		} else {
			return containsHelper(temp.getRight(), value);
		}
	}

	// Adds value to this BST, unless this tree already holds value.
	// Returns true if value has been added; otherwise returns false.
	public boolean add(E value) {
		if (this.contains(value)) {
			return false;
		}

		return true;
	}

	// Removes value from this BST. Returns true if value has been
	// found and removed; otherwise returns false.
	// If removing a node with two children: replace it with the
	// largest node in the right subtree
	public boolean remove(E value) {
		return false;
	}

	// Returns the minimum in the tree
	public E min() {
		return minHelp(root);
	}

	public E minHelp(BinaryNode<E> node) {
		if (node.hasLeft()) {
			minHelp(node.getLeft());
		}
		return node.getValue();
	}

	// Returns the maximum in the tree.
	public E max() {
		return maxHelp(root);
	}

	public E maxHelp(BinaryNode<E> node) {
		if (node.hasRight()) {
			minHelp(node.getRight());
		}
		return node.getValue();
	}

	// Returns a bracket-surrounded, comma separated list of the contents of the
	// nodes, in order
	// e.g. [Apple, Cranberry, Durian, Mango]
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		toStringHelper(root, sb);
		sb.append("]");
		return sb.toString();

	}

	public StringBuilder toStringHelper(BinaryNode<E> node, StringBuilder sb) {
		if (node.hasLeft()) {
			toStringHelper(node.getLeft(), sb);
		}

		if (node != this.max()) {
			sb.append(node.getValue() + ", ");
		}

		if (node.hasRight()) {
			toStringHelper(node.getRight(), sb);
		}
		return sb;
	}

}
