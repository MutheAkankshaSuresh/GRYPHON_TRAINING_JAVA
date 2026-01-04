// 33. Given an integer array Arr of size N the task is to find the count of elements whose value is greater than all of its prior elements.

// Note: 1st element of the array should be considered in the count of the result.
import java.util.*;
public class Array_max {
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
         System.out.println("Enter the number of elements in array");
         int n=sc.nextInt();
         int[] arr=new int[n];
         for(int i=0;i<n;i++)
         {
            System.out.println("Enter "+(i+1)+" Element :");
            arr[i]=sc.nextInt();
         }
         int max1=arr[0];
         int count=1;
             
         for(int i=1;i<n;i++)
         {
            if(max1<arr[i])
            {
                count++;
                max1=arr[i];
            }
         }

         System.out.println("The result is "+count);

    }
    
}
