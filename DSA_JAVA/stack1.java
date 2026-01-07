import java.util.*;
public class stack1 {
    public static void main(String args[])
    {
       //real example: When will open multiple application and at the time of closing we last application come first that first we have to access then other
       Stack<Integer> s1=new Stack();
      
       
       s1.push(20);
       s1.push(10);
       s1.push(50);
       s1.push(70);
       Stack<Integer> s2=new Stack();
       s2.push(s1.peek());
       s1.pop();
       while(!s1.empty())
       {
           if(s1.peek()>s2.peek())
           {
             s2.push(s1.peek());
           }
           else{
             int x=s2.peek();
             s2.pop();
             s2.push(s1.peek());
             s2.push(x);
           }
       }
       System.out.println(s2);


         
    }
}
