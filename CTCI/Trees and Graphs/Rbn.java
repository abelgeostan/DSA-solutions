import java.util.*;

public class Rbn {
    public static void main(String[] args) {
        
        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        nodeA.children.add(nodeB);
        
        nodeB.children.add(nodeC);
        
        nodeD.children.add(nodeB);
        
        nodeD.children.add(nodeA);
        
        // List<Node> visited=new ArrayList<>();
        // HashSet<Node> visited=new HashSet<>();
        System.out.println("A to C: "+isRBNbfs(nodeA, nodeC));
    }

    public static boolean isRBN(Node A,Node B){
        return isRBN(A, B, new HashSet<>());
    }

    public static boolean isRBN(Node A,Node B,HashSet<Node> visited){
        if(A==B)return true;
        visited.add(A);
        for(Node t:A.children){
            if(!visited.contains(t)&&isRBN(t, B, visited)) return true;
        }
        return false;
        
    }
    public static boolean isRBNbfs(Node A,Node B){
        HashSet<Node> visited=new HashSet<>();
        Queue<Node> que=new LinkedList<>();
        que.add(A);
        while(!que.isEmpty()){
            Node t=que.remove();
            if(visited.contains(t)) continue;
            if(B==t)return true;
            visited.add(t);
            for(Node child:t.children){
                que.add(child);
            }
        }
        return false;
    }
}


class Node{
    String name;
    List<Node> children;
    public Node(String name){
        this.name=name;
        children=new ArrayList<>();
    }

}