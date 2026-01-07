import java.util.*;
public class DSA01 {

    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n;
        String cn;
        Collection c=new ArrayList();
        System.out.println("Enter the no of cities you want to eneter");
        n=sc.nextInt();
        for(int i=1;i<=n;i++)
        {
            System.out.println("Enter the "+i+" City");
            cn=sc.next();
            c.add(cn);

        }

        System.out.println("Your City name is: "+c);
       

    }
    
}
