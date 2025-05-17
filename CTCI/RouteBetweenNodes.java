
import java.util.ArrayList;
import java.util.List;

class RouteBetweenNodes {
    public static void main(String[] args) {
        // Example usage
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

        System.out.println("AtoC: "+isRouteBetweenNodes(graph, nodeA, nodeC)); // true
        System.out.println("AtoD: "+isRouteBetweenNodes(graph, nodeA, nodeD)); // false
    }

    public static boolean isRouteBetweenNodes(Graph graph, Node start, Node end) {
        if (start == null || end == null) {
            return false;
        }else if (start == end) {
            return true;
        }else {
            List<Node> visited = new ArrayList<>();
            return dfs(start, end, visited);
        }
    }

    public static boolean dfs(Node start, Node end, List<Node> visited){
        if (start == null || end == null) {
            return false;
        }else if (start == end) {
            return true;
        }else{
		    visited.add(start);
            for(Node n:start.children){
                if(!visited.contains(n)){
                    if(dfs(n,end,visited)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}

class Node{
    public String name;
    public List<Node> children;
    public Node(String name) {
        this.name = name;
        this.children = new ArrayList<>();
    }
}

class Graph{
    public List<Node> nodes;
    public Graph() {
        this.nodes = new ArrayList<>();
    }

    public void addNode(Node node) {
        nodes.add(node);
    }

    public void addEdge(Node from, Node to) {
        from.children.add(to);
    }
}