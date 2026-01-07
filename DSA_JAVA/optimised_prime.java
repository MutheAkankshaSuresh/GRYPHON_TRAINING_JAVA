//Sieve of Eratosthenes
public class optimised_prime
{
    public static void main(String args[])
    {
        int n=100;
        boolean[] arr=new boolean[n+1];
        for(int i=2;i*i<=n;i++)
        {
            for(int j=i*2;j<=n;j=j+i)
            {
                 if(!arr[j])
                 {
                    arr[j]=true;
                 }
            }
        }

        for(int k=2;k<=n;k++)
        {
            if(arr[k]==false)
            {
                System.out.println(k+" is prime number ");
            }
            else{
                 System.out.println(k+" is not prime number ");
            }
        }

        // int n=13;
        // int flag=0;
        // for(int i=2;i<n;i++)
        // {
        //     if(n%i==0)
        //     {
        //         flag=1;
        //         break;
        //     }
        // }

        // if(flag==1)
        // {
        //     System.out.println("not prime");
        // }

        // else{
        //     System.out.println("is prime");
        // }


    }
}



