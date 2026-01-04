import java.util.*;

public class Sunday_weekend {
    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter starting day (0=Sunday, 1=Monday, ..., 6=Saturday):");
        int startDay = sc.nextInt();

        System.out.println("Enter number of days in the month:");
        int n = sc.nextInt();

        int sundayCount = 0;

        for (int i = 0; i < n; i++) {
            if ((startDay + i) % 7 == 0) {
                sundayCount++;
            }
        }

        System.out.println("Number of Sundays Jack gets: " + sundayCount);
    }
}
    