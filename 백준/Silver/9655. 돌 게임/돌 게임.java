import java.util.*;

public class Main {
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int round = 0;

        while (n > 0) {
            if (n >= 3) n -= 3;
            else n -= 1;

            round++;
        }

        if (round % 2 == 1) System.out.println("SK");
        else System.out.println("CY");
    }
}