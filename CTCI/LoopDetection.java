import java.util.HashSet;

public class LoopDetection {
    
    public static void main(String[] args) {
        Node a = new Node("A");
        Node b = new Node("B");
        Node c = new Node("C");
        Node d = new Node("D");
        Node e = new Node("E");
        Node f = new Node("F");
        Node g = new Node("G");
        Node h = new Node("H");
        Node i = new Node("I");

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        f.next = g;
        g.next = h;
        h.next = i;
        i.next = d; // loop starts at D
        try{
            System.out.println(loopDetect(a).data);
        }catch(NullPointerException exception){
            System.out.println("Null");
        }
    }

    public static Node loopDetect(Node head){
        if (head==null || head.next==null) {
            return null;
        }else if (head.next==head) {
            return head;
        }
        HashSet<Node> set=new HashSet<>();

        while (head!=null) {
            if (!set.contains(head)) {
                set.add(head);
            }else{
                return head;
            }
            head=head.next;
        }
        return null;
    }

}


class Node{
    String data;
    Node next;
    Node(String data){
        this.data=data;
    }
}