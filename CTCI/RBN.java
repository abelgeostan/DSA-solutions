

import java.util.ArrayList;
import java.util.List;

public class RBN {
    public static void main(String[] args) {
        Graph graph = new Graph();
        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        graph.addNode(nodeA);
        graph.addNode(nodeB);
        graph.addNode(nodeC);
        graph.addNode(nodeD);
        graph.addEdge(nodeA, nodeB);
        graph.addEdge(nodeB, nodeC);
        graph.addEdge(nodeD, nodeB);
        graph.addEdge(nodeD, nodeA);
        List<Node> visited=new ArrayList<>();
        System.out.println("A to C: "+isRBN(nodeA, nodeC, visited));
    }

    public static boolean isRBN(Node start, Node end, List<Node> visited){
        if (start==null||end==null) {
            return false;
        }else if(start==end){
            return true;
        }else if(!visited.contains(start)){
            visited.add(start);
            for(Node n:start.children){
                if(isRBN(n,end,visited)){
                    return true;
                }
            }
        }


        return false;
    }
}

class Node {

    String name;
    List<Node> children;

    Node(String name){
        this.name=name;
        children= new ArrayList<>();
    }
    
}

class Graph{
    List<Node> nodes;

    public Graph(){
        nodes= new ArrayList<>();
    }

    public void addNode(Node node){
        nodes.add(node);
    }
    public void addEdge(Node from, Node to){
        from.children.add(to);
    }
}