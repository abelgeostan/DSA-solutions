

public class CheckBalanced {
    public static void main(String[] args) {
        // Creating a sample balanced tree
        /*
                 1
               /   \
              2     3
             / \   /
            4   5 6
        */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        Pair balance=isBalanced(root);
        System.out.println("Balanced? " + balance.bal); // true

        // Making it unbalanced by adding extra nodes
        root.left.left.left = new Node(7);
        root.left.left.left.left = new Node(8);

        balance=isBalanced(root);
        System.out.println("Balanced? " + balance.bal); // false
    }

    public static Pair isBalanced(Node root){
        if(root==null) return new Pair(-1,true);
        Pair l=isBalanced(root.left);
        Pair r=isBalanced(root.right);
        int h=Math.max(l.h,r.h)+1;
        boolean bal;
        // if(Math.abs(l.h-r.h)>1){
        //     bal=false;
        // }else{
        //     bal=true;
        // }
        //first implementation was wrong cause:
        // A node is balanced if and only if all three of these conditions are met:
        // Its left subtree is balanced.
        // Its right subtree is balanced.
        // The absolute difference in height between its left and right subtrees is no more than 1.
        // i only checked the last condition at first
        bal=l.bal && r.bal && Math.abs(l.h-r.h)<=1;
        return new Pair(h,bal);

    }
}

class Pair{
    int h;
    boolean bal;
    Pair(int h,boolean bal){
        this.h=h;
        this.bal=bal;
    }
}

class Node{
    int name;
    Node left;
    Node right;

    public Node(int name){
        this.name=name;
        left=null;
        right=null;
    }
}