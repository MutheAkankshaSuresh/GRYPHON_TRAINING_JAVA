import java.util.*;
public class Race_dis {
    public static void main(String args[])
    {
        Scanner sc=new Scanner (System.in);
        System.out.println("Enter the Distance Track");
        int dis=sc.nextInt();
       
        System.out.println("Enter A beat by B by how many seconds");
        int A_win_sec=sc.nextInt();

         System.out.println("Enter A beat by B by how many meters");
        int A_win_dis=sc.nextInt();

        int dis11=dis-A_win_dis;

        float speed=A_win_dis/A_win_sec;
        float A_Time11=dis11/speed;

        System.out.println("B is injured by how many meters less than half of the track");
        int B_injured=sc.nextInt();

        float half_dis=dis/2;
        float B_day2_dis=half_dis-B_injured;
        
        float TTime_B=B_day2_dis/speed;    

        float A_day2_dis=dis-B_day2_dis;

        float B_win_time=A_day2_dis/(speed/2);
       

        float finaltime=B_win_time-TTime_B;


        System.out.println("A wins by: "+finaltime);
        
    }
}




