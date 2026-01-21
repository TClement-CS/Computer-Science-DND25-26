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
		return add(value, root);
	}

	public boolean add(E value, BinaryNode<E> root) {
		BinaryNode<E> next = new BinaryNode<E>(value);
		if (root.hasLeft() == false && value.compareTo(root.getValue()) < 0) {
			root.setLeft(next);
			return true;
		}
		if (root.hasRight() == false && value.compareTo(root.getValue()) > 0) {
			root.setRight(next);
			return true;
		}
		if (value.compareTo(root.getValue()) < 0) {
			return add(value, root.getLeft());
		}
		if (value.compareTo(root.getValue()) > 0) {
			return add(value, root.getRight());
		}
		return false;
	}

	// Removes value from this BST. Returns true if value has been
	// found and removed; otherwise returns false.
	// If removing a node with two children: replace it with the
	// largest node in the right subtree
	public boolean remove(E value) {
		if (root == null) {
			return false;
		}
		return removeHelper(root, value);
	}

	private boolean removeHelper(BinaryNode<E> node, E value) {
		if (node == null) {
			return false;
		}
		int val = value.compareTo(node.getValue());
		if (val < 0) {
			return removeHelper(node.getLeft(), value);
		} else if (val > 0) {
			return removeHelper(node.getRight(), value);
		} else {
			if (node.isLeaf()) {
				replaceNode(node, null);
				return true;
			}
			if (node.hasLeft() && !node.hasRight()) {
				replaceNode(node, node.getLeft());
				return true;
			}
			if (!node.hasLeft() && node.hasRight()) {
				replaceNode(node, node.getRight());
				return true;
			}
			BinaryNode<E> largest = node.getRight();
			while (largest.getRight() != null) {
				largest = largest.getRight();
			}
			node.setValue(largest.getValue());
			return removeHelper(largest, largest.getValue());
		}
	}

	private void replaceNode(BinaryNode<E> node, BinaryNode<E> replacement) {
		if (node.getParent() == null) {
			root = replacement;
		} else if (node.getParent().getLeft() == node) {
			node.getParent().setLeft(replacement);
		} else {
			node.getParent().setRight(replacement);
		}
		if (replacement != null) {
			replacement.setParent(node.getParent());
		}
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
