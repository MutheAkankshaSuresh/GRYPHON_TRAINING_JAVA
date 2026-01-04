import java.util.*;
import java.util.Scanner;
import java.util.Collection;
import java.util.Iterator;
import java.util.ArrayList;
public class DSA02
{
    public static void main(String[] args)
    {
       Scanner sc=new Scanner(System.in);
       int num;
       Integer o;
       Collection c=new ArrayList();
       
       System.out.println(" Enter Total Numbers");
       num=sc.nextInt();

       for(int i=1;i<=num;i++)
       {
           System.out.println("Enter "+i+" number");
           c.add(sc.nextInt());

       }
       Iterator it=c.iterator();
       while(it.hasNext())
       {
         o=(Integer)it.next();
         if(o<0)
         {
            System.out.println("Negative Numbers");
         }
         else
         {
            System.out.println("Positive Number");
         }
       }
    }
}