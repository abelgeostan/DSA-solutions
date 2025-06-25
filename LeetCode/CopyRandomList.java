// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

// Renamed the class as requested
public class CopyRandomList {

    public Node copyRandomList(Node head) {
        if(head==null){
            return null;
        }
        Node oldHead=head;
        while(head!=null){
            Node temp=new Node(head.val);
            temp.next=head.next;
            head.next=temp;
            head=head.next.next;

        }
        head=oldHead;
        while(head!=null){
            if(head.random==null){
                head.next.random=null;
                
            }else{
                head.next.random=head.random.next;

            }
            head=head.next.next;

        }
        head=oldHead;
        oldHead=oldHead.next;//so it becomes new list head now
        Node te=head;
        while(head!=null){
            head=head.next;
            if(te.next!=null){
               te.next=te.next.next; 
            }
            te=head;
            
            
        }
        return oldHead;
    }

    // Helper method to print the linked list for verification
    public static void printList(Node head, String listName) {
        System.out.println("\n--- " + listName + " ---");
        Node current = head;
        while (current != null) {
            System.out.print("Node(" + current.val);
            if (current.random != null) {
                System.out.print(", random=" + current.random.val);
            } else {
                System.out.print(", random=null");
            }
            System.out.print(") -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        CopyRandomList solution = new CopyRandomList();

        // Example 1: LeetCode Example
        Node node1 = new Node(7);
        Node node2 = new Node(13);
        Node node3 = new Node(11);
        Node node4 = new Node(10);
        Node node5 = new Node(1);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        node1.random = null;   // 7's random is null
        node2.random = node1;  // 13's random is 7
        node3.random = node5;  // 11's random is 1
        node4.random = node3;  // 10's random is 11
        node5.random = node1;  // 1's random is 7

        System.out.println("Original List before copy:");
        printList(node1, "Original List (Before Copy)");

        Node copiedList = solution.copyRandomList(node1);

        System.out.println("\nCopied List:");
        printList(copiedList, "Copied List");

        // Verify that original list is restored (important for the space-optimized solution)
        System.out.println("\nOriginal List after copy (should be restored to original state):");
        printList(node1, "Original List (After Copy)");


        // Example 2: Empty list
        System.out.println("\n--- Test Case: Empty List ---");
        Node emptyList = null;
        Node copiedEmptyList = solution.copyRandomList(emptyList);
        printList(copiedEmptyList, "Copied Empty List");

        // Example 3: Single node list with self-random
        System.out.println("\n--- Test Case: Single Node ---");
        Node singleNode = new Node(5);
        singleNode.random = singleNode; // Random points to itself
        System.out.println("Original Single Node List (Before Copy):");
        printList(singleNode, "Original Single Node List");
        Node copiedSingleNode = solution.copyRandomList(singleNode);
        System.out.println("Copied Single Node List:");
        printList(copiedSingleNode, "Copied Single Node List");
        System.out.println("Original Single Node List (After Copy):");
        printList(singleNode, "Original Single Node List");

        // Example 4: List with only random pointers (next are null) - though problem implies linked list
        // This scenario is usually not tested as it breaks the 'next' chain, but if it were:
        System.out.println("\n--- Test Case: Random pointers only (conceptual) ---");
        Node nA = new Node(100);
        Node nB = new Node(200);
        nA.random = nB;
        nB.random = nA;
        // nA.next = nB; // Not setting next to keep it simpler for this test concept
        // nB.next = null; // Not setting next
        System.out.println("Original List (Random Only - conceptually):");
        // We can't print it as a list properly without next pointers, but the copy method should still handle random.
        // Let's make it a proper list for realistic testing.
        Node nA_real = new Node(100);
        Node nB_real = new Node(200);
        Node nC_real = new Node(300);

        nA_real.next = nB_real;
        nB_real.next = nC_real;
        nC_real.next = null;

        nA_real.random = nC_real;
        nB_real.random = nA_real;
        nC_real.random = nB_real;

        System.out.println("Original List (Complex Randoms):");
        printList(nA_real, "Original List (Complex Randoms)");
        Node copiedComplex = solution.copyRandomList(nA_real);
        System.out.println("Copied List (Complex Randoms):");
        printList(copiedComplex, "Copied List (Complex Randoms)");
        System.out.println("Original List (Complex Randoms) After Copy:");
        printList(nA_real, "Original List (Complex Randoms)");
    }
}