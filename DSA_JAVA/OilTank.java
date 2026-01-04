import java.util.Scanner;

public class OilTank {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // number of people
        int C = sc.nextInt(); // tank capacity
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int tank1=C;
        for(int i=0;i<N;i++)
        {
            if(arr[i]==1)
            {
                tank1-=1;
            }
            else{
                tank1+=1;
            }
        }

        if(tank1<=0)
        {
            System.out.println("Disturbance Occurs");
        }
        else if(tank1>C)
        {
             System.out.println("Disturbance Occurs");
        }
        else{
            System.out.println("No Disturbance Occurs");
        }

        // int prefixSum = 0;
        // int minPrefix = 0;

        // // Find minimum prefix sum
        // for (int i = 0; i < N; i++) {
        //     prefixSum += A[i];
        //     if (prefixSum < minPrefix) {
        //         minPrefix = prefixSum;
        //     }
        // }

        // // Minimum initial oil to avoid disturbances
        // int X = Math.min(Math.max(0, -minPrefix), C);

        // System.out.println(X);
        // sc.close();
    }
}
