public class Intersection {



    public static void main(String[] args) {
        
        Node common5 = new Node(5);
        Node common6 = new Node(6);
        Node common7 = new Node(7);
        common5.next = common6;
        common6.next = common7;

        Node lA_1 = new Node(1);
        Node lA_2 = new Node(2);
        lA_1.next = lA_2; lA_2.next = common5; // List A: 1 -> 2 -> 5 -> 6 -> 7

        Node lB_1 = new Node(10);
        Node lB_2 = new Node(11);
        Node lB_3 = new Node(12);
        lB_1.next = lB_2; lB_2.next = lB_3; lB_3.next = common5; // List B: 10 -> 11 -> 12 -> 5 -> 6 -> 7

        // Case C: Intersection very close to the head of one list (List B is a sublist of List A)
        Node lC_1 = new Node(100);
        Node lC_2 = new Node(200);
        lC_1.next = lC_2; lC_2.next = common5; // List C: 100 -> 200 -> 5 -> 6 -> 7

        Node lD_1 = common5; // List D starts at the common point: 5 -> 6 -> 7


         // Case A: Intersection at the head (same list)
        
        Node sameList1_1 = new Node(1);
        Node sameList1_2 = new Node(2);
        sameList1_1.next = sameList1_2;

        // Case C: Single node lists (no intersection)
        Node single1 = new Node(1);
        Node single2 = new Node(2);


        // Case E: Same values, no structural intersection (important distinction!)
        
        Node val1_1 = new Node(1);
        Node val1_2 = new Node(2);
        Node val1_3 = new Node(3);
        val1_1.next = val1_2; val1_2.next = val1_3; // List 1: 1 -> 2 -> 3

        Node val2_1 = new Node(1); // NEW Node(1)
        Node val2_2 = new Node(2); // NEW Node(2)
        Node val2_3 = new Node(3); // NEW Node(3)
        val2_1.next = val2_2; val2_2.next = val2_3; // List 2: 1 -> 2 -> 3 (separate nodes)



        Node inter=intersect(val1_1,val2_1);
        if (inter==null) {
            System.out.println(inter);
        }else{
            System.out.println(inter.data);
        }
        


    }

    static Node intersect(Node first, Node second){
        if (first==null || second==null) {
            return null;
        }
        Node temp=first;
        int len1=1,len2=1;
        while(temp.next!=null){
            len1++;
            temp=temp.next;
        }
        Node temp2=second;
        while(temp2.next!=null){
            len2++;
            temp2=temp2.next;
        }
        if(temp!=temp2){
            return null;
        }
        int diff;
        if (len1>len2) {
            diff=len1-len2;
            for(int i=0;i<diff;i++){
                first=first.next;
            }
        }else if (len2>len1) {
            diff=len2-len1;
            for(int i=0;i<diff;i++){
                second=second.next;
            }
        }
        while (first!=null && second!=null) {
            if (first==second) {
                return first;
            }
            first=first.next;
            second=second.next;
        }
        return null;


    }

}

class Node{
    int data;
    Node next;
    Node(int data){
        this.data=data;
        this.next=null;
    }
}