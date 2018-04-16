package tree;


public class BondaryNodesTree {
	
	static class Node {
		int data;
		Node left,right;
		
		Node (int num){
			data=num;
			left=right=null;
		}
	}
	Node root;
	
	// print leaf nodes of a binary tree
	void printLeavesNode (Node node){
		if(node!=null)
		{
			printLeavesNode(node.left);
			
			if(node.left==null && node.right==null)
				System.out.print(node.data+"->");
			printLeavesNode(node.right);
		}
	}
	
	//print left boundary node , not leaf node 
	//upar se niche
	
	void printBondaryLeft(Node node){
		if(node!=null){
			if(node.left!=null)
			{
				//print node first before calling itself 
				//for let subtree
				System.out.print(node.data+"->");
				printBondaryLeft(node.left);
			}
			else if (node.right!=null){
				System.out.print(node.data);
				printBondaryLeft(node.right);
			}
		}
	}
	//print right boundary ,not leaf nodes
	//niche se upar
	void printBoundaryRight(Node node){
		if(node!=null){
			if(node.right!=null){
			//first call for right tree, then
				//print the node
				printBoundaryRight(node.right);
				System.out.print(node.data+"->");
			}
			else if(node.left!=null){
				printBoundaryRight(node.left);
				System.out.print(node.data+"->");
			}
		}
	}
	
	
	void printBoundaryNodes(Node node){
		if(node!=null){
			//print the root element
			System.out.print(node.data+"->");
			//print the left boundary top-down
			printBondaryLeft(node.left);
			//print all leaf node of the left subtree from left to right
			printLeavesNode(node.left);
			//print all leaf node of the right subtree from left to right
			printLeavesNode(node.right);
			//print the right boundary from bottom up 
			printBoundaryRight(node.right);
		}
			
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BondaryNodesTree tree=new BondaryNodesTree();
		tree.root= new Node(1);
		tree.root.left=new Node(2);
		tree.root.right=new Node(3);
		tree.root.left.left=new Node(4);
		tree.root.left.right=new Node(5);
		tree.root.right.left=new Node(6);
		tree.root.right.right=new Node(7);
		
		
		tree.printBoundaryNodes(tree.root);
		
		
	}

}
