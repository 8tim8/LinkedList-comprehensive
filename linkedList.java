/* LinkedList comprehensive: detect+remove loop, print+delete middle node,
count number of nodes, remove duplicate nodes, reverse nodes, get Nth item from last */
 import java.util.*;
public class LinkedList {
 
    static Node head;
 
    static class Node {
 
        int data;
        Node next;
 
        Node(int d) {
            data = d;
            next = null;
        }
    }
 
    int detectLoop(Node head) {
        Node slow=head, fast=head;
        while (fast!=null && fast.next!=null) {
            slow=slow.next;
            fast=fast.next.next;
            if (slow==fast) {
    System.out.println("found loop at node "+slow.data+" ,and loop removed");
removeLoop(slow, head);
                 return 1;
            }
        }//run when WHILE loop is false
           System.out.println("no loop");
        return 0;
    }
 void removeLoop(Node slow, Node head) {
        Node ptr1=null, ptr2=null;
        ptr1=head;
        while(1==1) { //while(true) works
            ptr2=slow;//1st ptr2.next!=ptr2
            while(ptr2.next!=slow&&ptr2.next!=ptr1){
                ptr2=ptr2.next;
            }
            if(ptr2.next==ptr1) {
                break;}
            ptr1=ptr1.next;
        }//assign null to loop, so removed
     ptr2.next=null;
    } 

 
    // Function to print the linked list
    static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
 public void printMiddle()
    {     Node slow=head;
        Node fast=head;
             while(fast!=null && fast.next!=null)
            {
                fast=fast.next.next;
                slow=slow.next;
            }//prints when while loop is false
            System.out.println("\nThe middle item is [" +
                                slow.data + "] \n");}


   public Node reverse(Node head) {
        Node prev=null;
        Node current=head;
        Node next=null;
        while (current!=null) {//swap 4 variables
          next=current.next;
          current.next=prev;
          prev=current;
          current=next;
        }
        head=prev;
         return head;
  }

public void removeDuplicate(Node head) 
    {
    
        HashSet<Integer>s=new HashSet<Integer>();
                    Node prev=null;
        while (head!=null) //if..else nested in while
        { // If s has head value,.next is move on 
            if (s.contains(head.data)) {
                prev.next=head.next;
            } else {//s add head value,store head to prev
                s.add(head.data);
                prev=head;
            }
            head=head.next;//move on, til head==null
         } 
         
    }

    public void CountR()
    {
 System.out.println("\nUse Recursion,Count of nodes is: " +CountRec(head));
    }
public int CountRec(Node head)
    {   if (head==null)
            return 0;
        return 1+CountRec(head.next);
    }
 

     public void CountIteration()
    {     Node temp=head;
        int count=0;
        while (temp!=null)
        {
            count++;
            temp=temp.next;
        }
    System.out.println("\nUse Iteration,Count of nodes is: " +count);
    }

void printNthFromLast(int n)
    { int count=0;
        Node temp=head;
  
        while(temp!=null)
        {
            temp=temp.next;
            count++;
        } 
// n can’t be > count
        if (n>count)
            return;
        temp=head;
        for (int i=0; i<count-n; i++)
            temp=temp.next;
 System.out.println("The "+n+" th item from last is: "+temp.data);}

public void deleteMiddle() {
 
        int count=0;
        int DeleteIndex=0;
        Node node=head;
        Node temp=head;
     // find list size
        while(node!=null) {//while is loop, if not loop
            count++;
            node=node.next;
        }
  // getting the n/2 index of the node which needs to be deleted
        DeleteIndex=(count/2)-1;
        for(int i=0; i<DeleteIndex; i++){
            temp=temp.next;
        }//evetually .next will be null, so deleted
        temp.next=temp.next.next;
      System.out.println("After middle item deleted:" );
      printList(head);
}

 
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.head = new Node(10);
        list.head.next = new Node(2);
        list.head.next.next = new Node(5);
        list.head.next.next.next = new Node(10);
    list.head.next.next.next.next = new Node(8);
         //make a loop 
        head.next.next.next.next.next = head.next.next;
        list.detectLoop(head);
        System.out.println("Original Linked List: ");
        list.printList(head);
        list.printMiddle();
        
        list.deleteMiddle();
 head=list.reverse(head);
System.out.println();
        System.out.println("Reversed linked list: ");
        list.printList(head);
        
        System.out.println("\nLinked list before removing duplicates:");
        list.printList(head);
        
       list.removeDuplicate(head);
        System.out.println("\nLinked list after removing duplicates:");
       list.printList(head);
       
list.CountR();
list.CountIteration();
list.printNthFromLast(2);

    }
}

/* output
found loop at node 10 ,and loop removed
Original Linked List: 
10 2 5 10 8 
The middle item is [5] 

After middle item deleted:
10 2 10 8 
Reversed linked list: 
8 10 2 10 
Linked list before removing duplicates:
8 10 2 10 
Linked list after removing duplicates:
8 10 2 
Use Recursion,Count of nodes is: 3

Use Iteration,Count of nodes is: 3
The 2 th item from last is: 10
*/