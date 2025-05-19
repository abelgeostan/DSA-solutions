import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

// only works with perfectly balanced or complete binary trees

public class ListOfDepths_improved {
     public static void main(String[] args) {
        Node root = new Node("A");

        // Create the left and right children of the root (Depth 1)
        Node leftChildB = new Node("B");
        Node rightChildC = new Node("C");
        root.children.add(leftChildB);
        root.children.add(rightChildC);

        // Create the children of B (Depth 2)
        Node leftChildD = new Node("D");
        Node rightChildE = new Node("E");
        leftChildB.children.add(leftChildD);
        leftChildB.children.add(rightChildE);

        // Create the children of C (Depth 2)
        Node leftChildF = new Node("F");
        Node rightChildG = new Node("G");
        rightChildC.children.add(leftChildF);
        rightChildC.children.add(rightChildG);

        // Create the children of D (Depth 3)
        Node leftChildH = new Node("H");
        Node rightChildI = new Node("I");
        leftChildD.children.add(leftChildH);
        leftChildD.children.add(rightChildI);

        // Create the children of E (Depth 3)
        Node leftChildJ = new Node("J");
        Node rightChildK = new Node("K");
        rightChildE.children.add(leftChildJ);
        rightChildE.children.add(rightChildK);

        // Create the children of F (Depth 3)
        Node leftChildL = new Node("L");
        Node rightChildM = new Node("M");
        leftChildF.children.add(leftChildL);
        leftChildF.children.add(rightChildM);

        // Create the children of G (Depth 3)
        Node leftChildN = new Node("N");
        Node rightChildO = new Node("O");
        rightChildG.children.add(leftChildN);
        rightChildG.children.add(rightChildO);

        HashSet<Node> set=dfs(root);
        HashMap<Integer,LinkedList<Node>> map=bfs(root, set); 
        
        
        for(Integer k:map.keySet()){
            System.out.print(k+": ");
            for(Node i:map.get(k)){
                System.out.print(i.name);
            }
            System.out.println();
        }

    }

    public static HashSet<Node> dfs(Node root){
        HashSet<Node> set=new HashSet<>();
        while(root!=null){
            set.add(root);
            if (!root.children.isEmpty()) {
                root=root.children.get(0);
            }else{
                root=null;
            }
            
        }
        return set;
    }

    public static void addItem(HashMap<Integer,LinkedList<Node>> map,Integer key,Node item){
        if (map.containsKey(key)) {
            LinkedList<Node> list=map.get(key);
            list.add(item);
            
        }

    }

    public static HashMap<Integer,LinkedList<Node>> bfs(Node root,HashSet<Node> set){
        if (root==null) {
            return null;
        }else{
            Queue<Node> q= new LinkedList<>();
            HashMap<Integer,LinkedList<Node>> map=new HashMap<>();
            q.offer(root);
            // visited.add(root);
            Integer key=0;
            map.put(key, new LinkedList<>());
            if (set.contains(root)) {
                addItem(map,key,root);
            }

            

            while(!q.isEmpty()){
                Node de=q.poll();
                for (Node n:de.children) {
                    // if (!visited.contains(n)) {
                    //     visited.add(n);
                    //     q.offer(n);
                    // }
                    q.offer(n);
                    if (set.contains(n)) {
                        key++;
                        map.put(key, new LinkedList<>());
                    }
                    addItem(map, key, n);
                }
            }


            return map;
        }

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
