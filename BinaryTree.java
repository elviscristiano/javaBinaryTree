/**
 * Binary trees need O(log n) in order to perform operations. Based on Derek Banas tutorial. 
 * 
 */
public class BinaryTree
{
	Node root;

	/**
	 * Adds a node into the tree.
	 *
	 * @param int key
	 * @param String name
	 */
	public void addNode(int key, String name)
	{
		Node newNode = new Node(key, name);

		if (root == null) {
			root = newNode;
		} else {
			Node focusNode = root;
			Node parent;
			while (true) {
				parent = focusNode;
				if ( key < focusNode.key) {
					focusNode = focusNode.leftChild;
					if (focusNode == null) {
						parent.leftChild = newNode;
						return;
					}
				} else {
					focusNode = focusNode.rightChild;
					if (focusNode == null) {
						parent.rightChild = newNode;
						return;
					}
				}
			}
		}

	}

	/**
	 * Removes a node.
	 *
	 * @param int key
	 *
	 * @return boolean
	 */
	public boolean removeNode(int key)
	{
		Node focusNode = root;
		Node parent = root;
		boolean isItALeftChild = true;

		while (focusNode.key != key) {
			parent = focusNode;
			if (key < focusNode.key) {
				isItALeftChild = true;
				focusNode = focusNode.leftChild;
			} else {
				isItALeftChild = false;
				focusNode = focusNode.rightChild;
			}
			if (focusNode == null) {
				return false;
			}
		}

		if (focusNode.leftChild == null && focusNode.rightChild == null) {
			if (focusNode == root) {
				root = null;
			} else if (isItALeftChild) {
				parent.leftChild = null;
			} else {
				parent.rightChild = null;
			}
		} else if (focusNode.rightChild == null) {
			if (focusNode == root) {
				root = focusNode.leftChild;
			} else if (isItALeftChild) {
				parent.leftChild = focusNode.leftChild;
			} else {
				parent.rightChild = focusNode.leftChild;
			}
		} else if (focusNode.leftChild == null) {
			if (focusNode == root) {
				root = focusNode.rightChild;
			} else if (isItALeftChild) {
				parent.leftChild = focusNode.rightChild;
			} else {
				parent.rightChild = focusNode.leftChild;
			}			
		} else {
			Node replacement = getReplacementNode(focusNode);
			if (focusNode == root) {
				root = replacement;
			} else if (isItALeftChild) {
				parent.leftChild = replacement;
			} else {
				parent.rightChild = replacement;
			}
			replacement.leftChild = focusNode.leftChild;
		}
		return true;
	}

	/**
	 * Finds a node.
	 *
	 * @param int key
	 *
	 * @return Node if the node exists. Otherwise it returns null.
	 */
	public Node findNode(int key)
	{
		Node focusNode = root;
		while (focusNode.key != key) {
			if (key < focusNode.key) {
				focusNode = focusNode.leftChild;
			} else {
				focusNode = focusNode.rightChild;
			}
			if (focusNode == null) {
				return null;
			}
		}
		return focusNode;
	}

	/**
	 * Performs an in order traverse.
	 *
	 * @param Node focusNode
	 */
	public void inOrderTraverse(Node focusNode)
	{
		if (focusNode != null) {
			inOrderTraverse(focusNode.leftChild);
			System.out.println(focusNode);
			inOrderTraverse(focusNode.rightChild);
		}
	}

	/**
	 * Performs a pre order traverse.
	 *
	 * @param Node focusNode
	 */
	 public void preOrderTraverse(Node focusNode)
	{
		if (focusNode != null) {
			System.out.println(focusNode);
			preOrderTraverse(focusNode.leftChild);
			preOrderTraverse(focusNode.rightChild);
		}
	}

	/**
	 * Performs a post order traverse.
	 *
	 * @param Node focusNode
	 */
	public void postOrderTraverse(Node focusNode)
	{
		if (focusNode != null) {
			postOrderTraverse(focusNode.leftChild);
			postOrderTraverse(focusNode.rightChild);
			System.out.println(focusNode);
		}
	}

	/**
	 * Performs nodes replacement. 
	 *
	 * @param int key
	 *
	 * @return Node.
	 */
	public Node getReplacementNode(Node replacedNode)
	{
		Node replacementParent = replacedNode;
		Node replacement = replacedNode;
		Node focusNode = replacedNode.rightChild;

		while (focusNode != null) {
			replacementParent = replacement;
			replacement = focusNode;
			focusNode = focusNode.leftChild;
		}

		if (replacement != replacedNode.rightChild) {
			replacementParent.leftChild = replacement.rightChild;
			replacement.rightChild = replacedNode.rightChild;
		}
		return replacement;
	}
}
