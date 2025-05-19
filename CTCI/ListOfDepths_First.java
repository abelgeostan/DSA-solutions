import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ListOfDepths_First {
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

        HashMap<Node,LinkedList<Node>> map=dfs(root); //roooooooot
        bfs(root, map);
        for(Node k:map.keySet()){
            for(Node i:map.get(k)){
                System.out.print(i.name);
            }
            System.out.println();
        }

    }

    public static HashMap<Node,LinkedList<Node>> dfs(Node root){
        HashMap<Node,LinkedList<Node>> map=new HashMap<>();
        while(root!=null){
            map.put(root, new LinkedList<>());
            if (!root.children.isEmpty()) {
                root=root.children.get(0);
            }else{
                root=null;
            }
            
        }
        return map;
    }

    public static void addItem(HashMap<Node,LinkedList<Node>> map,Node key,Node item){
        if (map.containsKey(key)) {
            LinkedList<Node> list=map.get(key);
            list.add(item);
            
        }

    }

    public static void bfs(Node root,HashMap<Node,LinkedList<Node>> map){
        if (root==null) {
            return;
        }else{
            Queue<Node> q= new LinkedList<>();
            q.offer(root);
            // visited.add(root);
            if (map.containsKey(root)) {
                addItem(map,root,root);
            }

            Node key=root;

            while(!q.isEmpty()){
                Node de=q.poll();
                for (Node n:de.children) {
                    // if (!visited.contains(n)) {
                    //     visited.add(n);
                    //     q.offer(n);
                    // }
                    q.offer(n);
                    if (map.containsKey(n)) {
                        key=n;
                    }
                    addItem(map, key, n);
                }
            }



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
