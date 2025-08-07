

public class ValidateBST {
    

    public static void main(String[] args) {
        // Test Case 1: A valid BST ✅
        /*
              20
             /  \
            10   30
           /  \
          5    15
        */
        Node root1 = new Node(20);
        root1.left = new Node(10);
        root1.right = new Node(30);
        root1.left.left = new Node(5);
        root1.left.right = new Node(15);
        System.out.println("Is the first tree a valid BST? " + isBST(root1)); // Expected: true

        System.out.println("---");

        // Test Case 2: An invalid BST ❌
        /*
              10
             /
            5
             \
              12  <-- Invalid node
        */
        Node root2 = new Node(10);
        root2.left = new Node(5);
        root2.left.right = new Node(12);
        System.out.println("Is the second tree a valid BST? " + isBST(root2)); // Expected: false
        
        System.out.println("---");
        
        // Test Case 3: Another invalid BST ❌
        /*
              20
             /  \
            10   30
                  \
                   18 <-- Invalid node
        */
        Node root3 = new Node(20);
        root3.left = new Node(10);
        root3.right = new Node(30);
        root3.right.right = new Node(18);
        System.out.println("Is the third tree a valid BST? " + isBST(root3)); // Expected: false
    }

    public static boolean isBST(Node root){
        return isBST(root, null,null);
    }


    public static boolean isBST(Node root, Integer max, Integer min){
        if(root==null) return true;
        if(max!=null && root.name>=max){
            return false;
        }
        if(min!=null && root.name<=min){
            return false;
        }

        return isBST(root.right,max,root.name) && isBST(root.left,root.name,min);


    }


    
}



class Node{
    int name;
    Node left;
    Node right;
    Node(int name){
        this.name=name;
        left=null;
        right=null;
    }
}
