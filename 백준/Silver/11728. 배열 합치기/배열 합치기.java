import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arrA = new int[n];
        int[] arrB = new int[m];
        for (int i = 0; i < n; i++) {
            arrA[i] = sc.nextInt();
        }
        for (int i = 0; i < m; i++) {
            arrB[i] = sc.nextInt();
        }

        StringBuilder sb = new StringBuilder();

        int p1 = 0, p2 = 0;
        while (true) {
            if (p1 == n && p2 == m) {
                break;
            } else if (p1 != n && p2 != m) {
                if (arrA[p1] <= arrB[p2]) {
                    sb.append(arrA[p1]).append(" ");
                    p1++;
                } else {
                    sb.append(arrB[p2]).append(" ");
                    p2++;
                }
            } else if (p1 != n && p2 == m) {
                sb.append(arrA[p1]).append(" ");
                p1++;
            } else if (p1 == n && p2 != m) {
                sb.append(arrB[p2]).append(" ");
                p2++;
            }
        }

        System.out.println(sb);
    }
}