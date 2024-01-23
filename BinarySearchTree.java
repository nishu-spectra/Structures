package Structures;
class BinarySearch
{
	class Node
	{
		int key;
		Node left;
		Node right;
		Node(int key)
		{
			this.key= key;
			left=right=null;
		}
	}
	Node root;
	BinarySearch()
	{
		root=null;
	}
	void insert(int key)
	{
        root = insertRec(root, key);
    }

    Node insertRec(Node root, int key) 
    {
        if (root == null) 
        {
            root = new Node(key);
            return root;
        }
        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);
        return root;
    }

    void inorder() 
    {
        inorderRec(root);
    }
    void inorderRec(Node root) 
    {
        if (root != null) 
        {
        	if(root.left!=null)
        	{
        		inorderRec(root.left);	
        	}
            System.out.print(root.key + " ");
            if(root.right!=null)
            {
            	inorderRec(root.right);
            }         
        }       
    }
    void preorder() 
    {
        preorderRec(root);
    }
    void preorderRec(Node root) 
    {
        if (root != null)
        {
        	System.out.print(root.key + " ");
        	if(root.left!=null)
        	{
        		preorderRec(root.left);   
        	}
            if(root.right!=null)
            {
            	preorderRec(root.right);
            }
        }   
    }
    void postorder() 
    {
        postorderRec(root);
    }
    void postorderRec(Node root) 
    {
        if (root != null)
        {
        	if(root.left!=null)
        	{
        		postorderRec(root.left); 
        	}
        	if(root.right!=null)
        	{
        		postorderRec(root.right);
        	}
            System.out.print(root.key + " ");
        }
        
    }
    int getHeight()
    {
        return calculateHeight(root);
    }
    int calculateHeight(Node node) {
        if (node == null)
        {
            return 0;
        }

        int leftHeight = calculateHeight(node.left);
        int rightHeight = calculateHeight(node.right);
       // System.out.println(leftHeight);
       // System.out.println(rightHeight);
        return Math.max(leftHeight, rightHeight) + 1;
    }
    int getSize() 
    {
        return calculateSize(root);
    }
    int calculateSize(Node node)
    {
        if (node == null)
        {
            return 0;
        }
        return calculateSize(node.left) + 1 + calculateSize(node.right);
    }
}
public class BinarySearchTree {
    public static void main(String[]args)
    {
        BinarySearch bst = new BinarySearch();
		bst.insert(70);
		bst.insert(20);
		bst.insert(40);
		bst.insert(30);
		bst.insert(60);
		bst.insert(90);
		bst.insert(100);
		bst.insert(75);
		bst.insert(10);
		System.out.print("\nInorder traversal is: ");
		bst.inorder();
		System.out.print("\nPreorder traversal is: ");
		bst.preorder();
		System.out.print("\nPostorder traversal is: ");
		bst.postorder();
		System.out.println("\nHeight= "+bst.getHeight());
		System.out.println("\nSize= "+bst.getSize());
    }
    
}
