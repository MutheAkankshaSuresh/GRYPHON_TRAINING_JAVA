
//worst time complexity
public class prime
{
    public static void main(String[] args)
    {
        int n=100;
        int flag=0;
        for(int i=2;i<=n;i++)
        {
            
            for(int j=2;j<=i*i;j++)
            {
                flag=0;
                if(i%j==0)
                {
                    flag=1;
                    break;
                }
                else
                {
                  flag=0;
                }
            }
            if(flag==1)
            {
                System.out.println(i+" is not prime");
            }
            else
            {
                System.out.println(i+" is prime");
            }
        }

        
}
}