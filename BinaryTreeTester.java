/**
 * Tests the BinaryTree class. 
 * 
 */
public class BinaryTreeTester
{

	public static void main(String[] args) 
	{
		BinaryTree aTree = new BinaryTree();
		aTree.addNode(50, "boss");
		aTree.addNode(25, "vice pres");
		aTree.addNode(15, "manager");
		aTree.addNode(30, "secretary");
		aTree.addNode(75, "sales manager");
		aTree.addNode(85, "salesman");
		System.out.println();
		System.out.println("In Order Traverse");
		aTree.inOrderTraverse(aTree.root);
		System.out.println();
		System.out.println("Pre Order Traverse");
		aTree.preOrderTraverse(aTree.root);
		System.out.println();
		System.out.println("Post Order Traverse");
		aTree.postOrderTraverse(aTree.root);
		System.out.println();
		System.out.println("Searching 25...");
		System.out.println(aTree.findNode(25));
		System.out.println();
		System.out.println("Remove 25...");
		aTree.removeNode(25);
		aTree.preOrderTraverse(aTree.root);
	}
}