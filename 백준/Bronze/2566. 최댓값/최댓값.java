import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] arr = new int[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int maxV = 0;
        int si = 1, sj = 1;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (maxV < arr[i][j]) {
                    maxV = arr[i][j];
                    si = i+1;
                    sj = j+1;
                }
            }
        }
        System.out.println(maxV);
        System.out.println(si + " " + sj);
    }
}