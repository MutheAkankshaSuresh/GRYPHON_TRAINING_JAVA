import java.util.*;

public class reverse_java {
    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string");
        String s = sc.nextLine();
        // String res=s;
        //char[] ch=new char[n];
        int start=0;
        int end=s.length()-1;
       
        //StringBuilderrrr
        StringBuilder sb=new StringBuilder(s);
        while(start<end)
        {
            char temp=sb.charAt(start);
            sb.setCharAt(start,sb.charAt(end));
            sb.setCharAt(end,temp);
            start++;
            end--;
        }
          String res=sb.toString();
          String[] word=res.split(" ");
          StringBuilder result = new StringBuilder();
          for(String word2:word)
          {
            
            StringBuilder sb2=new StringBuilder(word2);
            int start1=0;
            int end1=word2.length()-1;
            while(start1<end1)
            {
                char temp=sb2.charAt(start);
                sb2.setCharAt(start,sb2.charAt(end));
                sb2.setCharAt(end,temp);
                start1++;
                end1--;
            }
            
            result.append(sb).append(" ");
          }
          
          System.out.println(result.toString().trim());



    }
}
