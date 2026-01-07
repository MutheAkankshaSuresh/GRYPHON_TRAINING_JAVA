class Node1 {
    int val;
    Node1 next; 

    Node1(int val) { 
        this.val = val;
           this.next = null;
        
    }
}

public class Floudes_cycle {
    public static void main(String[] args) {
        Node1 head = new Node1(1);
        head.next=new Node1(2);
        head.next.next=new Node1(3);
        head.next.next.next=new Node1(4);
        head.next.next.next.next=new Node1(5);
        head.next.next.next.next.next=head.next;
         //print1(head);
         boolean hasCycle=detect(head);
         System.out.println("Is Cycle Detected OR not: "+hasCycle);
         print1(head);
    }
    
    static void print1(Node1 head)
    {
         Node1 temp=head;
         while(temp!=null)
         {
            System.out.println(temp.val);
            temp=temp.next;
         }

    }

    static boolean detect(Node1 head)
    {
         Node1 slow=head;
         Node1 fast=head;

          while(fast!=null && fast.next!=null)
          {
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast)
            {
                removeCycle(slow,head);
                return true;
            }
          }
          return false;
    }

    static void removeCycle(Node1 meet ,Node1 head)
    {
        //start a pointer from head
        //and use meeting point from cycle

        Node1 slow=head;
        //move both pointer one step at a time until
        //there .next reference match.
        //this identifies the node just before cycle
        //the start of the cycle
        while(slow.next!=meet.next)
        {
           slow=slow.next;
           meet=meet.next;

        }
        //break the cycle by setting the .next of the last node to null
        meet.next=null;
    }
}
