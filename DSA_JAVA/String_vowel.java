import java.util.Scanner;
public class String_vowel {
    public static void main(String args[])
    {
       Scanner sc=new Scanner(System.in);
       int vowel=0;
       int conso=0;
       System.out.println("Enter the String");
       String s=sc.nextLine();
       for(int i=0;i<s.length();i++)
       {
           char c=s.toLowerCase.charAt(i);
           if(c==' ')
           {
               
           }

           else if(c=='a' || c=='e' ||c=='i'||c=='o'||c=='u')
           {
               vowel++;
           }
           else
            {
                conso++;
            }
       }

       System.out.println("The the no of vowels are "+vowel);
        System.out.println("The the no of consonants are "+conso);
    }
}


// //for(char c:toCharArray())
// {

// }
