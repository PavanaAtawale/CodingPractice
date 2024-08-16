import java.util.*;

// https://www.hackerrank.com/challenges/binary-search-tree-insertion/problem
// https://www.hackerrank.com/challenges/tree-height-of-a-binary-tree/problem 

class Node {
    Node left;
    Node right;
    int data;
    
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class BST {
   
  	public static void preOrder( Node root ) {
      
    	if( root == null)
        	return;
      
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
     
    }

 /* Node is defined as :
 class Node 
    int data;
    Node left;
    Node right;
    
    */

	public static Node insert(Node root,int data) {
        Node now = root;
        if(root == null) return new Node(data); 
        boolean cont = true;
        while(cont) {
            if(data < now.data){
                if(now.left != null) {
                    now = now.left;
                } else {
                    now.left = new Node(data);
                    cont = false;    
                }
            } else {
                if(now.right != null) {
                    now = now.right;
                } else {
                    now.right = new Node(data);
                    cont = false;    
                }
            }
        }
        return root;
    }

    public static int height(Node root) {
        // Write your code here.
        if(root == null) return -1;
        int left = height(root.left);
        int right = height(root.right);
        //System.out.println("Data: " + root.data + " , left: " + left + ", right: " + right);
        return Integer.max(left, right) + 1;
    }

	public static void start() {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
      	preOrder(root);
    }	
}
