/**
 * Implements a Binary Tree's Node. 
 * 
 */

public class Node
{
	int key;
	String name;
	Node leftChild;
	Node rightChild;
	
	/**
	 * Constructor
	 *
	 * @param int key
	 * @param String name
	 */
	public Node(int key, String name)
	{
		this.key = key;
		this.name = name;
	}

	/**
	 * Returns a string with name plus key
	 *
	 * @return String
	 */
	public String toString()
	{
		return name + " has a key " + key;
	}

}
