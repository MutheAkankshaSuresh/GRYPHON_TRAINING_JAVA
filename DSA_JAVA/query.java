import java.util.*;
public class query
{
   
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        
        System.out.println("Enter the number of elements in array");
        int n=sc.nextInt();
        int sum1=0;
        int sum2=0;
        int[] arr=new int[n];
        
        for(int i=0;i<n;i++)
        {
            System.out.println("Enter "+(i+1)+" Element");
            arr[i]=sc.nextInt();
        }    

        System.out.println("Enter the number of queries");
        int q=sc.nextInt();
        int [][] query=new int[q][3]; 

        for(int i=0;i<q;i++)
        {
                System.out.print("  Query "+(i+1) +"\n");
                System.out.println("Enter the Type of query");
                int type=sc.nextInt();
                query[i][0]=type;
                System.out.println("Enter the Left of query");
                int l=sc.nextInt();
                query[i][1]=l;
                System.out.println("Enter the Right of query");
                int r=sc.nextInt();
                query[i][2]=r;
                

               
            
        } 

         for(int i=0;i<q;i++)
        {
            if(query[i][0]==1)
                {
                    int ty=query[i][0];
                    int l=query[i][1];
                    int r=query[i][2];
                    for(int j=0;j<arr.length;j++)
                    {
                        arr[j]=(j-l+1)*arr[l];
                        sum1+=arr[j];
                    }
                } 

             else{
                for(int k=0;k<arr.length;k++)
                {
                    sum2+=arr[k];
                }
             }   
        }
        int res=sum1+sum2;

        System.out.println("The final Answer is"+res);



    }
}