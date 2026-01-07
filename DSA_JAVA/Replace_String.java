import java.util.Scanner;

public class Replace {
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        String s;
        char r,n;
        String new1="";
        System.out.println("Enter the String");
        s=sc.nextLine();
        System.out.println("Enter the character which you want replace to");
        r=sc.next().charAt(0);
        System.out.println("Enter the new character which you want replace");
        n=sc.next().charAt(0);;
        for(char h:s.toCharArray())
        {
            if(h==r)
            {

                new1+=n;
                new1+=n;
            }
            else{
                new1+=h;
            }
        }

       System.out.println(new1);
    }
    
}
