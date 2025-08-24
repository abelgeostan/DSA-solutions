

public class GroupList {
    public static void main(String[] args) {
        // Test 1
        Node head1 = createList(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        System.out.print("Original List 1: ");
        printList(head1);
        Node result1 = groupList(head1);
        System.out.print("Modified List 1: ");
        printList(result1);
        System.out.println();

        // Test 2
        Node head2 = createList(new int[]{10, 20, 30, 40, 50, 60});
        System.out.print("Original List 2: ");
        printList(head2);
        Node result2 = groupList(head2);
        System.out.print("Modified List 2: ");
        printList(result2);
        System.out.println();

        // Test 3 (single node)
        Node head3 = createList(new int[]{99});
        System.out.print("Original List 3: ");
        printList(head3);
        Node result3 = groupList(head3);
        System.out.print("Modified List 3: ");
        printList(result3);
    }

    // Utility to create linked list from array
    private static Node createList(int[] arr) {
        if (arr.length == 0) return null;
        Node head = new Node(arr[0]);
        Node curr = head;
        for (int i = 1; i < arr.length; i++) {
            curr.next = new Node(arr[i]);
            curr = curr.next;
        }
        return head;
    }

    // Utility to print linked list
    private static void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
        System.out.println();
    }
    
    static Node groupList(Node head){

        Node st=head;
        int count=1;
        while(st.next!=null){
            st=group(st,count);
            count++;
        }

        return head;
    }

    static Node group(Node head,int count){
        
        int c=count;
        int newc=0;
        Node temp=head;
        while(temp.next!=null && c!=0){
            temp=temp.next;
            c--;
            newc++;
        }
        if(c!=0) count=newc;
        if(count==1)return head;
        if(count%2==0){
            while(count!=0){
                head=head.next;
                count--;
            }
            return head;
        }else{
            Node prevLast=head;
            
            Node orghead=head.next;
            head=head.next;
            Node prev=head;
            head=head.next;

            Node nextNode=null;
            while(count!=1 &&head!=null){
                nextNode=head.next;
                head.next=prev;
                prev=head;
                head=nextNode;
                count--;
            }
            prevLast.next=prev;
            orghead.next=nextNode;
            return orghead;
            

        }

    }
}

class Node{
    int val;
    Node next;
    Node(int val){
        this.val=val;
    }
}