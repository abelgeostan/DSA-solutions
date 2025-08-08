

public class Successor {
    public static void main(String[] args) {
        /*
                  20
                 /  \
               10    30
              /  \     \
             5   15     35
            /
           3
        */

        // Create nodes
        Node root1 = new Node(20);
        Node node10 = new Node(10);
        Node node30 = new Node(30);
        Node node5 = new Node(5);
        Node node15 = new Node(15);
        Node node35 = new Node(35);
        Node node3 = new Node(3);

        // Build the BST with parent pointers
        root1.left = node10;
        root1.right = node30;
        node10.parent = root1;
        node30.parent = root1;

        node10.left = node5;
        node10.right = node15;
        node5.parent = node10;
        node15.parent = node10;

        node30.right = node35;
        node35.parent = node30;

        node5.left = node3;
        node3.parent = node5;

        // Test cases
        Node[] testNodes = {node3, node5, node10, node15, root1, node30, node35};

        for (Node testNode : testNodes) {
            Node successor = findSucc(testNode);
            if (successor != null) {
                System.out.println("Successor of " + testNode.data + " is: " + successor.data);
            } else {
                System.out.println("Successor of " + testNode.data + " is: null");
            }
        }
        // Build the tree from the example
        Node root = new Node(10);
        root.left = new Node(5);
        root.left.parent = root;

        root.left.right = new Node(7);
        root.left.right.parent = root.left;

        Node nodeToTest = new Node(8);
        root.left.right.right = nodeToTest;
        nodeToTest.parent = root.left.right;

        // Find the successor
        Node successor = findSucc(nodeToTest);

        // Print the result
        System.out.println("Node to find successor of: " + nodeToTest.data);
        if (successor != null) {
            System.out.println("Your code's output: " + successor.data);
            System.out.println("Correct successor: 10");
        } else {
            System.out.println("Your code returned null.");
        }
    
    }

    public static Node findSucc(Node node){
        if (node==null) {
            return null;
        }
        if (node.right==null) {
            while(node.parent!=null){
                if(node.parent.right!=node){
                    break;
                }
                node=node.parent;
            }
            return node.parent;
            
        }
        return leftMostNode(node.right);
    }
    public static Node leftMostNode(Node node){
        if(node.left==null)return node;
        return leftMostNode(node.left);
    }
}

class Node{
    int data;
    Node left;
    Node right;
    Node parent;
    Node(int data){
        this.data=data;
        left=null;
        right=null;
        parent=null;
    }
}
