package Stack_sort;
import java.util.*;
public class Stack_sort {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Integer> s1=new Stack();
      
       
       s1.push(20);
       s1.push(10);
       s1.push(50);
       s1.push(70);
       Stack<Integer> s2=new Stack();
       
            while(!s1.empty())
       {
          int temp=s1.pop();
          while(!s2.empty() && temp < s2.peek())
            {
                s1.push(s2.pop());
            }
            s2.push(temp);
       }

        while(!s2.empty())
       {
           s1.push(s2.pop());
      }
       System.out.println(s2);
	}

	}


